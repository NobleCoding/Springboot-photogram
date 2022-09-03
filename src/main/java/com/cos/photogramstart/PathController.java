package com.cos.photogramstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathController {
	
	@GetMapping("/chicken")
	public String chickenQuery(String type) {
		return type+"배달 갑니다. (쿼리 스트링)";
	}
	
	@GetMapping("/chicken/{type}")
	public String chickenPath(@PathVariable String type) {
		return type+"배달갑니다. (주소 매핑 기법)";
	}
	
	@GetMapping("/resp/json/object")
	public User respJsonObject() {
		User user= new User();
		user.setUsername("홍길동");
		return user;
	}
}
