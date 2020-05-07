package org.mrchtr.htmltemplater.document;

import com.lowagie.text.DocumentException;
import org.mrchtr.htmltemplater.document.model.Document;
import org.mrchtr.htmltemplater.document.model.HtmlDTO;
import org.mrchtr.htmltemplater.document.service.TemplateService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/api/convert")
public class TemplaterController {

    @Inject
    TemplateService templateService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public HtmlDTO toHtml(Document document){
        return templateService.convertToHtml(document);
    }

    @POST
    @Path("/pdf")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response toPdf(Document document) throws IOException, DocumentException {
        String fileName = (document.getFileName() != null)? document.getFileName() : "document";
        Response.ResponseBuilder response = Response.ok(templateService.convertToPdf(document).toByteArray());
        response.header("Content-Disposition", "attachment;filename=" + fileName + ".pdf");
        return response.build();
    }
}
