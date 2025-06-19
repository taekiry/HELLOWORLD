/**
 * cart.js
 */
// 장바구니 상품.
const cartItems = [{
	itemId: 1,
	itemName: "상품1",
	price: 2500,
	qty: 3,
	image: 'basket1.jpg'
}, {
	itemId: 2,
	itemName: "상품2",
	price: 3500,
	qty: 2,
	image: 'basket2.jpg'
}, {
	itemId: 3,
	itemName: "상품3",
	price: 4500,
	qty: 1,
	image: 'basket3.jpg'
}]
cartItems.forEach(product => {
	let sumP = product.price;
	sumP += product.price;
	let str = `<div id="cartList" class="row data" data-id="${product.itemId}">
				<div class="subdiv">
					<div class="check">
						<input type="checkbox" name="buy" value="260" checked="">&nbsp;
					</div>
					<div class="img">
						<img src="./images/${product.image}" width="60">
					</div>
					<div class="pname">
						<span>${product.itemName}</span>
					</div>
				</div>
				<div class="subdiv">
					<div class="basketprice">
						<input type="hidden" name="p_price" id="${product.itemId}" class="p_price"
							value="${product.price}">${product.price}원
					</div>
					<div class="num">
						<div class="updown">
							<input type="text" name="p_num1" id="${product.itemId}" size="2"
								maxlength="4" class="p_num" value="${product.qty}"
								onkeyup="javascript:basket.changePNum(event);"> <span
								onclick="javascript:basket.changePNum(event);"> <i
								class="fas fa-arrow-alt-circle-up up"></i>
							</span> <span onclick="javascript:basket.changePNum(event);"> <i
								class="fas fa-arrow-alt-circle-down down"></i>
							</span>
						</div>
					</div>
					<div class="sum">${product.price * product.qty}원</div>
				</div>
				<div class="subdiv">
					<div class="basketcmd">
						<a href="javascript:void(0)" class="abutton"
							onclick="javascript:basket.delItem(event);">삭제</a>
					</div>
				</div>
			</div>
		</div>`;
document.querySelector('#basket').insertAdjacentHTML('beforeend',str);
});


		
const basket = {
	
	totalQty(){
		let tqty = document.querySelectorAll('input[name="p_num1"]');
		let tprice = document.querySelectorAll('.data .sum');
		let sump = 0;
		let sumq = 0;	
		
		tprice.forEach(price =>{
			console.log(price);
			let p = price.innerHTML.substring(0,price.innerHTML.length-1);
			sump += parseInt(p)
		})
		tqty.forEach(quantity => {
				let qv = parseInt(quantity.value);
				sumq += qv;
				
			})
		document.querySelector('#sum_p_num span').innerText = sumq;
		document.querySelector('#sum_p_price span').innerText = sump;
	},
	
	// 장바구니 수량 변경.
	changePNum(e) {
	console.log(e.target);
	let elem = e.target
	let subdiv = elem.closest('div.subdiv');		// elem의 부모요소에서 <div class="subdiv"></div> 찾기
	let input = subdiv.querySelector('input[name="p_num1"]');
	let currentQty = parseInt(input.value);
	let inputPrice = subdiv.querySelector('input[name="p_price"]');
	let currentPrice = parseInt(inputPrice.value);
	console.log(currentQty);
	console.log(currentPrice);
	if(elem.classList.contains("up")){
		currentQty++;
	} else if(elem.classList.contains("down")){
		if(currentQty == 0){
			return;
		}
		currentQty--;
	}
	input.value = currentQty;
	subdiv.querySelector('.sum').innerText = currentQty * currentPrice +"원";
	
	this.totalQty();  
	},
	// 상품삭제.
	delItem(e) {
		let row = e.target.parentElement.parentElement.parentElement;
		row.innerHTML = "";
		this.totalQty();
	},
	// 선택상품삭제.
	delCheckedItem(e) {
		let checked = document.querySelector('.check input').checked;
		console.log(checked)
		if(checked){
			document.querySelectorAll('.data').innerHTML="";
		} else {
			return;
		}

	},
	// 장바구니 비우기.
	delAllItem() {
		document.getElementsByClassName('.data').innerHTML="";
	}
}

	basket.totalQty();