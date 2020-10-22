package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.model.entity.Course;
import com.hibernate.model.entity.Instructor;
import com.hibernate.model.entity.InstructorDetail;

public class CourseEagerLazyDao {
	
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
					.buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Get the Instructor Object
			Instructor instructor = (Instructor) session.get(Instructor.class, instructorId);
			//Print the Instructor
			System.out.println("LuvTOCode: Instructor: "+instructor);
			//Print the Courses for Instructor 
			System.out.println("LuvTOCode: Courses: "+instructor.getCoursesList());
			//commit the transaction
			tx.commit();
			System.out.println("LuvTOCode: Instructor Courses Readed Successfully!!!! ");
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
	
	public static void readInstructorCoursesOption1UsingId(int instructorId) {
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
					.buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Get the Instructor Object
			Instructor instructor = (Instructor) session.get(Instructor.class, instructorId);
			//Print the Instructor
			System.out.println("LuvTOCode: Instructor: "+instructor);
			//Print the Courses for Instructor 
			System.out.println("LuvTOCode: Courses: "+instructor.getCoursesList());
			
			//commit the transaction
			tx.commit();
			//close the session
			session.close();
			
			System.out.println("\nLuvTOCode: The session is now closed\n");
			//Since course are lazy loaded .... this should fail
			
			//Option 1:call getter method while session is open
			//because i will get loaded in memory when session was open and than recall it.
			//Print the Courses for Instructor 
			System.out.println("LuvTOCode: Courses: "+instructor.getCoursesList());
			
			System.out.println("LuvTOCode: Instructor Courses Readed Successfully!!!! ");
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
	
	public static void readInstructorCoursesOption2UsingId(int instructorId) {
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
					.buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			// Hibernate query with HQL
			// Create a query
			Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i JOIN FETCH i.coursesList WHERE i.id=:instructorId"
					,Instructor.class
					);
			// Set Parameter of query
			query.setParameter("instructorId", instructorId);
			//Execute The Query And Get the Instructor Object
			Instructor instructor = query.getSingleResult();
			//Print the Instructor
			System.out.println("LuvTOCode: Instructor: "+instructor);
			
			//commit the transaction
			tx.commit();
			//close the session
			session.close();
			
			System.out.println("\nLuvTOCode: The session is now closed\n");
			//Print the Courses for Instructor 
			System.out.println("LuvTOCode: Courses: "+instructor.getCoursesList());
			
			System.out.println("LuvTOCode: Instructor Courses Readed Successfully!!!! ");
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
	
	
	public static void getCoursesLater(int instructorId) {
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
					.buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, instructorId);        
			//Print the Instructor
			System.out.println("LuvTOCode: Instructor: "+instructor);
			
			//commit the transaction
			tx.commit();
			//close the session
			session.close();
			


            //
            // THIS HAPPENS SOMEWHERE ELSE / LATER IN THE PROGRAM

            // YOU NEED TO GET A NEW SESSION
            //
            
            System.out.println("\n\nluv2code: Opening a NEW session \n");

            session = sf.getCurrentSession();
            
            session.beginTransaction();
            
            // get courses for a given instructor
            Query<Course> query = session.createQuery("select c from Course c "
                                                    + "where c.instructor.id=:theInstructorId",    
                                                    Course.class);
            
            query.setParameter("theInstructorId", instructorId);
            
            List<Course> coursesList = query.getResultList();
            
            System.out.println("Courses List: " + coursesList);
            
            // now assign to instructor object in memory
            instructor.setCoursesList(coursesList);
            
            System.out.println("luv2code: Courses: "+instructor.getCoursesList());
			
			System.out.println("LuvTOCode: Instructor Courses Readed Successfully!!!! ");
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
					.buildSessionFactory();
			session = sf.getCurrentSession();//sf.openSession();
			//Start a transaction
			System.out.println("Starting Transaction");
			Transaction tx = session.beginTransaction();
			//Get the Course Object
			Course course = (Course) session.get(Course.class, id);
			//Print the Course
			System.out.println("reading Instructor "+course);
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
