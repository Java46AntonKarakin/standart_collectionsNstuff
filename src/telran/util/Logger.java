package telran.util;

import java.time.*;

public class Logger {
	
	public enum Level {
		ERROR, WARN, INFO, DEBUG, TRACE
	}

	private Logger.Level level = Logger.Level.INFO;
	private Handler handler;
	private String name;

	public Logger(Handler handler, String name) {
		this.handler = handler;
		this.name = name;
	}

	public void setLevel(Logger.Level level) {
		this.level = level;
	}

	public void error(String message) {
		handler.publish(getLogerRecord(Logger.Level.ERROR, message));
	}

	public void warn(String message) {
		if (this.level != Logger.Level.ERROR) {
			handler.publish(getLogerRecord(Logger.Level.WARN, message));
		}
	}

	public void info(String message) {
		if (this.level != Logger.Level.ERROR && this.level != Level.WARN) {
			handler.publish(getLogerRecord(Logger.Level.INFO, message));
		}
	}

	public void debug(String message) {
		if (this.level == Logger.Level.TRACE || this.level == Level.DEBUG) {
			handler.publish(getLogerRecord(Logger.Level.DEBUG, message));
		}
	}

	public void trace(String message) {
		if (this.level == Logger.Level.TRACE) {
			handler.publish(getLogerRecord(Logger.Level.TRACE, message));
		}
	}

	private LogerRecord getLogerRecord(Logger.Level unit, String message) {
		return new LogerRecord(Instant.now(), ZonedDateTime.now().getZone().toString(), unit, this.name, message);
	}
}


