package com.hibernate.dao;

import java.util.Date;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.SessionFactoryServiceRegistryBuilderImpl;

import com.hibernate.model.entity.Course;
import com.hibernate.model.entity.Instructor;
import com.hibernate.model.entity.InstructorDetail;
import com.hibernate.model.entity.Review;
import com.hibernate.model.entity.Student;

public class InstructorDao {

	public static void saveInstructor(String firstName,String lastName,String email,String youtubeChannel,String hobby) {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object Instructor");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class)
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Create a Objects
			System.out.println("Creating The Objects");
			Instructor instructor = new Instructor(firstName, lastName, email);
			InstructorDetail instructorDetail = new InstructorDetail(youtubeChannel, hobby);
			//Associate the Objects
			instructor.setInstructorDetail(instructorDetail);
			//Save the object
			System.out.println("Saving The Object");
			System.out.println("Instructor "+instructor);
			session.save(instructor);//session.persist(student);
			//commit the transaction
			tx.commit();
			System.out.println("Instructor Inserted Successfully!!!!");
		}
		catch (Exception e) {
			sf.close();
			e.printStackTrace();
		}
		finally {
			//session.flush();
			session.close();
			sf.close();
		}
		
	}
	
	public static int saveInstructorRtn(String firstName,String lastName,String email,String youtubeChannel,String hobby) {
		SessionFactory sf = null;
		Session session = null;
		int id = 0;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class)
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Create a Object
			System.out.println("Creating A Object");
			//Create a Objects
			System.out.println("Creating The Objects");
			Instructor instructor = new Instructor(firstName, lastName, email);
			InstructorDetail instructorDetail = new InstructorDetail(youtubeChannel, hobby);
			//Associate the Objects
			instructor.setInstructorDetail(instructorDetail);
			//Save the object
			System.out.println("Saving The Instructor Object");
			// Note :This will also save the instructor details object
			// because of CasecadeType.ALL
			System.out.println("Instructor "+instructor);
			int id1 = (Integer)session.save(instructor);//session.persist(student);
			id = instructor.getId();//id1
			//commit the transaction
			tx.commit();
			System.out.println("Instructor Inserted Successfully!!!!");
		}
		catch (Exception e) {
			sf.close();
			e.printStackTrace();
		}
		finally {
			//session.flush();
			session.close();
			sf.close();
		}
		return id;	
	}
	
	public static void deleteInstructorUsingId(int id) {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class)
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			Instructor instructor = (Instructor) session.get(Instructor.class, id);
			//delete the object
			if(instructor != null) {
				System.out.println("Deleting Instructor "+instructor);
				// Note: this will also delete the Instructor Details Object because of CasecadeType.ALL
				session.delete(instructor); 
			}
			
			//commit the transaction
			tx.commit();
			System.out.println("Instructor Deleted Successfully!!!! ");
		}
		catch (Exception e) {
			sf.close();
			e.printStackTrace();
		}
		finally {
			//session.flush();
			session.close();
			sf.close();
		}
		
	}
	
}
