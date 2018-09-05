package onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class CourseMTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "instructor_id")
    private InstructorMTO instructor;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private List<Review> reviewList;

    public CourseMTO() {
    }

    public CourseMTO(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InstructorMTO getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorMTO instructor) {
        this.instructor = instructor;
    }

    public void addReview(Review review){
        if(reviewList ==null){
            reviewList =new ArrayList<Review>();
        }
        reviewList.add(review);
    }

    @Override
    public String toString() {
        return "CourseMTO: " +
                "title: " + title;
    }
}
