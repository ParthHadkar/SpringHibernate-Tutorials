package com.hibernate.demo;

import com.hibernate.dao.InstructorDetailDao;

public class DeleteInstructorDetailDemo {
	public static void main(String[] args) {
		//InstructorDetailDao.deleteInstructorDetailUsingId(3);
		InstructorDetailDao.deleteInstructorDetailOnlyUsingId(3);
	}
}
