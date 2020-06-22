package com.madang.service;

import java.util.List;

import com.madang.vo.Board;

public interface BoardService {

	Board selectBoardByboardid(int boardid);

	List<Board> selectBoardlist();

	void insertBoard(Board board);

	void updateBoard(Board board);

	List<Board> selectBoardBytitle(String title);
}
