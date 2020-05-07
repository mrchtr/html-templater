package org.mrchtr.htmltemplater.document.model;

public class HtmlDTO {
    String content;

    public HtmlDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public HtmlDTO setContent(String content) {
        this.content = content;
        return this;
    }
}
