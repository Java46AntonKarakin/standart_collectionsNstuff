package telran.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FileTests {
	File file;

	@BeforeEach
	void setUp() {
		file = new File("dir1/dir2");
		file.delete();
	}

	@Test
	void newDirectoryTest() {

		assertFalse(file.exists());
		file.mkdirs();
		assertTrue(file.exists());
	}

	@Test
	void printDirectoryContent() {
		try {
			printDirectory("..", 3, 1);
		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}
	}

	/**
	 * @param pathName - name of path to initial directory
	 * @param level    - level of sub-directories printing example, level = 1
	 *                 printing only first level of the initial directory content
	 *                 level = 2 content + sub-directories content '''''''' level =
	 *                 -1 printing all levels
	 * 
	 *                 <dir> type=dir <dir> type=dir <file> type=file <dir> type=dir
	 *                 ...
	 * @throws IOException
	 */
	public static void printDirectory(String path, int level, int gaps) {

		File currentFile = new File(path);
		if (currentFile.isDirectory() && (level > 0 || level < 0)) {
			printCurrentFile(gaps, currentFile);
			List<File> listOfFiles = getListOfFilesOrdered(currentFile);

			if (!listOfFiles.isEmpty()) {
				for (File file : listOfFiles) {
					printDirectory(file.getPath(), level - 1, gaps + 1);
				}
			}
		} else {
			printCurrentFile(gaps, currentFile);
		}
	}

	private static void printCurrentFile(int gaps, File currentFile) {
		System.out.println(String.format("%s %s %s", "   ".repeat(gaps),
				(currentFile.isDirectory() ? "<dir>" : "<file>"), currentFile.getName()));
	}

	private static List<File> getListOfFilesOrdered(File file) {
		return Arrays.stream(file.listFiles()).sorted((x1, x2) -> {
			if ((x1.isFile() && x2.isFile()) && (!x1.isFile() && !x2.isFile())) {
				return 0;
			} else if (x1.isFile() && !x2.isFile()) {
				return 1;
			} else {
				return -1;
			}
		}).toList();
	}
}
