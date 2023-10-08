package praktikum;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import praktikum.model.request.RequestCreate;
import praktikum.model.response.ResponseCreate;
import praktikum.steps.Steps;
import static org.hamcrest.CoreMatchers.notNullValue;

public class ApiGetAllTest {
    Steps steps = new Steps();

    @Before
    public void setUp() {
        RestAssured.baseURI = steps.BASE_URI;
    }

    @Description("Тест проводит проверку получения списка сущности")
    @Test
    public void testGetAll(){
        RequestCreate request = steps.getCreate();
        Response response = steps.getResponseCreate(request);
        String entityId = response.getBody().asString();

        ResponseCreate responseCreate = steps.getEntityAll(entityId);
        MatcherAssert.assertThat(responseCreate, notNullValue());
    }
}
