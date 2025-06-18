<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h3>회원가입(signForm.jsp)</h3>
<form name="signForm" action="signup.do" method="post"
	enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input class="form-control" type="text" required name="userId"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input class="form-control" type="password" required name="userPw"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input class="form-control" type="text" required name="userName"></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><input class="form-control" type="file" name="userImg"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-primary" value="회원가입"> <input type="reset"
				class="btn btn-secondary" value="초기화"></td>
	</table>
</form>
<script>
// document.forms
	let check = false;
	console.log(document.forms);
	
	document.forms.signForm.addEventListener('submit', function(e){
	  if(!check){
		e.preventDefault(); // submit시에 페이지 이동을 차단.
		alert('입력값을 확인하세요');
		return;
	  } 
//	  this.submit();
	})
	//ID validation
	document.querySelector('input[name="userId"]').addEventListener('change',function(e){
		console.log(this); 							//event에서 this쓰면 이벤트의 대상임.
		let user = this.value;
		//회원 입력값 check
			fetch('checkId.do?id='+user)
			.then(data => data.json())
			.then(result => {
				if(result.retCode == "Exist"){
					alert("존재하는 아이디");
				} else {
					alert('사용가능한 아이디');
					pwValidation();
				}
			})
			.catch(err => console.log(err))
		})
		
		
	//PW validation	
function pwValidation(){
	document.querySelector('input[name="userPw"]').addEventListener('change',function(e){
	let pw = this.value;
		if(pw.length >= 5){
			check = true;
		} else {
 			alert("비밀번호는 5자 이상 입력")
 			check = false;
		}
		
	})
}
</script>