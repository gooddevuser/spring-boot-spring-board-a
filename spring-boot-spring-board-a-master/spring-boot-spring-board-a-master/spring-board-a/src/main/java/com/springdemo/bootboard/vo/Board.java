package com.springdemo.bootboard.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {

	private int boardIdx;
	private String title;
	private String contents;
	private int hitCount;
	private String creatorId;
	private Date createdDatetime;
	private String updaterId;
	private Date updatedDatetime;
	private String deletedYn;
	
}
