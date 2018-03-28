package inc.troll.mnemeprocess.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerException extends ErrorResponse{
	private static final long serialVersionUID = -4019294007010792478L;

	public InternalServerException(ErrorCode errorCode) {
		super(errorCode, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public InternalServerException(ErrorCode errorCode, String additionalMessageText) {
		super(errorCode, HttpStatus.INTERNAL_SERVER_ERROR, additionalMessageText);
	}
}
