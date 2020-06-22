package com.madang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.madang.vo.BoardFile;
import com.madang.vo.Member;
import com.madang.vo.MemberFile;

@Mapper
public interface MemberMapper {

	void insertMember(Member member);
	
	void insertMemberFileList(List<MemberFile> files);
	
	List<Member> selectMemberlist();	

	Member selectMemberBymemberid(int memberid);

	void updateMember(Member member);

	void deleteMemberBymemberid(Member member);

	Member selectMemberBymemberidAndpasswd(Member member);

	List<Member> selectMemberByname(String name);

	//Member findBoardBymemberid(Member member1);

}
