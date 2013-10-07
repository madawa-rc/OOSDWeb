package ReportGeneration;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class PdfFill extends AbstractExample {

    public static void main(String[] args) {
        PdfFill a = new PdfFill("AdmissionCard.pdf");
        a.setField("Medium", "isuru");
        a.save("AdmissionCard2.pdf");
    }
    PDDocument pdf = null;

    public PdfFill(String name) {
        try {
            pdf = PDDocument.load(name);
        } catch (IOException ex) {
            System.out.println("asdasd");
        }
    }

    public void setField(String fieldName, String value) {
        try {
            PDDocumentCatalog docCatalog = pdf.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();
            List<PDField> fields = acroForm.getFields();
      /*      for (PDField field : fields) {
                    field.setValue(value);
                    field.setReadonly(true);
            }*/
            PDField field = acroForm.getField(fieldName);
            if (field != null) {
                field.setValue(value);
                field.setReadonly(true);
            }
        } catch (Exception e) {
        }
    }

    public void save(String file) {
        if (pdf != null) {
            try {
                pdf.save(file);
                pdf.close();
            } catch (Exception e) {
            }
        }
    }
}
