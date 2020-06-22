package com.madang.service;

import java.util.List;

import com.madang.vo.Boardreply;

public interface BoardreplyService {

	void insertBoardreply(Boardreply boardreply);

	List<Boardreply> selectBoardreplylist(int boardid);

}
