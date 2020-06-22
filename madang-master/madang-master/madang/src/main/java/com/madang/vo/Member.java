package com.madang.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Member {

	public int memberid;
	public String id;
	public String passwd;
	public String email;
	public String usertype;
	public String name;
	public String address;
	public String phone;
	private Date createddatetime;
	
	private List<MemberFile> fileList;
}
