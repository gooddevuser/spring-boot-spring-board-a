package com.madang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.madang.vo.Board;
import com.madang.vo.BoardFile;

@Mapper
public interface BoardMapper {

	Board selectBoardByboardid(int boardid);

	List<Board> selectBoardlist();

	void insertBoard(Board board);

	void updateBoard(Board board);
	
	void insertBoardFileList(List<BoardFile> files);

	void updateBoardFileList(List<BoardFile> fileList);

	List<Board> selectBoardBytitle(String title);
	
}
