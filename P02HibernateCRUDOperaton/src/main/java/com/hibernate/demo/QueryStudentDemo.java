package com.hibernate.demo;

import com.hibernate.dao.StudentDao;

public class QueryStudentDemo {
	public static void main(String[] args) {
		StudentDao.getStudent();
		StudentDao.getStudentLastName("ghadi");
		StudentDao.getStudentFirstORLastName("rishi", "ghadi");
		StudentDao.getStudentLikeEmail("%@gmail.com");
	}
}
