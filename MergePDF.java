import java.io.File;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import org.apache.pdfbox.multipdf.PDFMergerUtility;   
import org.apache.pdfbox.io.MemoryUsageSetting; 

public class MergePDF
{
    public static File Merge(String destination, List<File> FileList) throws java.io.FileNotFoundException, java.io.IOException
    {
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-YYYY_HHmmss");

            LocalDateTime now = LocalDateTime.now();

            PDFMergerUtility merger = new PDFMergerUtility();

            File output = new File(destination + (FileList.get(0).getName()).replace(".pdf","") + "-" + dtf.format(now) + ".pdf");

            merger.setDestinationFileName(output.getPath());

            for (int i = 0; i < FileList.size(); i++){
                merger.addSource(FileList.get(i));
            }

            merger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

            return output;

        } catch(Exception e) 
        {
            System.out.println("Error! " + e);
        }
        return null;
    }
}
