package onetoone;


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
            Instructor instructor =
                    new Instructor("first name", "last name", "email");

            InstructorDetail instructorDetail =
                    new InstructorDetail("youtube chaneell", "The BeST Hobby");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();
            //insert new InstructorMTO
            // session.save(instructor);

            //delete the instructor
//            InstructorMTO inst = session.get(InstructorMTO.class,1);
//            if(inst!=null){
//                System.out.println("Delete: " + inst);
//                session.delete(inst);
//            }


            InstructorDetail instructorDetail1 = session.get(InstructorDetail.class, 5);
            if (instructorDetail1 != null) {
                System.out.println(instructorDetail1.getInstructor());
                session.getTransaction().commit();
            }else{
                System.out.println("InstructorMTO not found");
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();}
    }

}
