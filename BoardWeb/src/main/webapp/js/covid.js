/*
* covid.js
*/
//module방식 import로 사용가능.

import { makeRow, url } from './covid_module.js'

//document.querySelector('#centerList').innerHTML="Hello";
let centerAry;


fetch(url)
	.then(data => data.json())
	.then(result => {
		console.log(result.data);
		centerAry = result.data // { {}, {}, {}...{}} 284개
		//시도정보 배열
		let sidoAry = [];
		//tr , td2개
		//#centerList에 appendchild
		//[].forEach( function(elem, idx, ary배열그자체) {})
		centerAry.forEach((center, idx) => {
			//sidoAry에 중복값 없이 담기.
			if (sidoAry.indexOf(center.sido) == -1) {
				sidoAry.push(center.sido);
			}
			if (idx < 10) {
				let tr = makeRow(center); //covid_module.js
				document.querySelector('#centerList').appendChild(tr);
			}
		})
		console.log(sidoAry); //sidoAry 종류별로 담았는지 확인.
		//sidoAry의 갯수만큼 <option value="sido정보">sido정보</option>
		sidoAry.forEach(sido => {
			let opt = document.createElement('option');
			opt.value = sido;
			opt.innerHTML = sido;
			document.getElementById('sido').appendChild(opt);
		});
	})//end then
	.catch(err => console.log(err))

// event.
document.querySelector('button.btn-primary').addEventListener('click', function(e) {
	//목록 초기화
	document.querySelector('#centerList').innerHTML = "";
	let keyword = document.getElementById('centerName').value;
	centerAry
		.reduce((acc, center) => {
			if(center.sido == keyword) {
				let tr = makeRow(center);
				acc.appendChild(tr);
			}
			return acc; //return해야 다음 초기값으로들어감.
		},document.querySelector('#centerList')) //, reduce함수의 초기값
		//.filter((center) => center.centerName.indexOf(keyword) != -1)	//-1은 값이 없음을 의미 몇번째에 있냐 했는데 -1이니까
		//.filter(center => center.centerName.includes(keyword))
		//.forEach(center => {
		//	let tr = makeRow(center);
		//	document.querySelector('#centerList').appendChild(tr);
		//})
}); //end function


//select태그의 change이벤트.
document.querySelector('#sido').addEventListener('change', function(e) {
	//목록 클리어
	document.querySelector('#centerList').innerHTML = "";
	let sido1 = document.getElementById('sido').value;
	centerAry
		.filter(center => center.sido == sido1)
		.forEach(center => {
			let tr = makeRow(center);
			document.querySelector('#centerList').appendChild(tr);
		})
});

//[].push() 넣기, [].unshift(), [].pop(), [].shift(), [].splice() 특정위치 추가,수정,삭제 가능
// reduce(); 메소드



// return center.centerName.indexOf(keyword) != -1	//-1은 값이 없음을 의미 몇번째에 있냐 했는데 -1이니까

// });//end filter
// console.log(filterAry);
// filterAry.forEach(center => {
// 	let tr = makeRow(center);
// 	document.querySelector('#centerList').appendChild(tr);
// })


let result = [1, 3, 5, 7].reduce(function(acc, elem, idx, ary){
	console.log(acc,elem);
	// return acc + elem;
	if(elem > 4) {
		let li = document.createElement('li');
		li.innerText = elem;
		acc.appendChild(li);
	}
	return acc;
	//return acc < elem ? elem : acc; // max값 반환
}, document.querySelector('#target'));

	console.log('결과: ', result);
