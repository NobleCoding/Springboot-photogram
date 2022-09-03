package com.cos.photogramstart.web.dto.comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

// NotNull = null 값 체크
// NotEmpty = 빈값이거나 null 체크 
// NotBlank = 빈값, 빈공백 이거나 null 체크 

@Data
public class CommentDto {
	@NotBlank // 빈값, 빈 공백이거나 null 체크
	private String content;
	@NotNull // 빈값이거나 null 체크
	private Integer imageId;
	
	// toEntity 가 필요없다.
}
