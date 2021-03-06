package com.empapp.controller.exceptions;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.empapp.service.EmployeeNotFoundException;

@ControllerAdvice //throws advice
@RestController
public class ExceptionHandlerController  extends ResponseEntityExceptionHandler {

	//EmployeeNotFoundException
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEmployeeNotFoundException(EmployeeNotFoundException ex,
			WebRequest request){
		
		System.out.println("--------------emp is not found--------------");
		
		ErrorDetails details=new ErrorDetails(new Date(), "emp validation failed", 
				request.getDescription(false), "rgupta.mtech@gmail.com");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
		
	}
	//any other then EmployeeNotFoundException
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails details=new ErrorDetails(new Date(), "emp validation failed", 
				request.getDescription(false), "rgupta.mtech@gmail.com");
		
		return new ResponseEntity<Object>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//to handle server side validation for spring rest
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid (MethodArgumentNotValidException ex,
	    HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		BindingResult bindingResult = ex.getBindingResult();
		
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		StringBuilder builder=new StringBuilder("validation failed for : ");
		
		for(FieldError fe:fieldErrors ) {
			builder.append(fe.getField()).append(" ,");
			
		}
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(),"validation failed", builder.toString(),
				"rgupta.mtech@gmail.com");
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	} 
	
	
}




