package yandexDiskMethods.diskMethods.createItem;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;

public class CreateFile {
    public static void createFile(String path, int SCGetFileLink200 , String destinationPath,
                                  int SCItemCreated201) {

        String href = GetLinkForFileUpload.getLinkForFileUpload(path, SCGetFileLink200 );

        //code 201 for file creation
        RestAssured.given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, TOKEN)
                .queryParam(PATH, destinationPath)
                .when()
                .put(href)
                .then()
                .statusCode(SCItemCreated201);
    }
}
