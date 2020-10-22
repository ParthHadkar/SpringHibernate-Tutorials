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

import com.hibernate.model.entity.Student;

public class StudentDao {

	public static void saveStudent(String firstName,String lastName,String email,Date dateOfBirth) {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Student.class).buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Create a Object
			System.out.println("Creating A Object");
			Student student = new Student(firstName, lastName, email,dateOfBirth);
			//Save the object
			System.out.println("Saving The Object");
			System.out.println("Student "+student);
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
	
	public static int saveStudentRtn(String firstName,String lastName,String email,Date dateOfBirth) {
		SessionFactory sf = null;
		Session session = null;
		int id = 0;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Student.class).buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Create a Object
			System.out.println("Creating A Object");
			Student student = new Student(firstName, lastName, email,dateOfBirth);
			//Save the object
			System.out.println("Saving The Object");
			System.out.println("Student "+student);
			int id1 = (Integer)session.save(student);
			id = student.getId();//id1
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
		return id;
		
	}
	
	public static void readStudent(int id) {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Student.class).buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Read a Object
			System.out.println("reading A Object using Id "+id);
			Student student = (Student)session.get(Student.class, id);
			System.out.println("Student "+student);
			//commit the transaction
			tx.commit();
			System.out.println("Student Readed Successfully!!!!");
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
	
	public static void getStudent() {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Student.class).buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Create a query
			Query<Student> query = session.createQuery("FROM Student");
			List<Student> studentList = query.getResultList();
			//fetching result
			for(Student tempStudent:studentList) {
				System.out.println(tempStudent);
			}
			//commit the transaction
			tx.commit();
			System.out.println("Students Fetch Successfully!!!!");
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
	
	public static void getStudentLastName(String lastName) {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Student.class).buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Create a query
			Query<Student> query = session.createQuery("FROM Student s WHERE s.lastName=:lName");
			query.setParameter("lName", lastName);
			List<Student> studentList = query.getResultList();
			//fetching result
			for(Student tempStudent:studentList) {
				System.out.println(tempStudent);
			}
			//commit the transaction
			tx.commit();
			System.out.println("Students Fetch Successfully!!!!");
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
	
	public static void getStudentFirstORLastName(String firstName,String lastName) {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Student.class).buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Create a query
			Query<Student> query = session.createQuery("FROM Student s WHERE s.lastName=:lName"
					+ " OR s.firstName=:fName");
			query.setParameter("lName", lastName);
			query.setParameter("fName", firstName);
			List<Student> studentList = query.getResultList();
			//fetching result
			for(Student tempStudent:studentList) {
				System.out.println(tempStudent);
			}
			//commit the transaction
			tx.commit();
			System.out.println("Students Fetch Successfully!!!!");
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
	
	public static void getStudentLikeEmail(String email) {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Student.class).buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Create a query
			Query<Student> query = session.createQuery("FROM Student s WHERE s.email LIKE :email");
			query.setParameter("email", email);
			List<Student> studentList = query.getResultList();
			//fetching result
			for(Student tempStudent:studentList) {
				System.out.println(tempStudent);
			}
			//commit the transaction
			tx.commit();
			System.out.println("Students Fetch Successfully!!!!");
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
	
	public static void updateStudentNameAndEmail(String firstName,String email,int id) {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Student.class).buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			Student student = session.get(Student.class, id);
			System.out.println("Updating Student");
			student.setFirstName(firstName);
			//session.update(student);// not needed to explicitly to use update() as we are commiting the transaction 
			//Create a query
			Query<Student> query = session.createQuery("UPDATE Student s SET s.email=:email WHERE s.id=:id");
			query.setParameter("email", email);
			query.setParameter("id", id);
			int status = query.executeUpdate();
			//commit the transaction
			tx.commit();
			System.out.println("Students Updated Successfully!!!! "+status);
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
	
	public static void deleteStudentUsingId(int id0,int id1) {
		SessionFactory sf = null;
		Session session = null;
		try {
			//Create session object
			System.out.println("Creating Session Object");
			Configuration con = new Configuration().configure("hibernate.cfg.xml");//not needed if name is same as hibernate.cfg.xml
			//use addAnnotatedClass() if mapping class not define in cfg file and add() if mapping resource not define i cfg file
			sf = con.addAnnotatedClass(Student.class).buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			Student student = session.get(Student.class, id0);
			System.out.println("Deleting Student");
			session.delete(student); 
			//Create a query
			Query<Student> query = session.createQuery("DELETE FROM Student s WHERE s.id=:id");
			query.setParameter("id", id1);
			int status = query.executeUpdate();
			//commit the transaction
			tx.commit();
			System.out.println("Students Deleted Successfully!!!! "+status);
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
