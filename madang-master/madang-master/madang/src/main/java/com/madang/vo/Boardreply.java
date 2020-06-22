package com.madang.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Boardreply {

	public int boardreplyid;
	public int boardid;
	public String contents;
	public String writer;
	private Date createddatetime;
	
}