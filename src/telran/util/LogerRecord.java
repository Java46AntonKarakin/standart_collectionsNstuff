package telran.util;

import java.time.Instant;

public class LogerRecord {

	public Instant timestamp;
	public String zoneID;
	public Logger.Level level;
	public String loggerName;
	public String message;

	public LogerRecord(Instant timezonestamp, String zoneID, Logger.Level level, String loggerName, String message) {
		super();
		this.timestamp = timezonestamp;
		this.zoneID = zoneID;
		this.level = level;
		this.loggerName = loggerName;
		this.message = message;
	}

}
