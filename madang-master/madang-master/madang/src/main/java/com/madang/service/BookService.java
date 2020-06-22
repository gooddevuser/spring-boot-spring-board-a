package com.madang.service;

import java.util.List;

import com.madang.vo.Book;
import com.madang.vo.Member;

public interface BookService {

	List<Book> selectBooklist();

	Book selectBookBybookid(int bookid);

	void insertBook(Book book);

	List<Book> selectPublisherlist();

	List<Book> selectBookBypublisher(String publisher);

	List<Book> selectBookBybookname(String bookname);

	List<Book> selectBookBypublishername(String publisher);

	List<Book> selectBookBycontents(String contents);

}
