package com.madang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madang.mapper.BookMapper;
import com.madang.vo.BoardFile;
import com.madang.vo.Book;
import com.madang.vo.BookFile;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookMapper bookMapper;
	
	@Override
	public Book selectBookBybookid(int bookid) {
		Book book = bookMapper.selectBookBybookid(bookid);
		return book;
	}

	@Override
	public void insertBook(Book book) {
		bookMapper.insertBook(book);
		
		for (BookFile f : book.getFileList()) {
			//자동 증가로 만들어진 글번호를 파일 VO에 적용
			f.setBookid(book.getBookid());
		}
		bookMapper.insertBookFileList(book.getFileList());
		
	}

	@Override
	public List<Book> selectBooklist() {
		List<Book> books1 = bookMapper.selectBooklist();
		return books1;
	}

	@Override
	public List<Book> selectPublisherlist() {
		List<Book> books2 = bookMapper.selectPublisherlist();
		return books2;
	}

	@Override
	public List<Book> selectBookBypublisher(String publisher) {
		List<Book> books3 = bookMapper.selectBookBypublisher(publisher);
		return books3;
	}

	@Override
	public List<Book> selectBookBybookname(String bookname) {
		List<Book> books4 = bookMapper.selectBookBybookname(bookname);
		return books4;
	}

	@Override
	public List<Book> selectBookBypublishername(String publisher) {
		List<Book> books5 = bookMapper.selectBookBypublishername(publisher);
		return books5;
	}

	@Override
	public List<Book> selectBookBycontents(String contents) {
		List<Book> books6 = bookMapper.selectBookBycontents(contents);
		return books6;
	}
	
	

}
