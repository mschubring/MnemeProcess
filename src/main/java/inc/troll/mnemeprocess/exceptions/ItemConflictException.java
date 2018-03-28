package inc.troll.mnemeprocess.exceptions;

import org.springframework.http.HttpStatus;

public class ItemConflictException extends ErrorResponse {
	private static final long serialVersionUID = 53486041287924808L;

	public ItemConflictException(ErrorCode errorCode) {
		super(errorCode, HttpStatus.CONFLICT);
	}
}
