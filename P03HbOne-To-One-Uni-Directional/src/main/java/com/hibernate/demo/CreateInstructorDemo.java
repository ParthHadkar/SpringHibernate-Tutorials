package com.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import com.hibernate.DateUtils;
import com.hibernate.dao.InstructorDao;

public class CreateInstructorDemo {
	public static void main(String[] args)  {
		InstructorDao.saveInstructor("parth", "hadkar", "parth@gmail.com","www.youtube.com","love to code");
	}
}
