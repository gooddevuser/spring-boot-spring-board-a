<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>board</title>
	<link rel="stylesheet" href="/resources/css/style.css" />
</head>
<body>
	<div class="container">
	    <h2>게시글 등록</h2>
	    <form id="frm" name="frm" method="post" action="/board/write">
	    	
	    	<input type="hidden" name="creatorId" value="admin">	    	
	    	
	    	<table class="board_detail">
	    		<tr>
	    			<td>제목</td>
	    			<td><input type="text" id="title" name="title"/></td>
	    		</tr>
	    		<tr>
	    			<td colspan="2">
		    			<textarea id="contents" name="contents"></textarea>
	    			</td>
	    		</tr>
	    	</table>
	    	<input type="submit" id="submit" value="저장" class="btn">
	    </form>
    </div>
</body>
</html>