package telran.tests;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Application for copying files based on static method copy of class Files
 * files may be very big (several Gbytes ) args[0] - source file path args[1] -
 * destination file path args[2] - if exists "overwritten" then destination may
 * be overwritten otherwise may not be Output one of the following: Files have
 * been copied (<amount of bytes> <time of copying>) Source file doesn't exist
 * Destination can not be overwritten
 *
 */
public class CopyFilesStandard {

	public static void main(String[] args) {
		try {
			
			var startOfCopying = LocalDateTime.now();

			FileOutputStream fos = new FileOutputStream(getDestinationFile(args));

			long amountOfBytesWritten = Files.copy(getPath(args[0]), fos);

			var timeCopyingTook = ChronoUnit.MILLIS.between(startOfCopying, LocalDateTime.now());

			System.out.printf("Copied <%s bytes> for <%d millis>", amountOfBytesWritten, timeCopyingTook);

		} catch (NoSuchFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.printf("Destination <%s> has non-existed directory in the path", args[1]);
		} catch (Exception e) {
			System.out.println("Unknown error : " + e.getMessage());
		}
	}

	private static Path getPath(String string) throws NoSuchFileException, IOException {
		Path res = Paths.get(string);
		if (!res.toFile().exists()) {
			throw new NoSuchFileException(String.format("Source file <%s> does not exist\n", string));
		}
		return res;
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
}
