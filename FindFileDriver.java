
/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Recursion assignment

Purpose of this file/class is to recursively look through file directories 
and take a count of how many files match the name of the file passed in
*/
/*
 * Driver for finding files in given directory tree
 */
public class FindFileDriver {
	// Replace the DIR_Name with the name of the path you want to start at
	public final static String DIR_NAME =  "C:\\Temp\\DirSearchExample";

	public static void main(String[] args) {

		// expected result: Finds 2
		doSearch("file5.txt", DIR_NAME);
		// expected result: File does not exist
		doSearch("nosuchfile", DIR_NAME);
		// expected result: Finds 3
		doSearch("file3.txt", DIR_NAME);
		// expected result: Finds 1
		doSearch("file1.txt", DIR_NAME);
		// expected result: Finds 1
		doSearch("file1.txt","C:\\Temp\\NotADirectory");
	}

	/*
	 * Search for target file starting with directory path
	 */
	// sends the directory path and the file to search for over to FineFile
	private static void doSearch(String target, String dirName) {
		FindFile finder = new FindFile();

		System.out.println(" \nTarget: " + target);
		try {
			finder.directorySearch(target, dirName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(finder.getFiles());
			System.exit(0);
		}

		if (finder.getCount() == 0)
			System.out.println(target + " not found");
		else {
			System.out.println("Count = " + finder.getCount());
			System.out.println("files found at " + finder.getFiles());		
		}
	}
}
