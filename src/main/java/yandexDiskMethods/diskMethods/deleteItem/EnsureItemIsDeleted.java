package yandexDiskMethods.diskMethods.deleteItem;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;

public class EnsureItemIsDeleted {
    public static void ensureItemIsDeleted(String path, int SCForRemoval404) {
        //code 404 for validation
        RestAssured.given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, TOKEN)
                .queryParam(PATH, path)
                .when()
                .get(BASE_URL + RESOURCES)
                .then()
                .statusCode(SCForRemoval404);
    }
}
