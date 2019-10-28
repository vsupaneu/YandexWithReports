package yandexDiskMethods.trashMethods.removeFromTrash;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;

public class EnsureItemRemovedFromTrash {
    public void ensureItemRemovedFromTrash(String path, int SCForRemoval404) {
        //code 404 for removal from trash
        RestAssured.given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, TOKEN)
                .queryParam(PATH, path)
                .when()
                .get(BASE_URL + TRASH)
                .then()
                .statusCode(SCForRemoval404);
    }
}
