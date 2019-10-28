package yandexDiskMethods.trashMethods.trashInfoMethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;

public class GetTrashContent {
    public static String getTrashContent() {
        String response =
                RestAssured.given()
                        .accept(ContentType.JSON)
                        .header(AUTHORIZATION, TOKEN)
                        .when()
                        .get(BASE_URL + TRASH)
                        .then().extract().response().asString();
        return response;
    }
}
