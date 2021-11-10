import java.io.File;
import java.util.ArrayList;
public class FindFile {
    private int count = 0;
    private ArrayList<String> files = new ArrayList<String>();

    public FindFile() {

    }

    public static void main(String[] args) {
        // System.out.println(directorySearch("file5.txt", new File("C:\\Temp")));
    }

    public void directorySearch(String target, String DIR_NAME) {
        File path = new File(DIR_NAME); 
        System.out.println("abs path: " + path.getAbsolutePath());
        if (path.isDirectory()) {
            for (File newFile : path.listFiles()) {
                // System.out.println("abs path2: " + newFile.getAbsolutePath());
                String fileName = newFile.getPath();
                directorySearch(target, fileName);
            }
        } else if (path.isFile()) {
            if (path.getName().equals(target)) {
            System.out.println("we get something");
            files.add(path.getAbsolutePath());
                count++;
            }
        }
    }

    public int getCount() {
        return this.count;
    }

    public ArrayList<String> getFiles() {
        return this.files;
    }

}
