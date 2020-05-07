package org.mrchtr.htmltemplater.document.service;

import com.lowagie.text.DocumentException;
import org.apache.commons.lang3.StringUtils;
import org.mrchtr.htmltemplater.document.model.Document;
import org.mrchtr.htmltemplater.document.model.HtmlDTO;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.enterprise.context.ApplicationScoped;
import java.io.*;
import java.util.Map;

@ApplicationScoped
public class TemplateService {

    public HtmlDTO convertToHtml(Document doc) {
        return new HtmlDTO(this.convertToHtmlStr(doc));
    }

    private String convertToHtmlStr(Document doc) {
        String content = null;
        if (doc.getHtml() != null) {
            content = doc.getHtml();
            if (!doc.getPlaceholder()
                    .isEmpty()) {
                for (Map.Entry<String, String> placeholder : doc.getPlaceholder()
                                                                .entrySet()) {
                    content = StringUtils.replace(content, doc.getStartPlaceholder() + placeholder.getKey() + doc.getEndPlaceholder(),
                                                  placeholder.getValue());
                }
            }
        }
        return content;
    }

    public ByteArrayOutputStream convertToPdf(Document doc) throws IOException, DocumentException {
        ITextRenderer renderer  = new ITextRenderer();
        String        finalHtml = this.convertToHtmlStr(doc);
        renderer.setDocumentFromString(finalHtml);
        renderer.layout();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        renderer.createPDF(outputStream);
        return outputStream;
    }
}
