package com.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import com.hibernate.DateUtils;
import com.hibernate.dao.StudentDao;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		String dateOfBirthStr = "06/12/1995";
		Date dateOfBirth = null;
		try {
			dateOfBirth = DateUtils.parseDate(dateOfBirthStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StudentDao.saveStudent("nikhil", "etame", "nikhil@gmail.com",dateOfBirth);
		StudentDao.saveStudent("deepak", "phejale", "deepak@gmail.com",dateOfBirth);
		StudentDao.saveStudent("parth", "hadkar", "parth@gmail.com",dateOfBirth);
	}

}
