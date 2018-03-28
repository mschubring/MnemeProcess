package inc.troll.mnemeprocess.exceptions;

import org.springframework.http.HttpStatus;

public class GepadoConnectionException extends ErrorResponse {
	private static final long serialVersionUID = -6345743141571088979L;

	public GepadoConnectionException(ErrorCode errorCode) {
		super(errorCode, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public GepadoConnectionException(ErrorCode errorCode, String additionalMessageText) {
		super(errorCode, HttpStatus.INTERNAL_SERVER_ERROR, additionalMessageText);
	}
}
