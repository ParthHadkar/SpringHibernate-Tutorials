package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.entity.Course;
import com.hibernate.model.entity.Instructor;
import com.hibernate.model.entity.InstructorDetail;
import com.hibernate.model.entity.Review;
import com.hibernate.model.entity.Student;

public class InstructorDetailDao {
	
	public static void readInstructorDetailUsingId(int id) {
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
			//Get the Instructor Detail Object
			InstructorDetail instructorDetail = (InstructorDetail) session.get(InstructorDetail.class, id);
			//Print the Instructor Detail
			System.out.println("reading Instructor Detail "+instructorDetail);
			//Print the associate Instructor
			System.out.println("reading associate Instructor "+instructorDetail.getInstructor());
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
	
	public static void deleteInstructorDetailUsingId(int id) {
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
			//Get the Instructor Detail Object
			InstructorDetail instructorDetail = (InstructorDetail) session.get(InstructorDetail.class, id);
			//Print the Instructor Detail
			System.out.println("reading Instructor Detail "+instructorDetail);
			//Print the associate Instructor
			System.out.println("reading associate Instructor "+instructorDetail.getInstructor());
			//Delete the Instructor Details Object
			// Note: this will also delete the Instructor Object because of CasecadeType.ALL
			session.delete(instructorDetail);
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
	
	public static void deleteInstructorDetailOnlyUsingId(int id) {
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
			//Get the Instructor Detail Object
			InstructorDetail instructorDetail = (InstructorDetail) session.get(InstructorDetail.class, id);
			//Print the Instructor Detail
			System.out.println("reading Instructor Detail "+instructorDetail);
			//Print the associate Instructor
			System.out.println("reading associate Instructor "+instructorDetail.getInstructor());
			//Delete the Instructor Details Object
			
			//Remove the associated object reference
			//Break the Bi-Directional Link
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
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
