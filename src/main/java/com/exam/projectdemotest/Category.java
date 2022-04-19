package com.exam.projectdemotest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Category {
	@Id
int cid;
String category;
@OneToMany(mappedBy = "category")

List<Category> clist=new ArrayList<>();
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public List<Category> getClist() {
	return clist;
}
public void setClist(List<Category> clist) {
	this.clist = clist;
}
@Override
public String toString() {
	return "Category [cid=" + cid + ", category=" + category + ", clist=" + clist + "]";
}
public Category() {
	super();
	// TODO Auto-generated constructor stub
}
public Category(int cid, String category, List<Category> clist) {
	super();
	this.cid = cid;
	this.category = category;
	this.clist = clist;
}
public void setCategory(List<Products> list) {
	// TODO Auto-generated method stub
	
}


}
