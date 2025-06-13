/**
 * ajax2.js (service.js에 정의된 메소드들로 기능실현.)
 */

console.log(add(10, 20));

//목록 출력 메소드. service에 있는

svc.replyList(239,   			//게시글 번호 service.js에 replyList 메소드 정의 가보셈.
	function(result) {			//성공 callback함수
		console.log(result);
		result.forEach(function(item) {
			let tr = makeRowFnc(item);
			document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
		})
	},
	function(err) {				//실패 callback함수
		console.log(err);
	});

//삭제 함수.
function deleteReply(e) {				//makerow에 함수매개값으로 들어가서 함수로 선언해둬야됨.
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno,
		function(result) {
			if (result.retCode == 'Success') {
				alert('삭제성공!');
				e.target.parentElement.parentElement.remove();
			} else {
				alert('삭제실패!');
			}
		},
		function(err) {
			console.error(err)
		})
}//end of deleteReplyFnc.


//등록 이벤트.
document.querySelector('#addReply').addEventListener('click', addReply);

function addReply(e) {
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	if (!bno || !reply || !logId) { 						//logId는 prductList.jsp에 따로 선언해둠.
		alert('필수값 입력!')
		return;
	}

	//메소드 호출.
	svc.addReply({ bno, reply, replyer: logId },		// 첫번째 매개값		//속성과 값이 다름 replyer만
		function(result) {								// 두번째 매개값
			if (result.retCode == 'Success') {
				alert('등록성공!');
				let tr = makeRowFnc(result.retVal);
				let target = document.querySelector('table:nth-of-type(2) tbody tr');
				document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target);
			} else {
				alert('등록실패!');
			}
		},
		function(err) {									// 세번째 매개값
			console.error(err)
		})


};




//svc.addReply();
