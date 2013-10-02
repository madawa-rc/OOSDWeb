package ReportGeneration;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;



public class SetField extends AbstractExample
{
    PDDocument pdf = null;

    public SetField(String name) {
        try {
            pdf = PDDocument.load(name);
        } catch (IOException ex) {
        }
    }


    public void setField(String fieldName, String value )
    {
        try
        {
                PDDocumentCatalog docCatalog = pdf.getDocumentCatalog();
                PDAcroForm acroForm = docCatalog.getAcroForm();
                PDField field = acroForm.getField( fieldName );
                if( field != null )
                {
                    field.setValue( value );
                }
        }
        catch(Exception e){
        }
    }
    public void save(String file){
        if( pdf != null )
            {
                try{
                    pdf.save(file);
                    pdf.close();
                }
                catch(Exception e){
                }
            }
    }
}
