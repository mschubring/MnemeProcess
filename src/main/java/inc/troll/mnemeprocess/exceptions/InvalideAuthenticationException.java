package inc.troll.mnemeprocess.exceptions;

import org.springframework.http.HttpStatus;

public class InvalideAuthenticationException extends ErrorResponse {
	private static final long serialVersionUID = 6509515444292370519L;

	public InvalideAuthenticationException(ErrorCode errorCode) {
		super(errorCode, HttpStatus.UNAUTHORIZED);
	}
}
