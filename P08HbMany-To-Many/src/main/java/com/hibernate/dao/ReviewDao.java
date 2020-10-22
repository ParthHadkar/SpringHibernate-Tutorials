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

public class ReviewDao {
	
	public static void saveReview(String reviewTxt,int courseId) {
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
			//Get the Course Object
			Course course = (Course) session.get(Course.class, courseId);
			//Create a Objects
			System.out.println("Creating The Objects");
			Review review = new Review(reviewTxt);
			//Add Review to Course
			course.addReview(review);
			//Save the object
			System.out.println("Saving The Object");
			System.out.println("Review "+review);
			session.save(review);//session.persist(student);
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
	
	public static int saveReviewRtn(String reviewTxt,int courseId) {
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
			//Get the Course Object
			Course course = (Course) session.get(Course.class, courseId);
			//Create a Objects
			System.out.println("Creating The Objects");
			Review review = new Review(reviewTxt);
			//Add Review to Course
			course.addReview(review);
			//Save the object
			System.out.println("Saving The Object");
			System.out.println("Review "+review);
			int id1 = (Integer)session.save(review);//session.persist(student);
			id = course.getId();//id1
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
	
	public static void readInstructorCoursesReviewUsingId(int courseId) {
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
			//Get the Course Object
			Course course = (Course) session.get(Course.class, courseId);
			//Print the Course
			System.out.println("Course: "+course);
			//Print the Review for Course 
			System.out.println("Reviews: "+course.getReviewsList());
			//commit the transaction
			tx.commit();
			System.out.println("Courses Reviews Readed Successfully!!!! ");
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
	
	public static void deleteCourseReviewUsingId(int id) {
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
			//Get the Review Object
			Review review = (Review) session.get(Review.class, id);
			//Print the Review
			System.out.println("reading Review "+review);
			//Delete the Review Object
			session.delete(review);
			//commit the transaction
			tx.commit();
			System.out.println("Review Deleted Successfully!!!! ");
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
