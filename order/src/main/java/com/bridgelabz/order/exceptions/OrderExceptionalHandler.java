package com.bridgelabz.order.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.order.dto.ResponseDTO;


@ControllerAdvice																 // <- whenever controller gets in trouble he looks for solution in
public class OrderExceptionalHandler {									 //    @ControllerAdvice
	
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
		ResponseDTO response = new ResponseDTO("Invalid UserId input", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookException.class)
	public ResponseEntity<ResponseDTO> handleBookNotFound(BookException exception) {
		ResponseDTO response = new ResponseDTO("Invalid BookId input", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<ResponseDTO> handleOrderNotFound(OrderException exception) {
		ResponseDTO response = new ResponseDTO("Invalid OrderId input", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
}
