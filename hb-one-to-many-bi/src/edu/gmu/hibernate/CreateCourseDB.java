package edu.gmu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.gmu.hibernate.entity.Course;
import edu.gmu.hibernate.entity.Instructor;
import edu.gmu.hibernate.entity.InstructorDetail;

public class CreateCourseDB {

	public static void main(String[] args) {

		// create session factory.
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start transaction.
			session.beginTransaction();
			
			// get the instructor form db
			int id = 1;
			Instructor aInstructor = session.get(Instructor.class, id);
			System.out.println("Found instructor: " + aInstructor);
			
			// create some courses.
			Course aCourse1 = new Course("IT 390: Rapid Development of Scalable Cloud Applications");
			Course aCourse2 = new Course("IT 331: Web Development I");
			
			// add courses to instructor.
			aInstructor.add(aCourse1);
			aInstructor.add(aCourse2);
			
			// save the courses.
			session.save(aCourse1);
			session.save(aCourse2);
			
			// commit the transaction.
			session.getTransaction().commit();
			System.out.println("Done!");
		} 
		finally {
			// add clean up code.
			session.close();
			factory.close();
		}
	}
}
