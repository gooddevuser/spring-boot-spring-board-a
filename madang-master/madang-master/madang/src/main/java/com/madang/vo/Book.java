package com.madang.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Book {

	public int bookid;
	public String bookname;
	public String publisher;
	public int price;
	public int saleprice;
	public String contents;
	private Date createddatetime;
	
	private List<BookFile> fileList;
}




