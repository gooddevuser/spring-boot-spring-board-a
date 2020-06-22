package com.madang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.madang.vo.BoardFile;
import com.madang.vo.Book;
import com.madang.vo.BookFile;

@Mapper
public interface BookMapper {

	List<Book> selectBooklist();
	
	void insertBookFileList(List<BookFile> files);

	Book selectBookBybookid(int bookid);

	void insertBook(Book book);

	List<Book> selectPublisherlist();

	List<Book> selectBookBypublisher(String publisher);

	List<Book> selectBookBybookname(String bookname);

	List<Book> selectBookBypublishername(String publisher);

	List<Book> selectBookBycontents(String contents);

}
