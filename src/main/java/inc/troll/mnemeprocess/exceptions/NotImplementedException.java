package inc.troll.mnemeprocess.exceptions;

import org.springframework.http.HttpStatus;

public class NotImplementedException extends ErrorResponse{
	private static final long serialVersionUID = -2343418784252635045L;

	public NotImplementedException(ErrorCode errorCode) {
		super(errorCode, HttpStatus.NOT_IMPLEMENTED);
	}
}
