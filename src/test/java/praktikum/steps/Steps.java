package praktikum.steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import praktikum.config.Config;
import praktikum.model.Addition;
import praktikum.model.EntityRequest;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;


    public class Steps {
    public static final String CREATE_ENDPOINT = "/api/create";

    public static final String PATCH_ENDPOINT = "/api/patch/";

    public static final String GET_ENDPOINT = "/api/get";

    public static final String DELETE_ENDPOINT = "/api/delete";

    public static final String GET_ALL_ENDPOINT = "/api/getAll";

    public static final String JSON_FILE_PATH = "src/test/resources/api_patch_test_data.json";

    public static final String CONTENT_TYPE = "application/json; charset=UTF-8";

    @Step("Ввод данных при создании сущности")
    public static EntityRequest getCreate() {
        String baseUri = Config.getBaseUri();
        RestAssured.baseURI = baseUri;
        EntityRequest request = new EntityRequest();
        Addition addition = new Addition("Дополнительные сведения", 123);
        request.setAddition(addition);
        List<Integer> importantNumbers = Arrays.asList(42, 87, 23);
        request.setTitle("Заголовок сущности");
        request.setVerified(true);
        request.setImportantNumbers(importantNumbers);
        return request;
    }

    @Step("Изменение сущности")
    public static ValidatableResponse update(String entityId) {
        File json = new File(JSON_FILE_PATH);
         return given()
                .contentType(CONTENT_TYPE)
                .body(json)
                .when()
                .patch(PATCH_ENDPOINT + entityId)
                .then()
                .statusCode(204);
    }

    @Step("Получение сущности по id")
    public ValidatableResponse getEntityById(String entityId) {
       return RestAssured.given()
                .queryParam("id", entityId)
                .get(GET_ENDPOINT + "/" + entityId)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Step("Создание сущности")
    public static ValidatableResponse getResponseCreate(EntityRequest request) {
        return given()
                .contentType(CONTENT_TYPE)
                .body(request)
                .post(CREATE_ENDPOINT)
                .then()
                .statusCode(200);
    }

    @Step("Удаление сущности")
    public ValidatableResponse delete(String entityId) {
        return RestAssured.given()
                .when()
                .delete(DELETE_ENDPOINT + "/" + entityId)
                .then()
                .statusCode(204);
    }
}
