package com.springdemo.bootboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.bootboard.mapper.BoardMapper;
import com.springdemo.bootboard.vo.Board;

@Service("boardService") // == @Component("boardService")
                         // == <bean id="boardService" class="...BoardServiceImpl"
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public void writeBoard(Board board) {		
		boardMapper.insertBoard(board);		
	}

	@Override
	public List<Board> findBoardList() {
		List<Board> boards = boardMapper.selectBoardList();
		return boards;
	}

	@Override
	public Board findBoardByBoardIdx(int boardIdx) {
		Board board = boardMapper.selectBoardByBoardIdx(boardIdx);
		return board;
	}

	@Override
	public void updateBoard(Board board) {
		boardMapper.updateBoard(board);
		
	}

	@Override
	public void deleteBoard(Board board) {

		boardMapper.deleteBoard(board);
		
	}

}
