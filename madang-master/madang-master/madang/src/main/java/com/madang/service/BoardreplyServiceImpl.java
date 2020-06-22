package com.madang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madang.mapper.BoardreplyMapper;
import com.madang.vo.Boardreply;

@Service("boardreplyService")
public class BoardreplyServiceImpl implements BoardreplyService {
	
	@Autowired
	BoardreplyMapper boardreplyMapper;

	@Override
	public void insertBoardreply(Boardreply boardreply) {
		boardreplyMapper.insertBoardreply(boardreply);		
	}

	@Override
	public List<Boardreply> selectBoardreplylist(int boardid) {
		List<Boardreply> boardreply = boardreplyMapper.selectBoardreplylist(boardid);
		return boardreply;
	}


}