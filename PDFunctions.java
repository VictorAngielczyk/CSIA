import java.io.File;
import java.io.IOException;
import java.util.*;

public class PDFunctions {

    public static void main(String[] args) throws IOException {
        List<File> FileList = new ArrayList<File>();
        File file1 = new File("‪C:\\Users\\vangi\\Downloads\\partb.pdf");
        File file2 = new File("C:\\Users\\vangi\\Downloads\\lab3.pdf");
        FileList.add(file1);
        FileList.add(file2);
        String destination = "C:\\Users\\vangi\\Downloads\\";
        boolean check = MergePDF.Merge(destination, FileList);
        if(!check)System.out.println("error");
    }
    
}
