package inc.troll.mnemeprocess.utils;

import inc.troll.mnemeprocess.exceptions.ErrorCode;
import inc.troll.mnemeprocess.exceptions.ErrorResponse;

public interface WithSystemLogger extends WithLogger {

	default void logDebug(String message) {
		systemLogger().debug(message);
	}
	
	default void logInfo(String message) {
		systemLogger().info(message);
	}
	
	default void logWarning(String message) {
		systemLogger().warn(message);
	}
	
	default void logWarning(ErrorResponse response) {
		systemLogger().warn("{}: {}", response.getCode(), response.getMessage());
	}
	
	default void logError(String message) {
		systemLogger().error(message);
	}
	
	default void logError(ErrorResponse response) {
		systemLogger().error("{}: {}", response.getCode(), response.getMessage());
	}
	
	default void logError(ErrorResponse response, Exception e) {
		systemLogger().error("{}: {}", response.getCode(), response.getMessage());
		logException(e);
	}
	
	default void logError(ErrorCode code, Exception e) {
		systemLogger().error("{}: {}", code.getCode(), code.getMessage());
		logException(e);
	}
	
	/* NOTE:
	 * log to DEBUG is correct.
	 * I do not want to see full exception in system log.
	 * All exceptions should appear in 'exception.log' file.
	 * TODO improve this, it's confusing code wise
	 */
	default void logException(Exception e) {
		systemLogger().debug(exceptionLogger(e)); 
	}
}
