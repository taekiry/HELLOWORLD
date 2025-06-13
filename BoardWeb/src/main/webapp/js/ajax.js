/**
 *  ajax.js
 * Asynchronous Javascript And XML
 */

// 비동기 vs 동기 방식 (Asynchronous 비동기) 왜 비동기를 쓰는가? 동시에 시작. 더 효율적으로 처리가능. 대신 처리선후가 달라져서 고민필요
/*setTimeout(function(){
	console.log("1");	
},1000); //function을 매개값으로, 1000 ms-> 1초후 실행

setTimeout(function(){
	console.log("2");	
},2000); 

setTimeout(function(){
	console.log("start");	
},2500); //function을 매개값으로, 1000 ms-> 1초후 실행*/

//비동기방식 -> 전체 2500ms면 모든 작업이 끝남
/*setTimeout(function(){
	console.log("1");
	setTimeout(function(){
		console.log("2");
		setTimeout(function(){
			console.log("start");	
		},2500);	
	},2000); 	
},1000); */
//동기방식-> 1작업 후 2작업 실행 총시간 -> 5500ms


// {"id":1, "first_name": "Hong"} => json객체
// --> {id: 1, first_name : "Hong"} => javaScript객체로 parsing

// 객체 XMLHttpRequest - 비동기방식


let xhtp = new XMLHttpRequest();
xhtp.open('get', 'replyList.do?bno=239'); //매개값 1.방식 2.url 요청할 페이지 지정.
xhtp.send(); //지정된 페이지 요청
xhtp.onload = function() {
	//console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText); //Json 문자열 -> 자바스크립트 객체로 변환해서 저장
	console.log(data);
	data.forEach(function(item) {
		//console.log(item) //item이 뭔지 파악해야함 항상
		let tr = makeRowFnc(item);
		
		//tr을 두번째 tbody에 추가. 
		document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
		
	})
	//document.querySelector('#show').innerHTML = xhtp.responseText;  //html도 가져올수있음. db에추가 삭제등은 서버프로그램이
	// ajax는 호출만 가능.
}


// 등록 이벤트.

document.querySelector('#addReply').addEventListener('click',addReplyFnc);
// 등록 fnc
function addReplyFnc(e){
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	
	// 필수입력 알려줘야함 null에러발생
	if(!bno || !reply || !logId){ //logId는 prductList.jsp에 따로 선언해둠.
		alert('필수값 입력!')
		return;
	}
	const addAjax = new XMLHttpRequest();	
	addAjax.open('get','addReply.do?bno='+ bno + '&reply=' + reply +'&replyer='+ logId);
	addAjax.send();
	addAjax.onload = function() {
		let result = JSON.parse(addAjax.responseText);
		if(result.retCode == 'Success'){
			alert('등록성공!');
			let tr = makeRowFnc(result.retCode);
			//부모요소.insertBefore(새로운 요소, 대상)
			let target = document.querySelector('table:nth-of-type(2) tbody tr')
			document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr,target);
			//document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
		} else{
			alert('등록실패!');
		}
	}
	
}//end addReply(e) 

// 댓글 삭제 fnc

function deleteReplyFnc(e) { 									//event에 쓸 함수의 매개값은 event e로 정해져있음.
	if(!confirm("삭제하시겠습니까?")){            					//
		return;
	}															//console에 찍어보니 pointerEvent 객체 -> target속성에 value가 btn
	let rno = e.target.parentElement.parentElement.dataset.rno; // data-* 이름을 가진 data들을 dataset에 모두 저장됨-> data-중에서 data-rno를 반환해줌
	console.log(rno)															// rno에 저장해둬야지 parameter로 db에 전달
	const delAjax = new XMLHttpRequest();
	delAjax.open('get','removeReply.do?rno=' + rno);
	delAjax.send();
	delAjax.onload = function(ev){								//addeventlistner랑 같은역할.
		let result = JSON.parse(delAjax.responseText);
		if (result.retCode == 'Success'){
			alert("삭제성공");
			e.target.parentElement.parentElement.remove(); 		// target -> tr안에 td안에 btn 삭제누를 시 tr자체가 없어지게
		} else {
			alert('처리실패')
		}
	} //deleteReplyFnc
	
}

//댓글을 화면에 출력하는 Fnc

function makeRowFnc(item){
	let tr = document.createElement('tr');				     		//document영역에 <tr></tr>만들어줌
		tr.setAttribute('data-rno',item.replyNo);				 //tr안에 댓글번호 값을 담아두려고 -> 삭제시 getattribute로 찾기쉽게
		//글번호,내용,작성자
		for (let prop of ['replyNo', 'reply', 'replyer']) {
			let td = document.createElement('td');
			td.innerHTML = item[prop];							 //<td></td> 안에 넣겟습니다 innerHTML item.replyNo = item['replyNo']
			tr.appendChild(td);
		}
		//button 생성.
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerHTML = '삭제';
		btn.className = 'btn btn-danger';
		btn.addEventListener('click', deleteReplyFnc);			//2개 매개값 1.event 유형 2. 실행할 함수 길어지면 밖으로 따로
		td.appendChild(btn);
		tr.appendChild(td);
		return tr;  //item을 받아서 tr을 만드는 함수
}



function memberList() {		 //javascript on*은 속성 -> on속성에 load가 발생하면
	console.log("1");
	//console.log(xhtp);				//xhtp에 무슨속성 있나 찾아보기위해
	//console.log(xhtp.responseText); //xhtp에 저장된 sample.json이 response와 responseText에 저장됨.
	//parsing
	let data = JSON.parse(xhtp.responseText);
	//console.log(data);
	let str = "<ul>"
	data.forEach(function(item, idx, arr) {
		console.log(item);
		str += "<li>" + item.id + "," + item.first_name + "</li>";
	});
	str += "</ul>"

	document.querySelector('#show').innerHTML = str;
}
console.log("end");






//fetch('data/sample.json')

/* .then(resolve => resolve.json())
 .then(data => {
   console.log(data); //[{},{}...20개배열]
   data.forEach(function(item, idx, arr){  //forEach function을 인수로 function(1.요소,2.인덱스,3.타입)
		   	
   });
 })
 .catch(err => {
   console.log(err);
 })*/