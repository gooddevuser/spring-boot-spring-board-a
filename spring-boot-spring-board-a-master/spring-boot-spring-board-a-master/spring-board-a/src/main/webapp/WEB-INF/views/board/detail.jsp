<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>게시글 상세 화면</title>
	<link rel="stylesheet" href="/resources/css/style.css" />
</head>
<body>
	<div class="container">
		<h2>게시글 상세 화면</h2>
	    <form id="frm" method="post">
	    	<table class="board_detail">
				<colgroup>
					<col width="15%" />
					<col width="35%" />
					<col width="15%" />
					<col width="35%" />
				</colgroup>
				<caption>게시글 상세내용</caption>
				<tbody>
					<tr>
						<th scope="row">글 번호</th>
						<td>${ board.boardIdx }</td>
						<th scope="row">조회수</th>
						<td>${ board.hitCount }</td>
					</tr>
					<tr>
						<th scope="row">작성자</th>
						<td>${ board.creatorId }</td>
						<th scope="row">작성일</th>
						<td>
							<fmt:formatDate value="${ board.createdDatetime }"
											pattern="yyyy년 MM월 dd일"/>  
							(<fmt:formatDate value="${ board.updatedDatetime }"
											 pattern="yyyy년 MM월 dd일"/>)
						</td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="3">
							<input type="text" id="title" name="title" value="${ board.title }">
						</td>
					</tr>
					<tr>
						<td colspan="4" class="view_text">
							<textarea title="내용" id="contents" name="contents">${ board.contents }</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" id="boardIdx" name="boardIdx" value="${ board.boardIdx }">
		</form>
		
		<a href="javascript:" id="list" class="btn">목록으로</a>
		<a href="javascript:" id="edit" class="btn">수정하기</a>
		<a href="javascript:" id="delete" class="btn">삭제하기</a>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript">
	$(function() {

		var form = $('#frm');
		
		$('#list').on('click', function(event) {
			location.href = 'list';
		});

		$('#edit').on('click', function(event) {			
			form.attr("action", 'update');
			form.submit();
		});

		$('#delete').on('click', function(event) {
			if (!confirm(${ board.boardIdx } + "번 글을 삭제할까요?")) {
				return;
			}
			//location.href = 'delete?board_idx=' + ${ board.boardIdx }			
			form.attr("action", 'delete');
				$('#title').val("");
			$('#contents').val("");			
			form.submit();
		});
	});
	</script>	

</body>
</html>













