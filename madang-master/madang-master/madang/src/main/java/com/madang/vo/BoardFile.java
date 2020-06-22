package com.madang.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardFile {
	
	private int idx;
	private int boardid;
	private String userfilename;
	private String savedfilename;
	private long filesize;
	private String creatorid;
	private Date createddatetime;
}
