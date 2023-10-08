package praktikum;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import praktikum.model.request.RequestCreate;
import praktikum.steps.Steps;
import static org.hamcrest.CoreMatchers.equalTo;


public class ApiPatchTest {
    Steps steps = new Steps();

    @Before
    public void setUp() {
        RestAssured.baseURI = steps.BASE_URI;
    }

    @Description("Тест проводит проверку изменения сущности")
    @Test
    public void testUpdate(){
        RequestCreate request = steps.getCreate();
        Response response = steps.getResponseCreate(request);
        String entityId = response.getBody().asString();

        steps.update(entityId);
        steps.assertResponsePatch(response);

        Response responseGet = steps.getResponseById(entityId);
        responseGet.then()
                .assertThat()
                .statusCode(200)
                .body("title", equalTo("Новый заголовок сущности"))
                .body("verified", equalTo(true));
    }
}

