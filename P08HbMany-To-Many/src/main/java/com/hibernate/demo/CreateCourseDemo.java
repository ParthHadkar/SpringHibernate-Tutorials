package com.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import com.hibernate.DateUtils;
import com.hibernate.dao.CourseDao;
import com.hibernate.dao.InstructorDao;

public class CreateCourseDemo {
	public static void main(String[] args)  {
		//CourseDao.saveCourse("Cs Global Ultimate  Guide", 1);
		//CourseDao.saveStudentAndCourse("nitin", "ghadi", "nitin@gmail.com",dateOfBirth,"Cs zero");
		CourseDao.saveCourseAndAddStudent(19, "Cs Global Ultimate  Guide");
	}
}
