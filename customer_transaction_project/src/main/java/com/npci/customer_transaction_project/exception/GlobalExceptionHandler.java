package com.npci.customer_transaction_project.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	// Handling Specific Exception

	@ExceptionHandler(ResourcesNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ResourcesNotFoundException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	// Handling Specific APIException

//	@ExceptionHandler(APIException.class)
//	public ResponseEntity<?> apiExceptionHandling(
//			APIException exception,
//			WebRequest request			
//			) {
//		ErrorDetails errorDetails = new ErrorDetails(
//				new Date(),exception.getMessage(),
//				request.getDescription(false)
//				);
//		
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	}

	// handling global exception

	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
