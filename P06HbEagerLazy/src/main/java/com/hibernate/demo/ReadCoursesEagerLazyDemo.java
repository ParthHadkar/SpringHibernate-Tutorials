package com.hibernate.demo;

import com.hibernate.dao.CourseEagerLazyDao;

public class ReadCoursesEagerLazyDemo {
	public static void main(String[] args) {
		//CourseEagerLazyDao.readInstructorCoursesUsingId(1);
		//CourseEagerLazyDao.readInstructorCoursesOption1UsingId(1);
		//CourseEagerLazyDao.readInstructorCoursesOption2UsingId(1);
		CourseEagerLazyDao.getCoursesLater(1);
	}
}
