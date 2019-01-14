package com.cg.lms.model;

public class Students {
	Integer id;
	String bookName;
	String authorName;
	Double bookCost;
	
	public Students() {
		// TODO Auto-generated constructor stub
	}

	public Students(Integer id, String bookName, String authorName,
			Double bookCost) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookCost = bookCost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Double getBookCost() {
		return bookCost;
	}

	public void setBookCost(Double bookCost) {
		this.bookCost = bookCost;
	}
	
}
