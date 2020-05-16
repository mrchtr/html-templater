package org.mrchtr.htmltemplater.document;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class TemplaterControllerTest {

    @Test
    public void testPdfConvertBasicHtmlIsPossible() {
        String payload =
                "{\n" + "  \"html\": \"<p>{{test}}</p>\",\n" + "  \"placeholder\": {\n" + "    \"test\": \"hello world\"\n" + "  }\n" + "}";

        given().contentType(ContentType.JSON)
               .body(payload)
               .when()
               .post("/api/convert/pdf")
               .then()
               .statusCode(200);
    }

    @Test
    public void testPdfConvertComplexHtmlIsPossible() {
        String payload =
                "{\n" + "  \"html\": \"<p><em>Hello World, its me </em> Joe Exotic</p>\\n<p>&nbsp;</p>\\n<p>Second Paragraph</p>\",\n" +
                "  \"placeholder\": {\n" + "    \"test\": \"hello world\"\n" + "  }\n" + "}\n" + "\n";

        given().contentType(ContentType.JSON)
               .body(payload)
               .when()
               .post("/api/convert/pdf")
               .then()
               .statusCode(200);
    }

}