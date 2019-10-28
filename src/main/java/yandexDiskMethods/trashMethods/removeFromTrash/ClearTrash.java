package yandexDiskMethods.trashMethods.removeFromTrash;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;

public class ClearTrash {
    public static void clearTrash(int SCClearTrash202) {
        //code 202 for cleaning up
        RestAssured.given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, TOKEN)
                .when()
                .delete(BASE_URL + TRASH)
                .then()
                .statusCode(SCClearTrash202);
    }
}
