package com.projectcontroller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.projectdemotest.Category;
import com.exam.projectdemotest.Products;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CategoryController {
	@Autowired
	SessionFactory factory;

	
	@GetMapping("/categories?page=3 ")
	public List<Category> getData(){
		Session session=factory.openSession();
		Criteria cfg=session.createCriteria(Category.class);
		
		List<Category> eee=cfg.list();
		System.out.println(eee);
		return eee ;
		}
	 
	@PostMapping("categories")
	public String updatedata(@RequestBody Products p) {
		Session s = factory.openSession();
		Transaction t = s.beginTransaction();
		s.save(p);
		t.commit();

		return "approve";
	}
	@GetMapping("/categories/{id}")
	public ArrayList<Products> showdata(@PathVariable int id) {

		ArrayList<Products> al = (ArrayList<Products>) factory.openSession().createCriteria(Products.class).list();
		
		return al;
	}
		
	@PutMapping("/categories/{eid}")
	String updatestudent(@RequestBody Products p, @PathVariable int id) {
		Session session = factory.openSession();
		Products product = session.get(Products.class,id);
		if(product!=null){
			product.category = p.category;
			session.update(product);
			session.beginTransaction().commit();
		}

		return "updated";
	
		
	}
}

