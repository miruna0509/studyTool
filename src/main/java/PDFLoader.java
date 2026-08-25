import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFLoader {
    public static String readFromFile(String fileName1) throws IOException {
        try (PDDocument document = Loader.loadPDF(new File(fileName1))) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }

    }
}
