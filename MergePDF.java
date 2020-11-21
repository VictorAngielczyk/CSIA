import java.io.File;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import org.apache.pdfbox.multipdf.PDFMergerUtility;    

public class MergePDF
{
    public static boolean Merge(String destination, List<File> FileList) throws java.io.FileNotFoundException, java.io.IOException
    {
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMDDYYYY-HHmmss");
            LocalDateTime now = LocalDateTime.now();
            PDFMergerUtility merger = new PDFMergerUtility();
            merger.setDestinationFileName(destination + "mergedOn" + dtf.format(now) + ".pdf" );
            for (int i = 0; i < FileList.size(); i++){
                merger.addSource(FileList.get(i));
            }
            merger.mergeDocuments();
        } catch(Exception e) 
        {
            System.out.println("Error! " + e);
            return false;
        }
        return true;
    }
}