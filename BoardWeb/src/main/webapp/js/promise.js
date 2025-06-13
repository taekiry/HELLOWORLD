/**
 * promise.js
 */

// 비동기방식 코드 -> 위에서 밑으로 순서대로 처리되지 않는다.

/*let promise = new Promise(function(resolve, reject){
	setTimeout(function(){
		resolve("성공했을 때 실행할 함수.");
	},1000);
	
	//reject("실패시 실행")
});

promise
.then(function(data){		//Promise의 매개값함수의 resolve라는 함수. 그 매개값이 ""안의 구문
	console.log(data);              //.then() -> resolve실행시 data(""안의 구문)값을 받아옴.
	return new Promise(function(resolve, reject){
		resolve("두번째 호출")
	})
})
.then(function(result){
	console.log(result);
})
.catch(function(err){
	console.log('=>',err);			//.catch() -> reject 실행시 err
})*/


//promise의 역할: 
//비동기 방식의 처리를 동기방식으로 구성해서 이해하기 쉽게. .then -> .then 순서

//화살표 함수.
	function add(num1, num2){
		return num1 + num2;
	}
	
	const add1 = (num1, num2) => {
		return num1 + num2;
	}
	
	const add2 = (num1, num2) => num1 + num2;
	console.log(add2(1,2));
	

// 목록 출력
fetch('replyList.do?bno=239') 						//Promise 기반 API 책 144pg
.then(function(data){								//then method에 함수를 매개값. JS에서는 가능.
	//console.log(data);  							//Response 결과값(java 객체)
	return data.json();								//json -> object 성공하면 그다음 then 
})
.then(function(result){
	//console.log(result);
	result.forEach(function(item){
		//console.log(item);
		
		let tr = makeRowFnc(item);
		document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
	})
})
.catch(function(err){
	//data, result어디서 에러가 뜨면 .catch가 err실행.	
	console.log(err);
})// end of 목록 출력.




function makeRowFnc(item){
	let tr = document.createElement('tr');				     	
		tr.setAttribute('data-rno',item.replyNo);				 
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

function deleteReply(e) { 									
	if(!confirm("삭제하겠습니까?")){
		return;
	}
	//removeReply.do?rno=23형식 만들어야됨.
	let rno = e.target.parentElement.parentElement.dataset.rno; //ajax 호출 e.target = btn -> td -> tr의 data-rno를 저장
	
	fetch('removeReply.do?rno='+ rno)
	.then(response => response.json())	// function(json){ return json.json()})을 짧게쓴것. 화살표 함수
	
	.then(data => {
		if(data.retCode == 'Success'){
			alert('삭제성공!');
			e.target.parentElement.parentElement.remove();
		} else {
			alert('삭제실패!');			
		}
	})
	.catch(err => console.log(err));
	
}

// 댓글 등록 
document.querySelector('#addReply').addEventListener('click',addReply);
//fetch(url) -> get방식
//fetch(url, option)
function addReply(e){
	
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	if(!bno || !reply || !logId){ //logId는 prductList.jsp에 따로 선언해둠.
			alert('필수값 입력!')
			return;
	}		
	/*fetch('addReply.do?bno='+ bno + '&reply=' + reply +'&replyer='+ logId)
	.then(response => response.json()) 
	.then(result => {
		if(result.retCode == 'Success'){
			alert('등록성공!');
			let tr = makeRowFnc(result.retVal);
			let target = document.querySelector('table:nth-of-type(2) tbody');
			document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr,target);
		} else {
			alert('등록실패!');
		}
	})
	.catch(err => console.log(err));*/
	
	
	fetch('addReply.do',{
		method: 'post',
		headers: {'Content-Type': 'application/x-www-form-urlencoded'},  //어렵당
		body: 'bno=' + bno +'&reply=' + reply + '&replyer=' + logId
	})
		.then(response => response.json()) 
		.then(result => {
			if(result.retCode == 'Success'){
				alert('등록성공!');
				let tr = makeRowFnc(result.retVal);
				let target = document.querySelector('table:nth-of-type(2) tbody');
				document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr,target);
			} else {
				alert('등록실패!');
			}
		})
		.catch(err => console.log(err));

}





