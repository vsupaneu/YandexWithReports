package yandexDiskMethods.trashMethods.removeFromTrash;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;

public class RestoreItemFromTrash {
    public static void restoreItemFromTrash(String path, int SCRestoreFromTrash201) {
        //code 201 for restore from trash
        RestAssured.given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, TOKEN)
                .queryParam(PATH, path)
                .when()
                .put(BASE_URL + RESTORE_FROM_TRASH)
                .then()
                .statusCode(SCRestoreFromTrash201);
    }
}
