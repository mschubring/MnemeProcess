package inc.troll.mnemeprocess.exceptions;

import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"cause", "stackTrace", "localizedMessage", "suppressed"})
public class ErrorResponse extends RuntimeException {
	private static final long serialVersionUID = 8123188410138821516L;
	
	private ErrorCode errorCode;
	private HttpStatus httpStatus;
	private int code;
	private String message;
	
	public ErrorResponse(ErrorCode errorCode, HttpStatus httpStatus) {
		this.errorCode = errorCode;
		this.message = errorCode.getMessage();
		this.code = errorCode.getCode();
		this.httpStatus = httpStatus;
	}
	
	public ErrorResponse(ErrorCode errorCode, HttpStatus httpStatus, String additionalMessageText) {
		this.errorCode = errorCode;
		this.message = errorCode.getMessage() + " (" + additionalMessageText + ")";
		this.code = errorCode.getCode();
		this.httpStatus = httpStatus;
	}
	
	@JsonIgnore
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	@JsonIgnore
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	@JsonProperty("status")
	public int getStatus() {
		return httpStatus.value();
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
