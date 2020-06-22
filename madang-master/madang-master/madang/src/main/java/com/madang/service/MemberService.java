package com.madang.service;

import java.util.List;

import com.madang.vo.Member;

public interface MemberService {

	void insertMember(Member member);

	List<Member> selectMemberlist();

	Member selectMemberBymemberid(int memberid);

	void updateMember(Member member);

	void deleteMemberBymemberid(Member member);

	Member selectMemberBymemberidAndpasswd(Member member);

	List<Member> selectMemberByname(String name);

	//Member findBoardBymemberid(Member member1);

}
