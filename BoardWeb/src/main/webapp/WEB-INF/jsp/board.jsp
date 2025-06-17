<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link
	href="//cdn.datatables.net/2.3.2/css/dataTables.dataTables.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src="//cdn.datatables.net/2.3.2/js/dataTables.min.js"></script>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
String sc = (String) request.getAttribute("searchCondition");
String kw = (String) request.getAttribute("keyword");
String pg = (String) request.getAttribute("page");
String logId = (String) session.getAttribute("logId");
%>
<h3>상세화면(board.jsp)</h3>
<form action="modifyForm.do">
	<input type="hidden" name="bno" value="${board.boardNo }"> <input
		type="hidden" name="searchCondition" value="${searchCondition }">
	<input type="hidden" name="keyword" value="${keyword }"> <input
		type="hidden" name="page" value="${page }">

	<table class="table">
		<!--table.table-->
		<tr>
			<th>글번호</th>
			<td>${board.boardNo }</td>
			<th>조회수</th>
			<td>${board.readCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea cols="40" rows="4" readonly>${board.content }</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${board.writer }</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan="3">${board.writeDate }</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<%
				if (logId.equals(board.getWriter())) {
				%> <input type="submit" value="수정" class="btn btn-warning">
				<button class="btn btn-danger" type="button">삭제</button> <%
 } else {
 %> <input disabled type="submit" value="수정" class="btn btn-warning">
				<button disabled class="btn btn-danger" type="button">삭제</button> <%
 }
 %>
			</td>
		</tr>
	</table>
</form>
<!-- 댓글관련 페이지 start-->
<style>
div.reply ul {
	list-style-type: none;
}

div.reply span {
	display: inline-block;
}
</style>
<div class="conatiner reply">
	<div class="header">
		<input class="col-sm-10" id="reply">
		<button class="col-sm-1 btn btn-primary" id="addReply">등록</button>

		<div>
			<!-- datatable 적용. -->
			<p>
				<button class="col-sm-1 btn btn-danger" id="delReply">삭제</button>
			</p>
			<table id="example" class="display">
				<thead>
					<tr>
						<th>댓글번호</th>
						<th>내용</th>
						<th>작성자</th>
						<th>작성일시</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>댓글번호</th>
						<th>내용</th>
						<th>작성자</th>
						<th>작성일시</th>
					</tr>
				</tfoot>
			</table>

		</div>

		<div class="footer">
			<!-- 페이징 -->
			<nav aria-label="...">
				<ul class="pagination">
					<!-- 이전페이지 -->
					<li class="page-item disabled"><span class="page-link">Previous</span>
					</li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item active" aria-current="page"><span
						class="page-link">2</span></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<!-- 이후페이지 -->
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>

		</div>
	</div>
	<!-- 댓글관련 페이지 end-->
	<script>
	let bno = "${board.boardNo}";
	let logId = "${logId}";
	console.log(bno);
	document.querySelector('button.btn-danger').addEventListener('click',
			function() {
				location.href = 'removeBoard.do?bno=' + bno;
			})
</script>
	<script>
const table = new DataTable('#example', {
    ajax: 'replyList.do?bno='+bno,
    columns: [
        { data: 'replyNo' },
        { data: 'reply' },
        { data: 'replyer' },
        { data: 'replyDate' },
    ],
	lengthMenu: [10, 25, 50, -1],
	order: [[0, 'desc']]
});

//삭제 메소드
table.on('click', 'tbody tr', (e) => {  //jQuery 문법. eventListner임.
    let classList = e.currentTarget.classList;
 	//console.log(classList);
    if (classList.contains('selected')) { //classList의 selected가 있는지 확인 -> remove
        classList.remove('selected');
    }
    else {
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
        classList.add('selected');
    }
});
 
	document.querySelector('#delReply').addEventListener('click', async function (){
	//삭제 ajax
	if(!document.querySelector('tr.selected')) {
		alert("댓글을 선택하세요!");
	}
	let rno = document.querySelector('tr.selected').children[0].innerHTML;
	let data = await fetch("removeReply.do?rno="+rno);
	let result = await data.json();
	if(result.retCode == "Success"){
		table.row('.selected').remove().draw(false);
	} 
	
	});//end 삭제 이벤트 




//등록
function addNewRow() {
	// ajax 호출
	let reply = document.querySelector('#reply').value;
	if(!reply || !logId){
		return;
	}
	fetch("addReply.do?bno="+bno+"&reply="+reply+"&replyer="+logId)
	.then(data => data.json())
	.then(result => {
		console.log(result);
		let retVal = result.retVal;
		let retCode = result.retCode;
		if(retCode == "Success"){
		// 화면 추가
    	table.row
       	 .add({replyNo: retVal.replyNo,
			  reply: retVal.reply,
			  replyer: retVal.replyer,
			  replyDate: retVal.replyDate
        	})
        .draw(false);
		} else {
			alert("등록실패")
		}
	})
	.catch(err => console.log(err));
}

document.querySelector('#addReply').addEventListener('click', addNewRow);
</script>