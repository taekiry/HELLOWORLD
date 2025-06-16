/**
 * reply.js
 * 
 * <li>
	<span class="col-sm-1">댓글번호</span>
	<span class="col-sm-4">글내용</span>
	<span class="col-sm-2">작성자</span>
	<span class="col-sm-3">작성일시</span>
	<span class="col-sm-1">삭제</span>
   </li>
 */
// 페이지 
let page = 1;
 
console.log(bno);

// 1. 댓글 등록 이벤트

document.querySelector('#addReply').addEventListener('click', addReplyHandler);

function addReplyHandler(e) {
	let reply = document.querySelector('#reply').value;
	if (!logId || !reply) {
		alert('값을 확인하세요!');
		return;  //undefined 값을 반환하면서 함수를 종료
	}
	//댓글 등록 메소드 호출
	svc.addReply({ bno, reply, replyer: logId },
		result => {
			let ul = document.querySelector('#target');
			if (result.retCode == "Success") {
				let rval = result.retVal;
				makeTemplate(rval);
				ul.insertAdjacentHTML("afterbegin", makeTemplate(rval));
				document.querySelector('#reply').value = "";//입력값 초기화
			}
		},
		err => console.error(err)
	)
}


//javascript는 date 객체에 추가가능
Date.prototype.format = function() {
	let yyyy = this.getFullYear(); //2025-06-16 12:39:23 형식으로하려고
	let MM = this.getMonth() + 1; //js는 1월 값이 0임
	let dd = this.getDay();
	let hh = this.getHours();
	let mm = this.getMinutes();
	let ss = this.getSeconds();

	return yyyy + '-' + ('0' + MM).slice(-2) + '-' + ('0' + dd).slice(-2)
	//+ ' '+ ('0' + hh).slice(-2) + ':' + ('0' + mm).slice(-2) + ':' + ('0' + ss).slice(-2); 	//09월 09시 등 slice로 뒤에서2자리만 잘라오게
}


svc.replyList({bno,page}   	//게시글 번호.  ``이표시 복습필요.
	, result => {
		console.log(result);
		let ul = document.querySelector('#target');
		let template = document.querySelector('#target li');
		for (let reply of result) {
			template = makeTemplate(reply);
			ul.insertAdjacentHTML("beforeend", template);  //insertAdjacentHTML (1.위치 2.무엇)
		}
	}, err => console.log(err)
);// end svc.replyList

//댓글 화면 출력
function makeTemplate(reply = {}) {
	let replyDate = new Date(reply.replyDate).format();		//reply.replyDate가 문자열이라서 date 객체로 바꿈
	template =
		`<li data-rno=${reply.replyNo}>
			<span class="col-sm-1">${reply.replyNo}</span>
			<span class="col-sm-4">${reply.reply}</span>
			<span class="col-sm-2">${reply.replyer}</span>
			<span class="col-sm-3">${replyDate}</span>
			<span class="col-sm-1"><button onclick="deleteReply(event)" class="btn btn-danger">삭제</button></span>
		</li>`;											//event 객체로 기준설정
		return template;
}

//댓글 삭제함수
function deleteReply(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;		//getAttribute도 가능
	if (!confirm("삭제하시겠습니까?")) {            					//
		return;
	}
	svc.removeReply(rno,
		result => {
			if (result.retCode == "Success") {
				alert("삭제 성공");
				e.target.parentElement.parentElement.remove();
			} else {
				alert("삭제 실패");
			}
		},
		err => console.log(err)
	)
}//end deleteReply



