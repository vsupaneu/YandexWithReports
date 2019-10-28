package yandexDiskMethods.diskMethods.itemInfo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;
import static org.hamcrest.Matchers.equalTo;

public class GetItemInfo {
    public static void checkFolderInfo(int amountOfEmbeddedItems, String folderPath, String folderName) {
        RestAssured.given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, TOKEN)
                .queryParam(PATH, folderPath)
                .expect()
                .body(EMBEDDED_TOTAL, equalTo(amountOfEmbeddedItems))
                .body(EMBEDDED_PATH, equalTo(folderPath))
                .body(NAME, equalTo(folderName))
                .statusCode(200)
                .when()
                .get(BASE_URL + RESOURCES);
    }
}
