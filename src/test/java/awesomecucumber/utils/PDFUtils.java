package awesomecucumber.utils;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFUtils {
    public static String getPDFContent(String url) throws IOException {
        File file = new File(url);
        PDDocument doc = Loader.loadPDF(file);
        PDFTextStripper strip = new PDFTextStripper();
        String stripText = strip.getText(doc);
        doc.close();
        return stripText;
    }
}
