package telran.util.tests;

import java.io.*;
import org.junit.jupiter.api.*;
import telran.util.*;

class SimpleStreamHandlerTest {
	static File logs = new File("logs.txt");
	static PrintStream prStrmTest;
	static PrintStream prStrmLogging;
	static BufferedReader bufferedReader;
	Logger logger = getLogger();
	
	String ERROR_EXSPRESSION = "error created";
	String WARN_EXSPRESSION = "warn created";
	String INFO_EXSPRESSION = "info created";
	String DEBUG_EXSPRESSION = "debug created";
	String TRACE_EXSPRESSION = "trace created";

	@BeforeAll
	static void beforeAll() {
		try {
			prStrmLogging = new PrintStream("logCollector.txt");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@BeforeEach
	void setUp() {
		logs.delete();
		prStrmLogging.append("* ".repeat(15));
	}

	@AfterEach
	void safeInterimResult() {
		try {
			bufferedReader = new BufferedReader(new FileReader(logs));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		bufferedReader.lines().forEach(x -> prStrmLogging.append(String.format("%s\n", x)));
		prStrmLogging.append("\n");
	}

	@AfterAll
	static void finish() {
		try {
			prStrmLogging.flush();
			bufferedReader.close();
			prStrmTest.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	void ErrorTest() {
		prStrmLogging.append("ErrorTest: \n");
		logger.setLevel(Logger.Level.ERROR);
		callLoggerMethods(logger, ERROR_EXSPRESSION);
	}

	@Test
	void WarnTest() {
		prStrmLogging.append("WarnTest: \n");
		logger.setLevel(Logger.Level.WARN);
		callLoggerMethods(logger, WARN_EXSPRESSION);
	}

	@Test
	void InfoTest() {
		prStrmLogging.append("InfoTest: \n");
		logger.setLevel(Logger.Level.INFO);
		callLoggerMethods(logger, INFO_EXSPRESSION);
	}

	@Test
	void DebugTest() {
		prStrmLogging.append("DebugTest: \n");
		logger.setLevel(Logger.Level.DEBUG);
		callLoggerMethods(logger, DEBUG_EXSPRESSION);
	}

	@Test
	void TraceTest() {
		prStrmLogging.append("TraceTest: \n");
		logger.setLevel(Logger.Level.TRACE);
		callLoggerMethods(logger, TRACE_EXSPRESSION);
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
			prStrmTest = new PrintStream(logs);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Logger(new SimpleStreamHandler(prStrmTest), "Logger created");
	}
}
