/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Recursion assignment

Purpose of this file/class is to recursively look through file directories 
and take a count of how many files match the name of the file passed in
*/
//pulling in imports
import java.io.File;
import java.util.ArrayList;

public class FindFile {
    // new int to keep count of how many files have the passed in name
    private int count = 0;
    // arrayList to keep track of every location of the file
    private ArrayList<String> files = new ArrayList<String>();

    // empty constructor since I don't want empty data
    public FindFile() {

    }

    // directory search recursive method that goes through and loops through directories and checks files to
    // see if their name matches target name
    public void directorySearch(String target, String DIR_NAME) throws IllegalArgumentException {
        File path = new File(DIR_NAME); 
        // if a non existent directory is passed in, throw exception
        if(!path.exists()) {
            throw new IllegalArgumentException("Please only provide a valid directory");
        }
        // if the given path is a directory go down this route
        if (path.isDirectory()) {
            // for each loop that will go through run directory search on each file type in the directory
            for (File newFile : path.listFiles()) {
                String fileName = newFile.getPath();
                directorySearch(target, fileName);
            }
            // else if the given path is a file go down this route
        } else if (path.isFile()) {
            // checks if the path name is the same as the target
            if (path.getName().equals(target)) {
                // if it is add it to the arraylist and increase the count
            files.add(path.getAbsolutePath());
                count++;
            }
        }
    }

    //smaller getter that returns the count 
    public int getCount() {
        return this.count;
    }

    // getter for getting the arrayList of files
    public ArrayList<String> getFiles() {
        return this.files;
    }

}
        // System.out.println("abs path: " + path.getAbsolutePath());
