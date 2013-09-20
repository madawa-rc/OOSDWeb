package ReportGeneration;

import ReportGeneration.model.Developer;
import ReportGeneration.model.Project;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

public class ReportTable
{

    public static void main( String[] args )
    {
        try
        {
            // 1) Load Docx file by filling Velocity template engine and cache
            // it to the registry
            InputStream in = ReportTable.class.getResourceAsStream( "DocxProjectWithVelocityList.docx" );
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

            // 2) Create fields metadata to manage lazy loop (#forech velocity)
            // for table row.
            FieldsMetadata metadata = report.createFieldsMetadata();
            metadata.addFieldAsList( "developers.Name" );
            metadata.addFieldAsList( "developers.LastName" );
            metadata.addFieldAsList( "developers.Mail" );

            // 3) Create context Java model
            IContext context = report.createContext();
            Project project = new Project( "XDocReport" );
            context.put( "project", project );

            // List<Map<String,String>> developers = new
            // ArrayList<Map<String,String>>();
            // Map<String,String> developer1 = new HashMap<String, String>();
            // developer1.put("Name", "ZERR");
            // developer1.put("LastName", "Angelo");
            // developer1.put("Mail", "angelo.zerr@gmail.com");
            // developers.add(developer1);
            // Register developers list

            List<Developer> developers = new ArrayList<Developer>();
            for(int i=0;i<100;i++)
                developers.add( new Developer( "ZERR"+i, "Angelo", "angelo.zerr@gmail.com" ) );
            developers.add( new Developer( "Leclercq", "Pascal", "pascal.leclercq@gmail.com" ) );
            context.put( "developers", developers );

            // 4) Generate report by merging Java model with the Docx
            OutputStream out = new FileOutputStream( new File( "DocxProjectWithVelocityList_Out.docx" ) );
            report.process( context, out );

        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        catch ( XDocReportException e )
        {
            e.printStackTrace();
        }
    }
}