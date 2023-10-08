package praktikum.steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import praktikum.model.request.Addition;
import praktikum.model.request.RequestCreate;
import praktikum.model.response.ResponseCreate;

import java.io.File;
import static io.restassured.RestAssured.given;

public class Steps {
    public static final String BASE_URI = "http://localhost:8080";

    public static final String CREATE_ENDPOINT = "/api/create";

    public static final String PATCH_ENDPOINT = "/api/patch/";

    public static final String GET_ENDPOINT = "/api/get/";

    public static final String DELETE_ENDPOINT = "/api/delete";

    public static final String GET_ALL_ENDPOINT = "/api/getAll";

    public static final String JSON_FILE_PATH = "src/test/resources/api_patch_test_data.json";

    public static final String CONTENT_TYPE = "application/json; charset=UTF-8";

    @Step("Ввод данных при создании сущности")
    public static RequestCreate getCreate() {
        RestAssured.baseURI = BASE_URI;
        RequestCreate request = new RequestCreate();
        Addition addition = new Addition("Дополнительные сведения", 123);
        request.setAddition(addition);
        request.setImportantNumbers(new int[]{42, 87, 23});
        request.setTitle("Заголовок сущности");
        request.setVerified(true);
        return request;
    }

    @Step("Изменение сущности")
    public static void update(String entityId) {
        File json = new File(JSON_FILE_PATH);
        given()
                .contentType(CONTENT_TYPE)
                .and()
                .body(json)
                .when()
                .patch(PATCH_ENDPOINT + entityId);
    }

    @Step("Получение статуса ответа при изменении сущности")
    public static void assertResponsePatch(Response response) {
        response.then()
                .assertThat()
                .statusCode(200);
    }

    @Step("Получение сущности по id")
    public static Response getResponseById(String entityId) {
        Response responseGet = RestAssured.given()
                .queryParam("id", entityId)
                .get(GET_ENDPOINT + entityId);
        return responseGet;
    }

    @Step("Создание сущности")
    public static Response getResponseCreate(RequestCreate request) {
        return given()
                .contentType(CONTENT_TYPE)
                .body(request)
                .post(CREATE_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Step("Удаление сущности")
    public Response delete(String entityId) {
        Response deleteResponse = RestAssured.given()
                .when()
                .delete(DELETE_ENDPOINT + "/" + entityId);
        deleteResponse.then()
                .statusCode(204);
        return deleteResponse;
    }

    @Step("Получение списка сущности")
    public ResponseCreate getEntityAll(String entityId) {
        ResponseCreate responseCreate = given()
                .param("id", entityId)
                .get(GET_ALL_ENDPOINT)
                .as(ResponseCreate.class);
        return responseCreate;
    }
}
