package com.hibernate.demo;

import com.hibernate.dao.StudentDao;
import com.hibernate.model.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		StudentDao.updateStudentNameAndEmail("sam","sam@gmail.com",7);
	}
}
