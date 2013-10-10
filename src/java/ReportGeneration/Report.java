package ReportGeneration;
import ReportGeneration.model.Developer;
import ReportGeneration.model.Project;
import ReportGeneration.model.Role;
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
import slmo.centerallocation.CenterAllocation;
import slmo.centerallocation.ExamCenter;
import slmo.centerallocation.dao.CenterDA;

public class Report
{

    public static void main(  )
    {
        try
        {
            // 1) Load Docx file by filling Velocity template engine and cache
            // it to the registry
            InputStream in =
                Report.class.getResourceAsStream( "DocxTableWithoutFieldsMetadataWithVelocity.docx" );
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
            // 2) Create fields metadata to manage lazy loop (#forech velocity)
            // for table row.
            // FieldsMetadata metadata = report.createFieldsMetadata();
            // metadata.addFieldAsList("developers.name");
            // metadata.addFieldAsList("developers.lastName");
            // metadata.addFieldAsList("developers.mail");

            // 3) Create context Java model
            IContext context = report.createContext();
            // Register developers list
            ArrayList<ExamCenter> centers = CenterDA.getAllPopulatedCenters();
            context.put( "centers", centers );

            // 4) Generate report by merging Java model with the Docx
            OutputStream out = new FileOutputStream( new File( "DocxTableWithoutFieldsMetadataWithVelocity_Out.docx" ) );
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
    public static void main2( )
    {
        try
        {
            // 1) Load Docx file by filling Velocity template engine and cache
            // it to the registry
            InputStream in =
                Report.class.getResourceAsStream("DocxTableWithoutFieldsMetadataWithVelocity3.docx");
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
            // 2) Create fields metadata to manage lazy loop (#forech velocity)
            // for table row.
            // FieldsMetadata metadata = report.createFieldsMetadata();
            // metadata.addFieldAsList("developers.name");
            // metadata.addFieldAsList("developers.lastName");
            // metadata.addFieldAsList("developers.mail");

            // 3) Create context Java model
            IContext context = report.createContext();
            Project project = new Project( "XDocReport" );
            context.put( "project", project );
            // Register developers list
            List<Developer> developers = new ArrayList<Developer>();
            developers.add( new Developer( "ZERR", "Angelo", "angelo.zerr@gmail.com" ).addRole( new Role( "Architecte" ) ).addRole( new Role(
                                                                                                                                              "Developer" ) ) );
            developers.add( new Developer( "Leclercq", "Pascal", "pascal.leclercq@gmail.com" ).addRole( new Role(
                                                                                                                  "Architecte" ) ).addRole( new Role(
                                                                                                                                                      "Developer" ) ) );
            developers.add( new Developer( "Bousta", "Amine", "" ).addRole( new Role( "Developer" ) ) );
            context.put( "developers", developers );

            // 4) Generate report by merging Java model with the Docx
            OutputStream out = new FileOutputStream( new File( "DocxTableWithoutFieldsMetadataWithVelocity_Out.docx" ) );
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
