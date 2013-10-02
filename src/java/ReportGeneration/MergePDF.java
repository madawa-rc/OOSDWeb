package ReportGeneration;

import org.apache.pdfbox.util.PDFMergerUtility;

public class MergePDF {

    public void merge(String[] files, String outFileName){
        PDFMergerUtility mergePdf = new PDFMergerUtility();
        for(String file : files){
            mergePdf.addSource(file);
        }
        mergePdf.setDestinationFileName(outFileName);
        try {
            mergePdf.mergeDocuments();
        } catch (Exception ex) {

        }

    }
}
