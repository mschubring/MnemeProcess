package inc.troll.mnemeprocess.exceptions.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import inc.troll.mnemeprocess.exceptions.DataInconsistancyException;
import inc.troll.mnemeprocess.exceptions.ErrorCode;
import inc.troll.mnemeprocess.exceptions.ErrorResponse;
import inc.troll.mnemeprocess.exceptions.InternalServerException;
import inc.troll.mnemeprocess.exceptions.InvalideAuthenticationException;
import inc.troll.mnemeprocess.exceptions.ItemConflictException;
import inc.troll.mnemeprocess.exceptions.ItemNotFoundException;
import inc.troll.mnemeprocess.exceptions.NotImplementedException;
import inc.troll.mnemeprocess.utils.WithInterfaceLogger;

@ControllerAdvice(basePackages="inc.troll.mnemeprocess.rest")
public class RestExceptionHandler implements WithInterfaceLogger {
	
	/********************
	* Custom exceptions *
	********************/
	@ExceptionHandler(value = {
		InternalServerException.class,
		InvalideAuthenticationException.class,
		ItemConflictException.class,
		ItemNotFoundException.class,
		DataInconsistancyException.class,
		DataInconsistancyException.class,
		NotImplementedException.class
	})
	public ResponseEntity<ErrorResponse> handleInternalServerError(HttpServletRequest request, HttpServletResponse response, ErrorResponse errorResponse) {
		logErrorResponse(request, errorResponse);
		return new ResponseEntity<ErrorResponse>(errorResponse, errorResponse.getHttpStatus());
	}

	/************************
	* Non-Custom exceptions *
	************************/
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleBodyNotReadable(HttpServletRequest request, HttpServletResponse response, HttpMessageNotReadableException e) {
		ErrorResponse errorResponse = new ErrorResponse(ErrorCode.HTTP_MESSAGE_NOT_READABLE, HttpStatus.BAD_REQUEST, e.getMostSpecificCause().getMessage());
		logErrorResponse(request, errorResponse);
		logException(e);
		return new ResponseEntity<ErrorResponse>(errorResponse, errorResponse.getHttpStatus());
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleHttpArgumentNotValid(HttpServletRequest request, HttpServletResponse response, MethodArgumentNotValidException e) {
		StringBuilder causingFields = new StringBuilder();
		
		String listSeparater = "";
		for(FieldError err : e.getBindingResult().getFieldErrors()) {
			causingFields.append(listSeparater);
			causingFields.append(err.getField());
			listSeparater = " , ";
		}
		
		ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INVALID_JSON, HttpStatus.BAD_REQUEST, causingFields.toString());
		logErrorResponse(request, errorResponse);
		logException(e);
		return new ResponseEntity<ErrorResponse>(errorResponse, errorResponse.getHttpStatus());
	}
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse> handleArgumentTypeMismatch(HttpServletRequest request, HttpServletResponse response, MethodArgumentTypeMismatchException e) {
		ErrorResponse errorResponse = new ErrorResponse(ErrorCode.ITEM_NOT_FOUND, HttpStatus.NOT_FOUND);
		logErrorResponse(request, errorResponse);
		logException(e);
		return new ResponseEntity<ErrorResponse>(errorResponse, errorResponse.getHttpStatus());
	}
	
	// default exception handler
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> handleDefault(HttpServletRequest request, HttpServletResponse response, Exception e) {	
		ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
		logErrorResponse(request, errorResponse);
		logException(e);
		return new ResponseEntity<ErrorResponse>(errorResponse, errorResponse.getHttpStatus());
	}
	
	private void logErrorResponse(HttpServletRequest request, ErrorResponse errorResponse) {
		logError(errorResponse);
	}
}
