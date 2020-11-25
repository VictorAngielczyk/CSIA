import java.io.File;
import java.io.IOException;
import java.util.*;

public class PDFunctions {

    public static void main(String[] args) throws IOException {
        List<File> FileList = new ArrayList<File>();
        File file1 = new File("tests\\test1.pdf");
        File file2 = new File("tests\\test2.pdf");
        FileList.add(file1);
        FileList.add(file2);
        String destination = "tests\\output\\";
        SplitPDF.split(destination, MergePDF.Merge(destination, FileList));
    }
    
}
