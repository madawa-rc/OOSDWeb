
package ReportGeneration;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * A simple class which has some methods used by all examples.
 *
 * @author <a href="mailto:ben@benlitchfield.com">Ben Litchfield</a>
 * @version $Revision: 1.4 $
 */
public abstract class AbstractExample
{
    /**
     * Close the stream.
     *
     * @param stream The stream to close.
     *
     * @throws IOException If there is an error closing the stream.
     */
    public void close( InputStream stream ) throws IOException
    {
        if( stream != null )
        {
            stream.close();
        }
    }

    /**
     * Close the stream.
     *
     * @param stream The stream to close.
     *
     * @throws IOException If there is an error closing the stream.
     */
    public void close( OutputStream stream ) throws IOException
    {
        if( stream != null )
        {
            stream.close();
        }
    }

    /**
     * Close the document.
     *
     * @param doc The doc to close.
     *
     * @throws IOException If there is an error closing the document.
     */
    public void close( COSDocument doc ) throws IOException
    {
        if( doc != null )
        {
            doc.close();
        }
    }

    /**
     * Close the document.
     *
     * @param doc The doc to close.
     *
     * @throws IOException If there is an error closing the document.
     */
    public void close( PDDocument doc ) throws IOException
    {
        if( doc != null )
        {
            doc.close();
        }
    }

    /**
     * Close the writer.
     *
     * @param writer The writer to close.
     *
     * @throws IOException If there is an error closing the writer.
     */
    public static void close( COSWriter writer ) throws IOException
    {
        if( writer != null )
        {
            writer.close();
        }
    }
}
