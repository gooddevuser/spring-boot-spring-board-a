package com.madang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madang.mapper.MemberMapper;
import com.madang.vo.BoardFile;
import com.madang.vo.Member;
import com.madang.vo.MemberFile;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public void insertMember(Member member) {
		memberMapper.insertMember(member);
		
		for (MemberFile f : member.getFileList()) {
			//자동 증가로 만들어진 글번호를 파일 VO에 적용
			f.setMemberid(member.getMemberid());
		}
		memberMapper.insertMemberFileList(member.getFileList());
		
	}

	@Override
	public List<Member> selectMemberlist() {
		List<Member> members = memberMapper.selectMemberlist();
		return members;
	}

	@Override
	public Member selectMemberBymemberid(int memberid) {
		Member member = memberMapper.selectMemberBymemberid(memberid);
		return member;
	}

	@Override
	public void updateMember(Member member) {
		memberMapper.updateMember(member);
		
	}

	@Override
	public void deleteMemberBymemberid(Member member) {
		memberMapper.deleteMemberBymemberid(member);
		
	}

	@Override
	public Member selectMemberBymemberidAndpasswd(Member member) {
		Member member2 = memberMapper.selectMemberBymemberidAndpasswd(member);
		return member2;
	}

	@Override
	public List<Member> selectMemberByname(String name) {
		List<Member> members = memberMapper.selectMemberByname(name);
		return members;
	}

//	@Override
//	public Member findBoardBymemberid(Member member1) {
//		Member member2 = memberMapper.findBoardBymemberid(member1);
//		return member2;
//	}

}
