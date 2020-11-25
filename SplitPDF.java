import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class SplitPDF {
    public static boolean split(String destination, File toSplit) throws java.io.IOException
    {
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMDDYYYY-HHmmss");

            LocalDateTime now = LocalDateTime.now();

            String fileName = toSplit.getName().replaceFirst("[.][^.]+$", "");

            PDDocument doc = PDDocument.load(toSplit);

            Splitter splitter = new Splitter();

            List<PDDocument> split = splitter.split(doc);

            Iterator<PDDocument> iterator = split.listIterator();

            for (int i = 1; iterator.hasNext(); i++)
            {
                PDDocument toSave = iterator.next();
                toSave.save(destination + "\\" + fileName + dtf.format(now) + "\\" + i);
            }

            doc.close();

        } catch(Exception e) 
        {
            System.out.println("Error! " + e);
            return false;
        }
        return true;
    }
}
