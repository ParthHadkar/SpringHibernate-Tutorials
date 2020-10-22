package com.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import com.hibernate.DateUtils;
import com.hibernate.dao.CourseDao;
import com.hibernate.dao.InstructorDao;

public class CreateCourseAndReviewDemo {
	public static void main(String[] args)  {
		CourseDao.saveCourseAndReview("Cs 1.6", "Good Course");
	}
}
