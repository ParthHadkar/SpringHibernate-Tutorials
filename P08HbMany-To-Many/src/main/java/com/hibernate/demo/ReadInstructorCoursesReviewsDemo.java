package com.hibernate.demo;

import com.hibernate.dao.CourseDao;
import com.hibernate.dao.InstructorDetailDao;
import com.hibernate.dao.ReviewDao;

public class ReadInstructorCoursesReviewsDemo {
	public static void main(String[] args) {
		ReviewDao.readInstructorCoursesReviewUsingId(10);
	}
}
