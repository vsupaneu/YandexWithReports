package yandexDiskMethods.trashMethods.removeFromTrash;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;

public class EnsureItemIsInTrash {
    public static void ensureItemIsInTrash(String path, int SCFindItemInTrash200) {
        //code 200 for validation
        RestAssured.given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, TOKEN)
                .queryParam(PATH, path)
                .when()
                .get(BASE_URL + TRASH)
                .then()
                .statusCode(SCFindItemInTrash200);
    }
}
