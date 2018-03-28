package inc.troll.mnemeprocess.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidJsonException extends ErrorResponse {
	private static final long serialVersionUID = 3688238010145659457L;

	public InvalidJsonException(ErrorCode errorCode) {
		super(errorCode, HttpStatus.BAD_REQUEST);
	}
	
	public InvalidJsonException(ErrorCode errorCode, String additionalMessageText) {
		super(errorCode, HttpStatus.BAD_REQUEST, additionalMessageText);
	}
}
