package inc.troll.mnemeprocess.exceptions;

public enum ErrorCode {
	
	/* --- Http-Status 4xx --- */
	BAD_REQUEST(4001, "Request could not be processed"),
	INVALID_JSON(4002, "Invalid JSON data"),
	HTTP_MESSAGE_NOT_READABLE(4003, "HTTP message not readable"),
	MISSING_BASIC_AUTH(4011, "Basic authentication is missing"),
	INVALID_BASIC_AUTH(4012, "Basic authentication is wrong"),
	ITEM_NOT_FOUND(4041, "Requested resource not found"),
    METHOD_NOT_ALLOWED(4051, "Requested HTTP methode is not supported"),
    CONFLICT(4091, "Conflicte with requested resource"),
	
	/* --- Http-Status 500 --- */
	INTERNAL_SERVER_ERROR(5001, "Internal server error"),
	
	/* --- Http-Status 501 --- */
	NOT_IMPLEMENTED(5011, "Function not implemented"),
	;
	
	final private int code;
	final private String message;
	
	private ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}