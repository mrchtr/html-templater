package org.mrchtr.htmltemplater.document.model;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class Document {


    String fileName;

    /**
     * Placeholders which will be replaced by their values in the html.
     */
    Map<String, String> placeholder;

    /**
     * HTML content given as String.
     */
    @NotNull String html;

    String startPlaceholder = "{{";

    String endPlaceholder = "}}";

    public Document() {
    }

    public Document(Map<String, String> placeholder, @NotNull String html, String startPlaceholder, String endPlaceholder) {
        this.placeholder = placeholder;
        this.html = html;
        this.startPlaceholder = startPlaceholder;
        this.endPlaceholder = endPlaceholder;
    }

    public Map<String, String> getPlaceholder() {
        return placeholder;
    }

    public Document setPlaceholder(Map<String, String> placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    public String getHtml() {
        return html;
    }

    public Document setHtml(String html) {
        this.html = html;
        return this;
    }

    public String getStartPlaceholder() {
        return startPlaceholder;
    }

    public String getEndPlaceholder() {
        return endPlaceholder;
    }

    public Document setStartPlaceholder(String startPlaceholder) {
        this.startPlaceholder = startPlaceholder;
        return this;
    }

    public Document setEndPlaceholder(String endPlaceholder) {
        this.endPlaceholder = endPlaceholder;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public Document setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
