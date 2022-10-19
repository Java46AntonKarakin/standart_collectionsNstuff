package telran.tests;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Application for copying files based on FileInputStream and FileOutputStream
 * files may be very big (several Gbytes ) args[0] - source file path args[1] -
 * destination file path args[2] - if exists "overwritten" then destination may
 * be overwritten otherwise may not be Output one of the following: Files have
 * been copied (<amount of bytes> <time of copying>) Source file doesn't exist
 * Destination can not be overwritten
 *
 */
public class CopyFilesInputOutputStreams {
	static final int VOLUME_OF_BYTE_ARRAY = 65542;

	public static void main(String[] args) {
		try {
			
			var startOfCopying = LocalDateTime.now();
			long totalReadBytes = copyFile(new FileInputStream(getSourceFile(args[0])),
			new FileOutputStream(getDestinationFile(args)));
			
			var timeCopyingTook = ChronoUnit.MILLIS.between(startOfCopying, LocalDateTime.now());
			System.out.printf("Copied <%s bytes> for <%d millis>", totalReadBytes, timeCopyingTook);
			
		} catch (NoSuchFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.printf("Destination <%s> has non-existed directory in the path", args[1]);
		} catch (Exception e) {
			System.out.println("Unknown error : " + e.getMessage());
		}
	}

	private static long copyFile(FileInputStream fis, FileOutputStream fos)
			throws IOException {
		
		byte[] tmp = new byte[VOLUME_OF_BYTE_ARRAY];
		int readableValue;
		long totalBytesRead = 0;
		
		do {
			readableValue = fis.read(tmp);
			totalBytesRead += readableValue;
			fos.write(tmp, 0, tmp.length);
		}
		while (readableValue > 0);
		
		fis.close();
		fos.close();
		return totalBytesRead;
	}

	private static File getDestinationFile(String[] args) throws NoSuchFileException, IOException {
		File res = new File(args[1]); 
		if (!res.exists() || args.length == 3 && args[2].equals("overwritten")) {
			res.createNewFile();
		} else {
			throw new NoSuchFileException(String.format("Destination file <%s> cannot be overwritten\n", args[1]));
		}
		return res;
	}

	private static File getSourceFile(String path) throws NoSuchFileException, IOException {
		File res = new File(path);
		if (!res.exists()) {
			throw new NoSuchFileException(String.format("Source file <%s> does not exist\n", path));
		}
		return res;
	}
}
