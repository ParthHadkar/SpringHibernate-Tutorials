package com.hibernate.demo;

import com.hibernate.dao.CourseDao;
import com.hibernate.dao.InstructorDao;

public class DeleteCourseDemo {
	public static void main(String[] args) {
		CourseDao.deleteCourseUsingId(11);
	}
}
