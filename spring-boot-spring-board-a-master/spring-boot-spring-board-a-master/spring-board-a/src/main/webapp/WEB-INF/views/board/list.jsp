<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>board</title>
	<link rel="stylesheet" href="/resources/css/style.css" />
</head>
<body>
    <div class="container">
    	<h2>게시글 목록</h2>
    	<table class="board_list">
	        <colgroup>
	            <col width="15%"/>
	            <col width="*"/>
	            <col width="15%"/>
	            <col width="20%"/>
	        </colgroup>
	        <thead>
	            <tr>
	                <th scope="col">글번호</th>
	                <th scope="col">제목</th>
	                <th scope="col">조회수</th>
	                <th scope="col">작성일</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach var="board" items="${ boards }">
	        	<tr>
	        		<td>${ board.boardIdx }</td>
	        		<td class="title">
	        			<a href="detail?board_idx=${ board.boardIdx }">${ board.title }</a>
	        		</td>
	        		<td>${ board.hitCount }</td>
	        		<td>${ board.createdDatetime }</td>
	        	</tr>
	        	</c:forEach>
	        </tbody>			
	    </table>
	    <a href="/board/write" class="btn">글 쓰기</a>
    </div>
</body>
</html>








