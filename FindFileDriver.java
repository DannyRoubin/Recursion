
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
			// tries to run directory search
			finder.directorySearch(target, dirName);
		} catch (Exception e) {
			// if we catch an error print the message and see how many files we got added into the array
			System.out.println(e.getMessage());
			System.out.println(finder.getFiles());
			// READ ME: Okay so here's the deal, if you want to test a non existent directory, make sure you are making that your
			// last test since the line under this one will do a systemExit on error.
			System.exit(0);
		}

		// if the count is equal to 0, then we found nothing 
		if (finder.getCount() == 0)
		// puts out the message we found nothing
			System.out.println(target + " not found");
		else {
			// otherwise we ended up finding files and we can return the count and the array holding locations of the files
			System.out.println("Count = " + finder.getCount());
			System.out.println("files found at " + finder.getFiles());		
		}
	}
}
