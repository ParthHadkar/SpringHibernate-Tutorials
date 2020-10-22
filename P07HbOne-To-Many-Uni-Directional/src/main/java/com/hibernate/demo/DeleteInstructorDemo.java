package com.hibernate.demo;

import com.hibernate.dao.InstructorDao;

public class DeleteInstructorDemo {
	public static void main(String[] args) {
		InstructorDao.deleteInstructorUsingId(1);
	}
}
