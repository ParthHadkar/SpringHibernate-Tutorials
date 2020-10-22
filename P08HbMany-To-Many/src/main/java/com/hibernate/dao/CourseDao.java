package com.hibernate.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.entity.Course;
import com.hibernate.model.entity.Instructor;
import com.hibernate.model.entity.InstructorDetail;
import com.hibernate.model.entity.Review;
import com.hibernate.model.entity.Student;

public class CourseDao {
	
	public static void saveCourse(String title,int instructorId) {
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
			//Get the Instructor Object
			Instructor instructor = (Instructor) session.get(Instructor.class, instructorId);
			//Create a Objects
			System.out.println("Creating The Objects");
			Course course = new Course(title);
			//Add Course to Instructor
			instructor.add(course);
			//Save the object
			System.out.println("Saving The Object");
			System.out.println("Course "+course);
			session.save(course);//session.persist(student);
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
	
	public static void saveCourseAndReview(String title,String reviewTxt) {
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
			Course course = new Course(title);
			Review review = new Review(reviewTxt);
			//Add Review to Course
			course.addReview(review);
			//Save the object
			System.out.println("Saving The Object");
			System.out.println("Course "+course);
			System.out.println("Review "+course.getReviewsList());
			session.save(course);//session.persist(student);
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
	
	public static void saveStudentAndCourse(String firstName,String lastName,String email,Date dateOfBirth,String title) {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Student.class)
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class)
					.buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Create a Object
			System.out.println("Creating A Object");
			Course course = new Course(title);
			System.out.println("Course "+course);
			session.save(course);
			Student student = new Student(firstName, lastName, email,dateOfBirth);
			//Add Student to the Course
			course.addStudent(student);
			//Save the object
			System.out.println("Saving The Object");
			System.out.println("Student "+student);
			System.out.println("Students "+course.getStudentsList());
			//System.out.println("Courses "+student.getCoursesList());
			session.save(student);//session.persist(student);
			//commit the transaction
			tx.commit();
			System.out.println("Student Inserted Successfully!!!!");
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
	
	public static void saveCourseAndAddStudent(int studentId,String title) {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Student.class)
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class)
					.buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Read a Object
			System.out.println("reading A Object using Id "+studentId);
			Student student = (Student)session.get(Student.class, studentId);
			System.out.println("Student "+student);
			Course course = new Course(title);
			//Add Student to the Course
			course.addStudent(student);
			//Save the object
			System.out.println("Saving The Object");
			System.out.println("Student "+student);
			System.out.println("Students "+course.getStudentsList());
			session.save(course);//session.persist(student);
			//commit the transaction
			tx.commit();
			System.out.println("Student Inserted Successfully!!!!");
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
	
	public static int saveInstructorRtn(String title,int instructorId) {
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
			//Get the Instructor Object
			Instructor instructor = (Instructor) session.get(Instructor.class, instructorId);
			//Create a Objects
			System.out.println("Creating The Objects");
			Course course = new Course(title);
			//Add Course to Instructor
			instructor.add(course);
			//Save the object
			System.out.println("Saving The Object");
			System.out.println("Course "+course);
			int id1 = (Integer)session.save(course);//session.persist(student);
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
	
	public static void readInstructorCoursesUsingId(int instructorId) {
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
			//Get the Instructor Object
			Instructor instructor = (Instructor) session.get(Instructor.class, instructorId);
			//Print the Instructor
			System.out.println("Instructor: "+instructor);
			//Print the Courses for Instructor 
			System.out.println("Courses: "+instructor.getCoursesList());
			//commit the transaction
			tx.commit();
			System.out.println("Instructor Courses Readed Successfully!!!! ");
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
	
	public static void deleteCourseUsingId(int id) {
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
			Course course = (Course) session.get(Course.class, id);
			//Print the Course
			System.out.println("reading Instructor "+course);
			//Print the Review for Course 
			System.out.println("Reviews: "+course.getReviewsList());
			
			//Delete the Course Object
			session.delete(course);
			//commit the transaction
			tx.commit();
			System.out.println("Course Deleted Successfully!!!! ");
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
