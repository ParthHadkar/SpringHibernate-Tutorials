package com.hibernate.demo;

import com.hibernate.dao.CourseDao;
import com.hibernate.dao.InstructorDetailDao;

public class ReadInstructorCoursesDemo {
	public static void main(String[] args) {
		CourseDao.readInstructorCoursesUsingId(1);
	}
}
