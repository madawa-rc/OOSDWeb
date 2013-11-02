package slomf.api.reportGeneration;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.pdfbox.util.PDFMergerUtility;

public class MergePDF {
    PDFMergerUtility mergePdf;

    public MergePDF() {
        mergePdf = new PDFMergerUtility();
    }
    
    public void merge(ArrayList<String> files, String outFileName){
        mergePdf = new PDFMergerUtility();
        for(String file : files){
            mergePdf.addSource(file);
        }
        mergePdf.setDestinationFileName(outFileName);
        try {
            mergePdf.mergeDocuments();
        } catch (Exception ex) {

        }
    }
    public void addSource(InputStream inStream){
        mergePdf.addSource(inStream);
    }
    public void merge(OutputStream outStream){
        mergePdf.setDestinationStream(outStream);
        try {
            mergePdf.mergeDocuments();
        } catch (Exception ex) {

        }
    }
}
