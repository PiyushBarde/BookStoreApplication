package com.bridgelabz.userregistration.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import com.bridgelabz.userregistration.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice									// <- whenever controller gets in trouble he looks for solution in
public class UserExceptionalHandler {				//    @ControllerAdvice
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		
		List<ObjectError> errorList=exception.getBindingResult().getAllErrors(); //<- binds all the errors & exceptions  and stores in error list,
		List<String> errMesg = errorList.stream()								 //and handles the validation part & showing the issues in REST call
							.map(objErr->objErr.getDefaultMessage())		
							.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST requests",errMesg);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ResponseDTO> handleUserNotFound(UserException exception) {
		ResponseDTO response = new ResponseDTO("Invalid Userid input", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PasswordException.class)
	public ResponseEntity<ResponseDTO> handleUserNotFound(PasswordException exception) {
		ResponseDTO response = new ResponseDTO("Invalid password input", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
}
