package yandexDiskMethods.diskMethods.createItem;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;

public class CreateFolder {
    public static void createFolder(String folderPath, int SCItemCreated201) {
        //code 201 for creation
        RestAssured.given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, TOKEN)
                .queryParam(PATH, folderPath)
                .when()
                .put(BASE_URL + RESOURCES)
                .then()
                .statusCode(SCItemCreated201);
    }
}
