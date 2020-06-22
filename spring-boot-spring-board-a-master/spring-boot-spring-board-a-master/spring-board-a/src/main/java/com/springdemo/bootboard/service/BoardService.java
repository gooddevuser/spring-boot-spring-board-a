package com.springdemo.bootboard.service;

import java.util.List;

import com.springdemo.bootboard.vo.Board;

public interface BoardService {
	
	void writeBoard(Board board);

	List<Board> findBoardList();

	Board findBoardByBoardIdx(int boardIdx);

	void updateBoard(Board board);

	void deleteBoard(Board board);

}
