// (1) 회원정보 수정
function update(userId, event) {
	event.preventDefault(); // 폼태그 액션 비활성화
	// form 태그 아이디로 serialize
	let data = $("#profileUpdate").serialize();
	console.log(data);
	
	$.ajax({
		type:"put",
		url: `/api/user/${userId}`,
		data:data,
		contentType:"application/x-www-form-urlencoded; charset=utf-8",
		dataType:"json"
	}).done(res=>{ // HttpStatus 상태코드 200번대
		console.log("성공", res);
		location.href=`/user/${userId}`;
	}).fail(error=>{ // Httpstatus 상태코드 200번대 아닐 때
		if(error.date == null){
			alert(error.responseJSON.message);
		}else{
			alert(JSON.stringify(error.responseJSON.data));
			//console.log("실패", error.responseJSON.data);
		}
		

	});
}