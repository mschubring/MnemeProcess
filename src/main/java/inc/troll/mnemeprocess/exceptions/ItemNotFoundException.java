package inc.troll.mnemeprocess.exceptions;

import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends ErrorResponse {
	private static final long serialVersionUID = -6050915610443199523L;

	public ItemNotFoundException(ErrorCode errorCode) {
		super(errorCode, HttpStatus.NOT_FOUND);
	}
}
