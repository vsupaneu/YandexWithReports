package yandexDiskMethods.diskMethods.deleteItem;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static yandexDiskMethods.requestsData.RequestsData.*;
import static org.hamcrest.Matchers.isOneOf;

public class DeleteFileOrFolder {
    public static void deleteFileOrFolder(String path, int SCForDeletion202, int SCForDeletion204) {
        //codes 202 and 204 for successful deletion
        RestAssured.given()
                .accept(ContentType.JSON)
                .header(AUTHORIZATION, TOKEN)
                .queryParam(PATH, path)
                .when()
                .delete(BASE_URL + RESOURCES)
                .then()
                .statusCode(isOneOf(SCForDeletion202, SCForDeletion204));
    }
}
