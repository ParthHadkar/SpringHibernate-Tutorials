package com.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import com.hibernate.DateUtils;
import com.hibernate.dao.CourseDao;
import com.hibernate.dao.InstructorDao;
import com.hibernate.dao.ReviewDao;

public class CreateReviewDemo {
	public static void main(String[] args)  {
		ReviewDao.saveReview("Excellent Work", 10);
	}
}
