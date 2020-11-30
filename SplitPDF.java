import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class SplitPDF {
    public static void split(String destination, File toSplit) throws java.io.IOException
    {
        try
        {
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-YYYY_HHmmss");

            //LocalDateTime now = LocalDateTime.now();

            String fileName = toSplit.getName().replaceFirst("[.][^.]+$", "");

            PDDocument doc = PDDocument.load(toSplit);

            Splitter splitter = new Splitter();

            List<PDDocument> split = splitter.split(doc);

            Iterator<PDDocument> iterator = split.listIterator();

            File outputDirectory = new File(destination + "\\" + fileName);

            if(!Files.exists(outputDirectory.path) outputDirectory.mkdir();

            for (int i = 1; iterator.hasNext(); i++)
            {
                PDDocument toSave = iterator.next();

                File saveFile = new File(destination + "\\" + fileName + "\\" + i +".pdf");

                saveFile.createNewFile();

                toSave.save(destination + "\\" + fileName + "\\" + i +".pdf");
            }

            doc.close();

        } catch(Exception e) 
        {
            System.out.println("Error! " + e);
        }
    }
}
