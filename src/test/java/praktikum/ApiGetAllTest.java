package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import praktikum.model.EntityListResponse;
import praktikum.model.EntityRequest;
import praktikum.model.EntityResponse;
import praktikum.steps.Steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiGetAllTest {
    Steps steps = new Steps();
    ValidatableResponse response;

    @Before
    public void createEntity(){
        EntityRequest request = steps.getCreate();
        response = steps.getResponseCreate(request);
    }

    @After
    public void deleteEntity(){
        String entityId = response.extract().body().asString();
        steps.delete(entityId);
    }

    @Description("Тест проводит проверку получения списка сущности")
    @Test
    public void testGetAll(){

        EntityListResponse responseCreate = given()
                .when()
                .get(steps.GET_ALL_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .as(EntityListResponse.class);

        assertThat(responseCreate, notNullValue());
    }
}
