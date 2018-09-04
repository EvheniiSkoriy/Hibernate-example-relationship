package onetomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructor {

    public static void main(String[] args) {

        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        try {


            session.beginTransaction();

            //add new courses to instruction with id = 3
//            InstructorMTO instructorMTO = session.get(InstructorMTO.class,3);
//            Course algb = new Course("Algebra");
//            Course biog = new Course("Biology");
//
//            instructorMTO.addCourse(algb);
//            instructorMTO.addCourse(biog);
//
//            session.save(algb);
//            session.save(biog);


            //delete course with id = 1
//            Course course=session.get(Course.class,1);
//            System.out.println("Deleting: "+ course);
//            session.delete(course);
//
            session.getTransaction().commit();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();}
    }

}
