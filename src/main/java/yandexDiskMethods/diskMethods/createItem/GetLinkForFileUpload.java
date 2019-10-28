package yandexDiskMethods.diskMethods.createItem;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;

public class GetLinkForFileUpload {
    public static String getLinkForFileUpload(String filePath, int SCGetFileLink200) {
        //code 200 for link
        return
                RestAssured.given()
                        .accept(ContentType.JSON)
                        .header(AUTHORIZATION, TOKEN)
                        .queryParam(PATH, filePath)
                        .when()
                        .get(BASE_URL + UPLOAD_FILE)
                        .then()
                        .statusCode(SCGetFileLink200)
                        .extract().path(HREF);
    }
}
