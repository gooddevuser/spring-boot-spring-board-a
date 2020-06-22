package com.madang.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Board {

	public int boardid;
	public String title;
	public String contents;
	public int hitcount;
	public String writer;
	private Date createddatetime;
	
	private List<BoardFile> fileList;
}
    