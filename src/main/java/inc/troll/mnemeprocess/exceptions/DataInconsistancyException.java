package inc.troll.mnemeprocess.exceptions;

import org.springframework.http.HttpStatus;

public class DataInconsistancyException extends ErrorResponse {
	private static final long serialVersionUID = 4438821626997409000L;

	public DataInconsistancyException(ErrorCode errorCode) {
		super(errorCode, HttpStatus.BAD_REQUEST);
	}
	
	public DataInconsistancyException(ErrorCode errorCode, String additionalMessageText) {
		super(errorCode, HttpStatus.BAD_REQUEST, additionalMessageText);
	}
}
