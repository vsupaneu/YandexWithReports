package yandexDiskMethods.trashMethods.trashInfoMethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;

public class GetTrashSize {
    public static int getTrashSize() {
        int trashSize =
                RestAssured.given()
                        .accept(ContentType.JSON)
                        .header(AUTHORIZATION, TOKEN)
                        .when()
                        .get(BASE_URL)
                        .then()
                        .extract().path("trash_size");
        return trashSize;
    }
}
