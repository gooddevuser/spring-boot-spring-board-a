package com.madang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madang.mapper.BoardMapper;
import com.madang.vo.Board;
import com.madang.vo.BoardFile;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper boardMapper;

	@Override
	public Board selectBoardByboardid(int boardid) {
		Board board = boardMapper.selectBoardByboardid(boardid);
		return board;
	}

	@Override
	public List<Board> selectBoardlist() {
		List<Board> boards = boardMapper.selectBoardlist();
		return boards;
	}

	@Override
	public void insertBoard(Board board) {
		boardMapper.insertBoard(board);
		
		for (BoardFile f : board.getFileList()) {
			//자동 증가로 만들어진 글번호를 파일 VO에 적용
			f.setBoardid(board.getBoardid());
		}
		boardMapper.insertBoardFileList(board.getFileList());
		
	}

	@Override
	public void updateBoard(Board board) {
		boardMapper.updateBoard(board);
		
		for (BoardFile f : board.getFileList()) {
			//자동 증가로 만들어진 글번호를 파일 VO에 적용
			f.setBoardid(board.getBoardid());
		}
		boardMapper.updateBoardFileList(board.getFileList());
	}

	@Override
	public List<Board> selectBoardBytitle(String title) {
		List<Board> boards = boardMapper.selectBoardBytitle(title);
		return boards;
	}

}