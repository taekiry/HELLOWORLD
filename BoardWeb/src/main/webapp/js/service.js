/**
 * service.js <기능 정의>
 */
//js -> 중괄호 -> object속성.
const svc = {
	add: function(num1 = 0, num2 = 0) {
		return num1 + num2;
	},
	replyList(param = {bno, page},successCallback, errorCallback) {
		//ajax 호출.
		fetch('replyList.do?bno=' + param.bno + '&page=' + param.page)
			.then(response => response.json())
			.then(successCallback)
			.catch(errorCallback);
	},
	removeReply(rno, successCallback, errorCallback) {
		fetch('removeReply.do?rno=' + rno)
			.then(response => response.json())
			.then(successCallback)
			.catch(errorCallback);
	},
	addReply(param={bno, reply, replyer}, successCallback, errorCallback) { //{bno:bno, reply:reply, replyer:replyer} 속성과 value가 동일하면 줄여쓸수있음
		fetch('addReply.do', {
			method:'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded'},
			body: 'bno=' + param.bno + '&reply='+ param.reply + '&replyer=' + param.replyer
		})
			.then(response => response.json())
			.then(successCallback)
			.catch(errorCallback)
	}


}//end svc

function makeRowFnc(item) {
	let tr = document.createElement('tr');
	tr.setAttribute('data-rno', item.replyNo);
	//글번호,내용,작성자
		for (let prop of ['replyNo', 'reply', 'replyer']) {
			let td = document.createElement('td');
			td.innerHTML = item[prop];
			tr.appendChild(td);
		}
	//button 생성.
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	btn.className = 'btn btn-danger';
	btn.addEventListener('click', deleteReply);
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;
}



// 위의 add는 svc객체의 속성으로서 함수(add메소드) //밑은 그냥 함수.
const add = (num1, num2) => {
	return num1 + num2;
}

