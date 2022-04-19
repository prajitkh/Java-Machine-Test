package com.projectcontroller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exam.projectdemotest.Category;
import com.exam.projectdemotest.Products;

public class ProductController {
	@Autowired
	SessionFactory factory;

	
	@GetMapping("/products?page=2  ")
	public List<Category> getData(){
		Session session=factory.openSession();
		Criteria cfg=session.createCriteria(Products.class);
		
		List<Category> eee=cfg.list();
		System.out.println(eee);
		return eee ;
		}
	 
	@PostMapping("products")
	public String updatedata(@RequestBody Products pp) {
		Session ss = factory.openSession();
		Transaction t = ss.beginTransaction();
		ss.save(pp);
		t.commit();

		return "done";
	}
	@GetMapping("products/{id}")
	public ArrayList<Products> showdata(@PathVariable int id) {

		ArrayList<Products> al = (ArrayList<Products>) factory.openSession().createCriteria(Products.class).list();
		
		return al;
	}
		
	@PutMapping("products/{id}")
	String updatestudent(@RequestBody Products pr, @PathVariable int id) {
		Session session = factory.openSession();
		Products product = session.get(Products.class,id);
		if(product!=null){
			product.category= pr.category;
			session.update(product);
			session.beginTransaction().commit();
		}

		return "updated";
	
		
	}
}


