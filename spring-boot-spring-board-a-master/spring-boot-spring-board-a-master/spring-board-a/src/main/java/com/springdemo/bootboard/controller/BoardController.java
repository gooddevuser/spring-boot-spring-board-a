package com.springdemo.bootboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.bootboard.service.BoardService;
import com.springdemo.bootboard.vo.Board;

@Controller
@RequestMapping(path = { "/board" })
public class BoardController {
	
	@Autowired
	@Qualifier("boardService")
	BoardService boardService;
	
	@GetMapping(path = { "/list" })
	public String showList(Model model) {
		
		List<Board> boards = boardService.findBoardList();
		//View에서 읽을 수 있도록 저장 (실제로는 Request객체에 저장)
		model.addAttribute("boards", boards); 
		
		return "board/list";		
	}
	
	@GetMapping(path = { "/write" })
	public String showWriteForm() {		
		return "board/write";		
	}
	
	@PostMapping(path = { "/write" })
	public String doWrite(Board board) {
		
		boardService.writeBoard(board);
		System.out.println(board.getBoardIdx()); // 자동 증가 값 확인 코드
		
		return "redirect:list";		
	}
	
	@GetMapping(path = { "/detail" })
	public String showDetail(
			@RequestParam("board_idx")int boardIdx, Model model) {
		
		Board board = boardService.findBoardByBoardIdx(boardIdx);
		if (board == null) {
			return "redirect:list";
		}
		
		model.addAttribute("board", board);
		
		return "board/detail";
	}
	
	@PostMapping(path = { "/update" })
	public String updateBoard(Board board) {
				
		boardService.updateBoard(board);
		
		return "redirect:detail?board_idx=" + board.getBoardIdx();
	}
	
	@PostMapping(path = { "/delete" })
	public String deleteBoard(Board board) {
				
		boardService.deleteBoard(board);
		
		return "redirect:list";
	}

}















