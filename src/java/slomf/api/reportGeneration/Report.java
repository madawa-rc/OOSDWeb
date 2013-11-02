package slomf.api.reportGeneration;
import java.io.InputStream;
import java.io.OutputStream;

import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

public class Report
{

    public static void generate(InputStream in, String objectName, Object object, OutputStream out)
    {
        try
        {
            // 1) Load Docx file by filling Velocity template engine and cache
            // it to the registry
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

            // 2) Create context Java model
            IContext context = report.createContext();
            // Register centers list
            context.put(objectName,object);
            
            // 3) Generate report by merging Java model with the Docx
     //      OutputStream out = new FileOutputStream( new File( filepath) );
            report.process( context, out );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}
