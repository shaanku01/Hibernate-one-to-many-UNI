package shanker.assignment.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

    public static void main(String args[]){
        //create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        //create Session
        Session session = factory.getCurrentSession();

        try{
            //Start the transaction
            session.beginTransaction();

            //create a course
            // create reviews and add them to course
            //save the course

            Course tempCourse = new Course("Maths");
            Review review1 = new Review("Good subject");
            Review review2 = new Review("Great Subject");


            tempCourse.add(review1);
            tempCourse.add(review2);

            session.save(tempCourse);





            //commit the transaction:
            session.getTransaction().commit();


        }finally {

            session.close();
            factory.close();
        }


    }
}
