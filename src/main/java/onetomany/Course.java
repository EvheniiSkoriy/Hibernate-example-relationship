package onetomany;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "instructor_id")
    private InstructorMTO instructor;

    public Course() {
    }

    public Course(String title) {
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

    @Override
    public String toString() {
        return "Course: " +
                "title: " + title;
    }
}