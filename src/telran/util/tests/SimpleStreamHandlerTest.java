package telran.util.tests;

import java.io.*;
import org.junit.jupiter.api.*;
import telran.util.*;

class SimpleStreamHandlerTest {
	 static File logs = new File("logs.txt");
	PrintStream prStrTest;
	 static PrintStream prStrmLogging;
	 static BufferedReader bufferedreader;
	 Logger logger = getLogger();

	@BeforeAll
	static void beforeAll() {
		try {
			prStrmLogging = new PrintStream("logCollector.txt");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@BeforeEach
	void setUp() throws IOException {
		logs.delete();
		prStrmLogging.append("* ".repeat(15));
	}
	
	@AfterEach
	void safeInterimResult() {
		try {
			bufferedreader = new BufferedReader(new FileReader(logs));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		bufferedreader.lines().forEach(x -> prStrmLogging.append(String.format("%s\n", x)));
		prStrmLogging.append("\n");
	}

	@AfterAll
	static void finish() {
		try {
			prStrmLogging.flush();
			bufferedreader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	void ErrorTest() {
		prStrmLogging.append("ErrorTest: \n");
		logger.setLevel(Logger.Level.ERROR);
		callLoggerMethods(logger, "error created");
	}

	@Test
	void WarnTest() {
		prStrmLogging.append("WarnTest: \n");
		logger.setLevel(Logger.Level.WARN);
		callLoggerMethods(logger, "warn created");
	}

	@Test
	void InfoTest() {
		prStrmLogging.append("InfoTest: \n");
		logger.setLevel(Logger.Level.INFO);
		callLoggerMethods(logger, "info created");
	}

	@Test
	void DebugTest() {
		prStrmLogging.append("DebugTest: \n");
		logger.setLevel(Logger.Level.DEBUG);
		callLoggerMethods(logger, "debug created");
	}

	@Test
	void TraceTest() {
		prStrmLogging.append("TraceTest: \n");
		logger.setLevel(Logger.Level.TRACE);
		callLoggerMethods(logger, "trace created");
	}

	private void callLoggerMethods(Logger logger, String message) {
		logger.error(message);
		logger.warn(message);
		logger.info(message);
		logger.debug(message);
		logger.trace(message);
	}

	private Logger getLogger() {
		try {
			logs.createNewFile();
			prStrTest = new PrintStream(logs);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Logger(new SimpleStreamHandler(prStrTest), "Logger created");
	}
}
