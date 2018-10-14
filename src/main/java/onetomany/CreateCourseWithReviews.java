package onetomany;

import onetoone.Instructor;
import onetoone.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseWithReviews {

    public static void main(String[] args) {

        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        try {

            CourseMTO newCourse = new CourseMTO("Swimming course");
            newCourse.addReview(new Review("the best course in my life"));
            newCourse.addReview(new Review("I have never seen this course"));

            session.beginTransaction();
            session.save(newCourse);
            session.getTransaction().commit();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();}
    }
}
