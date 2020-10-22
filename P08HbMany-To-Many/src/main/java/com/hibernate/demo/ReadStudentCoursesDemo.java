package com.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import com.hibernate.DateUtils;
import com.hibernate.dao.StudentDao;

public class ReadStudentCoursesDemo {
	public static void main(String[] args) {
		StudentDao.readStudentAndCourses(19);
	}
}
