package slomf.api.reportGeneration;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class PdfFill extends AbstractExample {

    PDDocument pdf = null;

    public PdfFill(String name) {
        try {
            pdf = PDDocument.load(name);
        } catch (IOException ex) {
            slomf.admin.Log.addLog("asdasd");
        }
    }
    public PdfFill(InputStream inStream) {
        try {
            pdf = PDDocument.load(inStream);
        } catch (IOException ex) {
            slomf.admin.Log.addLog("asdasd");
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
            @SuppressWarnings("unchecked")
            PDField field = acroForm.getField(fieldName);
            if (field != null) {
                field.setValue(value);
                field.setReadonly(true);
            }
        } catch (Exception e) {
        }
    }

    public PDField getField(String fieldName){
        try {
            PDDocumentCatalog docCatalog = pdf.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();
            List<PDField> fields = acroForm.getFields();
      /*      for (PDField field : fields) {
                    field.setValue(value);
                    field.setReadonly(true);
            }*/
            @SuppressWarnings("unchecked")
            PDField field = acroForm.getField(fieldName);
            if (field != null) {
                field.setReadonly(true);
                return field;
            }
        } catch (Exception e) {
        }
        return null;
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
    public void saveToOutputStream(OutputStream outStream) {
        if (pdf != null) {
            try {
                pdf.save(outStream);
            } catch (Exception e) {
            }
        }
    }
}
