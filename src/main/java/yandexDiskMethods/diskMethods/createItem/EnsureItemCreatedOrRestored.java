package yandexDiskMethods.diskMethods.createItem;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;

public class EnsureItemCreatedOrRestored {
    public static void ensureItemCreatedOrRestored(String path, int SCCreationValidation200) {
        //code 200 for validation
        RestAssured.given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, TOKEN)
                .queryParam(PATH, path)
                .when()
                .get(BASE_URL + RESOURCES)
                .then()
                .statusCode(SCCreationValidation200);
    }
}
