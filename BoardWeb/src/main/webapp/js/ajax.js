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

console.log("start");
let xhtp = new XMLHttpRequest();
xhtp.open('get', 'replyList.do?bno=239'); //매개값 1.방식 2.url 요청할 페이지 지정.
xhtp.send(); //지정된 페이지 요청
xhtp.onload = function() {
	console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);
	data.forEach(function(item) {
		let tr = document.createElement('tr');//document영역에 <tr>만들어줌
		//글번호,내용,작성자
		for (let prop of ['replyNo', 'reply', 'replyer']) {
			let td = document.createElement('td');
			td.innerHTML = item[prop]; //<td></td> 안에 넣겟습니다 innerHTML item.replyNo = item['replyNo']
			tr.appendChild(td);
		}
		//button 생성.
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerHTML = '삭제';
		btn.className = 'btn btn-danger';
		td.appendChild(btn);
		tr.appendChild(td);
		
		//document.querySelector('button').addEventListener('click',)
		document.querySelector('tbody').appendChild(tr);
	})
	//document.querySelector('#show').innerHTML = xhtp.responseText;  //html도 가져올수있음. db에추가 삭제등은 서버프로그램이
	// ajax는 호출만 가능.
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




fetch('data/sample.json')

/* .then(resolve => resolve.json())
 .then(data => {
   console.log(data); //[{},{}...20개배열]
   data.forEach(function(item, idx, arr){  //forEach function을 인수로 function(1.요소,2.인덱스,3.타입)
		   	
   });
 })
 .catch(err => {
   console.log(err);
 })*/