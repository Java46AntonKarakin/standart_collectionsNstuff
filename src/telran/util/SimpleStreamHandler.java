package telran.util;

import java.io.PrintStream;
import java.time.*;
 
public class SimpleStreamHandler implements Handler {

	private PrintStream stream;

	public SimpleStreamHandler(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void publish(LogerRecord logerRecord) {
		
		stream.format("%s; %s; %s; %s;\n", LocalDateTime.now(ZoneId.of(logerRecord.zoneID)),
				logerRecord.level, logerRecord.loggerName, logerRecord.message);

	}

}
