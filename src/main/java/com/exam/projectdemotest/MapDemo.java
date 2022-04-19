package com.exam.projectdemotest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class MapDemo {
	
public static void main(String[] args) {
	

		Configuration cfg=new Configuration();
		cfg.configure();
		//cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.buildSessionFactory();

		Category c1=new Category();
		c1.setCid(11);
		c1.setCategory("OK");
		//List<Products> storyList = new ArrayList<>();
		// create first story
		
	
		// create second story
		Products p2 = new  Products();
		p2.setPid(2);
		p2.setProduct("jj");
		p2.setCategory(c1);


		Products p3 = new  Products();
		p3.setPid(3);
		p3.setProduct("jj");
		p3.setCategory(c1);
		
		

		List<Products> list=new ArrayList<>();
		//list.add(p1);
		list.add(p2);
		list.add(p3);
		c1.setCategory(list);
		Session s= factory.openSession();
		Transaction tx=s.beginTransaction();
		s.save(c1);
		tx.commit();
		
	

	}




}