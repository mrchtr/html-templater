import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Scratch {
    public static void main(String[] args) throws IOException, DocumentException {
        String test = "test";
        ITextRenderer renderer = new ITextRenderer();

        // if you have html source in hand, use it to generate document object
        renderer.setDocumentFromString(test);
        renderer.layout();

        String           fileNameWithPath = "./PDF-FromHtmlString.pdf";
        FileOutputStream fos              = new FileOutputStream(fileNameWithPath );
        renderer.createPDF( fos );
        fos.close();
        System.out.println( "File 2: '" + fileNameWithPath + "' created." );
    }
}