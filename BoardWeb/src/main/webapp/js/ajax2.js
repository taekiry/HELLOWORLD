/**
 * ajax2.js
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

//삭제 메소드.

function deleteReply(e) {
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



svc.removeReply(239, function() { });



//svc.addReply();
