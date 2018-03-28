package inc.troll.mnemeprocess.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface WithLogger {
	
	default Logger systemLogger() {
		Logger logger = (Logger) LoggerFactory.getLogger("system");
		return logger;
	}
	
	default Logger interfaceLogger() {
		Logger logger = (Logger) LoggerFactory.getLogger("interface");
		return logger;
	}
	
	default String exceptionLogger(Exception e) {
		Logger logger = (Logger) LoggerFactory.getLogger("exception");
		StringWriter stringWriter = new StringWriter();
		StringBuilder stringBuilder = new StringBuilder();
		
		try {
			e.printStackTrace(new PrintWriter(stringWriter));
			
			stringBuilder.append(e.getMessage());
			stringBuilder.append(": ");
			stringBuilder.append(stringWriter.toString());
			stringBuilder.append("=====================================\n");
			String message = stringBuilder.toString();
			
			logger.error(message);
			return message;
		} catch (Exception ex) {
			exceptionLogger(ex);
			return "Exception while logging origin exception. (look exception log)";
		}		
	}
}
