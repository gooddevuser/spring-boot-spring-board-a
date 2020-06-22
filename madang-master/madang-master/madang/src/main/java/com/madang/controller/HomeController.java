package com.madang.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.madang.service.BoardService;
import com.madang.service.BoardreplyService;
import com.madang.service.BookService;
import com.madang.service.MemberService;
import com.madang.vo.Board;
import com.madang.vo.BoardFile;
import com.madang.vo.Boardreply;
import com.madang.vo.Book;
import com.madang.vo.BookFile;
import com.madang.vo.Member;
import com.madang.vo.MemberFile;
import com.madang.common.Util;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("memberService")
	MemberService memberService;
	
	@Autowired
	@Qualifier("bookService")
	BookService bookService;
	
	@Autowired
	@Qualifier("boardService")
	BoardService boardService;
	
	@Autowired
	@Qualifier("boardreplyService")
	BoardreplyService boardreplyService;
	
	//@Autowired
	//@Qualifier("ordersService")
	//OrdersService ordersService;
	
	
	@GetMapping(path = { "/", "/home" })
	public String showHome() {
		
		return "home";
		
	}
		
	@PostMapping(path = { "/", "/home" })
	public String doLogin(Member member,HttpSession session) {
		Member member2 = memberService.selectMemberBymemberidAndpasswd(member);
		session.setAttribute("loginuser", member2);
		return "home";
		
	}
	
	@GetMapping(path = { "logout" })
	public String doLogout(HttpSession session) {
		session.removeAttribute("loginuser");
		return "home";
		
	}
	
	@GetMapping(path = { "/book" })
	public String showBook(Model model, String bookname,String publisher,String contents) {
		
		List<Book> books1 = bookService.selectBooklist();		
		model.addAttribute("books", books1);
		
		List<Book> books2 = bookService.selectPublisherlist();
		model.addAttribute("books2", books2);
		
		List<Book> books3 = bookService.selectBookBypublisher(publisher);
				
		if ( publisher == null ) {		
			
		} else {
			
			model.addAttribute("books", books3);
		}		
		
		return "book";
		
	}
	
	@PostMapping(path = { "/book" })
	public String doBook(Model model, String bookname,String publisher,String contents) {
		
		if ( bookname != null && bookname.length() > 0 ) {	
			List<Book> books4 = bookService.selectBookBybookname(bookname);
			model.addAttribute("books", books4);
			
		} else if ( publisher != null  && publisher.length() > 0 ) {
			List<Book> books5 = bookService.selectBookBypublishername(publisher);
			model.addAttribute("books", books5);
			
		} else if( contents != null  && contents.length() > 0 ) {		
			List<Book> books6 = bookService.selectBookBycontents(contents);
			model.addAttribute("books", books6);
			
		} else {
		}
		
		return "book";	
	};
	
	@GetMapping(path = { "/board" })
	public String showBoard(Model model) {
		List<Board> boards = boardService.selectBoardlist();
		model.addAttribute("boards", boards);
		return "board";
		
	}
			
	@GetMapping(path = { "/login" })
	public String showLogin() {
		
		return "home";
		
	}
	
	@GetMapping(path = { "/register" })
	public String showRegister() {
		
		return "register";
		
	}
	
	///////////////////////////////////
	
	@PostMapping(path = { "/register" })
	public String doRegister(Member member, MultipartHttpServletRequest req) {
		//MultipartFile file = req.getFile("file");
		List<MemberFile> files = parseAndSaveUploadMemberFiles(req);
		member.setFileList(files);
				
		try {
			memberService.insertMember(member);
			//boardService.writeBoardFiles(files);
			System.out.println(member.getMemberid()); // 자동 증가 값 확인 코드
		} catch (Exception ex) {
		System.out.println("등록 실패");
		ex.printStackTrace();			
		}
						
		return "home";
	}
	
	///////////////////////////////////
	
	@GetMapping(path = { "/bookdetail" })
	public String showBookdetail(int bookid, Model model, String bookname,String publisher,String contents ) {
		
		Book book = bookService.selectBookBybookid(bookid);
		model.addAttribute("book",book);
		
		List<Book> books1 = bookService.selectBooklist();		
		model.addAttribute("books", books1);
		
		List<Book> books2 = bookService.selectPublisherlist();
		model.addAttribute("books2", books2);
		
		List<Book> books3 = bookService.selectBookBypublisher(publisher);
				
		if ( publisher == null ) {		
			
		} else {
			
			model.addAttribute("books", books3);
		}		
		
		return "bookdetail";
		
	}
	
	
	@PostMapping(path = { "/bookdetail" })
	public String doBookdetail(Model model, String bookname,String publisher,String contents) {
		
		if ( bookname != null && bookname.length() > 0 ) {	
			List<Book> books4 = bookService.selectBookBybookname(bookname);
			model.addAttribute("books", books4);
			
		} else if ( publisher != null  && publisher.length() > 0 ) {
			List<Book> books5 = bookService.selectBookBypublishername(publisher);
			model.addAttribute("books", books5);
			
		} else if( contents != null  && contents.length() > 0 ) {		
			List<Book> books6 = bookService.selectBookBycontents(contents);
			model.addAttribute("books", books6);
			
		} else {
		}
		
		return "bookdetail";	
	};
	
	///////////////////////////////////
	
	@GetMapping(path = { "/boarddetail" })
	public String showboarddetail(int boardid, Model model) {
		Board board = boardService.selectBoardByboardid(boardid);		
		model.addAttribute("board",board);
		
		List<Boardreply> boardreplys = boardreplyService.selectBoardreplylist(boardid);
		model.addAttribute("boardreplys", boardreplys);
		return "boarddetail";
		
	}
	
	@PostMapping(path = { "/boarddetail" })
	public String doBoarddetail(Boardreply boardreply, Model model) {
		boardreplyService.insertBoardreply(boardreply);		
		return "bookdetail";
		
	}
	
	
	
	///////////////////////////////////
	
	@GetMapping(path = { "/boardupdate" })
	public String showBoardupdate(int boardid, Model model) {
		Board board = boardService.selectBoardByboardid(boardid);
		model.addAttribute("board",board);
		return "boardupdate";
		
	}
	
	///////////////////////////////////
		
	@PostMapping(path = { "/boardupdate" })
	public String doBoardupdate(Board board, MultipartHttpServletRequest req) {
		//MultipartFile file = req.getFile("file");
		List<BoardFile> files = parseAndSaveUploadBoardFiles(req);
		board.setFileList(files);
		
		try {
			boardService.updateBoard(board);
			//boardService.writeBoardFiles(files);
			System.out.println(board.getBoardid()); // 자동 증가 값 확인 코드
		} catch (Exception ex) {
			System.out.println("등록 실패");
			ex.printStackTrace();			
		}
				
		return "boardupdate";
	}


	///////////////////////////////////

	@GetMapping(path = { "/boardwrite" })
	public String showBoardwrite(int memberid,Model model) {
		Member member = memberService.selectMemberBymemberid(memberid);	
		model.addAttribute("member", member);
		return "boardwrite";
		
	}
	
	///////////////////////////////////
	
	@PostMapping(path = { "/boardwrite" })
	//public String doWrite(Board board, MultipartFile[] files) {
	public String doBoardwrite(Board board, MultipartHttpServletRequest req) {
		//MultipartFile file = req.getFile("file");
		List<BoardFile> files = parseAndSaveUploadBoardFiles(req);
		board.setFileList(files);
		
		try {
			boardService.insertBoard(board);
			//boardService.writeBoardFiles(files);
			System.out.println(board.getBoardid()); // 자동 증가 값 확인 코드
		} catch (Exception ex) {
			System.out.println("등록 실패");
			ex.printStackTrace();			
		}
				
		return "home";
	}
	
	
	///////////////////////////////////
	
	@GetMapping(path = { "/terms" })
	public String showTerms() {
		
		return "terms";
		
	}
	
	////////////////////////////////////
	
	@GetMapping(path = { "/mypage" })
	public String showMypage(int memberid,Model model) {
		Member member = memberService.selectMemberBymemberid(memberid);	
		model.addAttribute("member", member);
		return "mypage";
		
	}
		
	@GetMapping(path = { "/mycart" })
	public String showMycart(int memberid,Model model, int idx) {		
		Member member = memberService.selectMemberBymemberid(memberid);	
		model.addAttribute("member", member);		
		System.out.println(idx);
		return "mycart";
		
	}	
	
	@GetMapping(path = { "/myboard" })
	public String showMyboard(int memberid,Model model) {
		Member member = memberService.selectMemberBymemberid(memberid);	
		//Member member2 = memberService.findBoardBymemberid(member1);
		model.addAttribute("member", member);
		return "myboard";
		
	}
	
	@GetMapping(path = { "/mygrade" })
	public String showMygrade(int memberid,Model model) {
		Member member = memberService.selectMemberBymemberid(memberid);
		model.addAttribute("member",member);
		return "mygrade";
		
	}
	
	///////////////////////////////////
	
	
	@GetMapping(path = { "/admin" })
	public String showAdmin() {
		
		return "admin";
		
	}
	
	@GetMapping(path = { "/admincustomer" })
	public String showCustomer(Model model) {
		List<Member> members = memberService.selectMemberlist();		
		model.addAttribute("members", members);
		return "admincustomer";
		
	}
	
	@GetMapping(path = { "/admincustomerdetail" })
	public String showCustomerdetail(int memberid,Model model) {
		Member member = memberService.selectMemberBymemberid(memberid);	
		model.addAttribute("member", member);
		return "admincustomerdetail";
		
	}	
	
	///////////////////////////////////
	
	@PostMapping(path = { "/admincustomerdetail" })
	public String showCustomerdetail(Member member) {
		memberService.deleteMemberBymemberid(member);	
		return "admincustomer";
		
	}
	
	///////////////////////////////////
	
	@GetMapping(path = { "/admincustomerupdate" })
	public String showCustomerupdate(int memberid,Model model) {
		Member member = memberService.selectMemberBymemberid(memberid);	
		model.addAttribute("member", member);
		return "admincustomerupdate";
		
	}	
	
	///////////////////////////////////
	
	@PostMapping(path = { "/admincustomerupdate" })
	public String doCustomerupdate(Member member) {
		memberService.updateMember(member);
		return "admincustomerupdate";
		
	}
	
	///////////////////////////////////
	
	@GetMapping(path = { "/adminorder" })
	public String showOrder() {
		
		return "adminorder";
		
	}
	
	@GetMapping(path = { "/adminbook" })
	public String showAdminbook(Model model) {
		
		List<Book> books = bookService.selectBooklist();
		model.addAttribute("books", books);
				
		return "adminbook";		
	}
	
	
	@PostMapping(path = { "/adminbook" })
	public String showAdminbook(Model model ,String bookname) {
		
		List<Book> books4 = bookService.selectBookBybookname(bookname);
		
		if (bookname == null) {
				
		} else {
			
			model.addAttribute("books", books4);	
		}
		
		return "adminbook";		
	}
	
	@GetMapping(path = { "/adminbookupdate" })
	public String showAdminbookupdate(int bookid,Model model) {
		Book book = bookService.selectBookBybookid(bookid);
		model.addAttribute("book",book);
		return "adminbookupdate";
		
	}
	
	
	
	
	//adminbookupdate 할것 (파일)
	
	
	
	
	
	
	@GetMapping(path = { "/adminbookdetail" })
	public String showAdminbookdetail(int bookid,Model model) {
		Book book = bookService.selectBookBybookid(bookid);
		model.addAttribute("book",book);
		return "adminbookdetail";
		
	}
	
	@GetMapping(path = { "/adminbookwrite" })
	public String showAdminbookwrite() {
		return "adminbookwrite";
		
	}
	
	///////////////////////////////////
		
	@PostMapping(path = { "/adminbookwrite" })
	//public String doWrite(Board board, MultipartFile[] files) {
	public String doAdminbookwrite(Book book, MultipartHttpServletRequest req) {
		//MultipartFile file = req.getFile("file");
		List<BookFile> files = parseAndSaveUploadBookFiles(req);
		book.setFileList(files);
		
		try {
			bookService.insertBook(book);
			//boardService.writeBoardFiles(files);
			System.out.println(book.getBookid()); // 자동 증가 값 확인 코드
		} catch (Exception ex) {
			System.out.println("등록 실패");
			ex.printStackTrace();			
		}
				
		return "home";
	}
	
	///////////////////////////////////
	
	@GetMapping(path = { "/adminboard" })
	public String showadminBoard(Model model) {
		List<Board> boards = boardService.selectBoardlist();
		model.addAttribute("boards", boards);
		return "adminboard";
		
	}
	
	@PostMapping(path = { "/adminboard" })
	public String doadminBoard(Model model,String title) {
		List<Board> boards = boardService.selectBoardBytitle(title);
		model.addAttribute("boards", boards);
		return "adminboard";
		
	}
	
	@PostMapping(path = { "/admincustomer" })
	public String doCustomer(Model model, String name) {
		List<Member> members = memberService.selectMemberByname(name);
		model.addAttribute("members", members);
		return "admincustomer";
		
	}
	
	///////////////////////////////////
		
	@GetMapping(path = { "/adminboarddetail" })
	public String showAdminboarddetail(int boardid, Model model) {
	Board board = boardService.selectBoardByboardid(boardid);
	model.addAttribute("board",board);
	return "adminboarddetail";
	
	}
	///////////////////////////////////	
	
	@PostMapping(path = { "/booksearch" })
	public String dobooksearch(Model model) {
		
		return "book";
		
	}
		
	//////////////////////////////////////////////////////
	// Util
	List<BoardFile> parseAndSaveUploadBoardFiles(MultipartHttpServletRequest req) {
	
	ArrayList<BoardFile> boardFiles = new ArrayList<>();
	
	if (!ObjectUtils.isEmpty(req)) {
	
	String dirPath = req.getServletContext().getRealPath("/upload-files/");
	
	System.out.println(dirPath);
	
	Iterator<String> iter = req.getFileNames();
	while(iter.hasNext()) { // 다음 항목이 있는지 확인
	String name = iter.next(); // 다음 항목 반환
	List<MultipartFile> files = req.getFiles(name); // 파일 들의 이름을 리스트 꼴로 여러가지 담음.
	
	
	for(MultipartFile file : files) {
	String originalFileName = file.getOriginalFilename();
	String uniqueFileName = Util.makeUniqueFileName(originalFileName);
	try {
	
	//파일을 Disk에 저장
	file.transferTo(new File(dirPath, uniqueFileName));
	
	//파일 정보를 VO에 저장하고 목록에 추가 ( -> DB에 저장 )
	BoardFile boardFile = new BoardFile();
	boardFile.setUserfilename(originalFileName);
	boardFile.setSavedfilename(uniqueFileName);
	boardFile.setFilesize(file.getSize());
	boardFile.setCreateddatetime(new Date());
	boardFile.setCreatorid("");
	boardFiles.add(boardFile);
	
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	}
	}
	
	return boardFiles;
	}
	
	
	/////////////////////////////////////////////////////
	
	List<MemberFile> parseAndSaveUploadMemberFiles(MultipartHttpServletRequest req) {
		
	ArrayList<MemberFile> memberFiles = new ArrayList<>();
		
	if (!ObjectUtils.isEmpty(req)) {
		
	String dirPath = req.getServletContext().getRealPath("/upload-files/");
		
	System.out.println(dirPath);
		
	Iterator<String> iter = req.getFileNames();
	while(iter.hasNext()) { // 다음 항목이 있는지 확인
	String name = iter.next(); // 다음 항목 반환
	List<MultipartFile> files = req.getFiles(name); // 파일 들의 이름을 리스트 꼴로 여러가지 담음.
		
		
	for(MultipartFile file : files) {
	String originalFileName = file.getOriginalFilename();
	String uniqueFileName = Util.makeUniqueFileName(originalFileName);
	try {
		
	//파일을 Disk에 저장
	file.transferTo(new File(dirPath, uniqueFileName));
		
	//파일 정보를 VO에 저장하고 목록에 추가 ( -> DB에 저장 )
	MemberFile memberFile = new MemberFile();
	memberFile.setUserfilename(originalFileName);
	memberFile.setSavedfilename(uniqueFileName);
	memberFile.setFilesize(file.getSize());
	memberFile.setCreateddatetime(new Date());
	memberFile.setCreatorid("");
	memberFiles.add(memberFile);
		
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	}
	}
		
	return memberFiles;
	}
		
	
	/////////////////////////////////////////////////////
	
	List<BookFile> parseAndSaveUploadBookFiles(MultipartHttpServletRequest req) {
	
	ArrayList<BookFile> bookFiles = new ArrayList<>();
	
	if (!ObjectUtils.isEmpty(req)) {
	
	String dirPath = req.getServletContext().getRealPath("/upload-files/");
	
	System.out.println(dirPath);
	
	Iterator<String> iter = req.getFileNames();
	while(iter.hasNext()) { // 다음 항목이 있는지 확인
	String name = iter.next(); // 다음 항목 반환
	List<MultipartFile> files = req.getFiles(name); // 파일 들의 이름을 리스트 꼴로 여러가지 담음.
	
	
	for(MultipartFile file : files) {
	String originalFileName = file.getOriginalFilename();
	String uniqueFileName = Util.makeUniqueFileName(originalFileName);
	try {
	
	//파일을 Disk에 저장
	file.transferTo(new File(dirPath, uniqueFileName));
	
	//파일 정보를 VO에 저장하고 목록에 추가 ( -> DB에 저장 )
	BookFile bookFile = new BookFile();
	bookFile.setUserfilename(originalFileName);
	bookFile.setSavedfilename(uniqueFileName);
	bookFile.setFilesize(file.getSize());
	bookFile.setCreateddatetime(new Date());
	bookFile.setCreatorid("");
	bookFiles.add(bookFile);
	
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	}
	}
	
	return bookFiles;
	}
	
	}
