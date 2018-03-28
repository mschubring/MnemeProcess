package inc.troll.mnemeprocess.utils;

import inc.troll.mnemeprocess.exceptions.ErrorCode;
import inc.troll.mnemeprocess.exceptions.ErrorResponse;

public interface WithInterfaceLogger extends WithLogger {
	
	default void logDebug(String message) {
		interfaceLogger().debug(message);
	}
	
	default void logInfo(String message) {
		interfaceLogger().info(message);
	}
	
	default void logError(String message) {
		interfaceLogger().error(message);
	}
	
	default void logError(ErrorResponse response) {
		interfaceLogger().error("{}: {}", response.getCode(), response.getMessage());
	}
	
	default void logError(ErrorResponse response, Exception e) {
		interfaceLogger().error("{}: {}", response.getCode(), response.getMessage());
		logException(e);
	}
	
	default void logError(ErrorCode code, Exception e) {
		interfaceLogger().error("{}: {}", code.getCode(), code.getMessage());
		logException(e);
	}
	
	default void logException(Exception e) {
		interfaceLogger().debug(exceptionLogger(e));
	}
}
