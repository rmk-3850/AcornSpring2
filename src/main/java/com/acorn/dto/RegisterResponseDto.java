package com.acorn.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.acorn.common.ResponseCode;
import com.acorn.common.ResponseMessage;

import lombok.Getter;

// SignUpResponseDto : 회원가입 과정에서 발생하는 다양한 응답을 관리하는 DTO
@Getter
public class RegisterResponseDto extends ResponseDto {

	private RegisterResponseDto() {
		super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
	}

	// 회원가입 성공 시 응답 메소드
	public static ResponseEntity<RegisterResponseDto> success() {
		RegisterResponseDto result = new RegisterResponseDto();
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	// 닉네임 중복 시 응답 메소드
	public static ResponseEntity<ResponseDto> duplicateId() {
		ResponseDto result = new ResponseDto(ResponseCode.DUPLICATE_NICKNAME, ResponseMessage.DUPLICATE_NICKNAME);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

	// 이메일 중복 시 응답 메소드
	public static ResponseEntity<ResponseDto> duplicateEmail() {
		ResponseDto result = new ResponseDto(ResponseCode.DUPLICATE_EMAIL, ResponseMessage.DUPLICATE_EMAIL);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

	// 전화번호 중복 시 응답 메소드
	public static ResponseEntity<ResponseDto> duplicatePhone() {
		ResponseDto result = new ResponseDto(ResponseCode.DUPLICATE_PHONE, ResponseMessage.DUPLICATE_PHONE);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}
}
