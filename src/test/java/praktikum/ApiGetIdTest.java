package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import praktikum.model.request.RequestCreate;
import praktikum.steps.Steps;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;


public class ApiGetIdTest {
    Steps steps = new Steps();

    @Description("Тест проводит проверку получения сущности по его id")
    @Test
    public void testGetEntity() {
        RequestCreate request = steps.getCreate();
        Response response = steps.getResponseCreate(request);
        String entityId = response.getBody().asString();

        Response responseGet = steps.getResponseById(entityId);

        assertEquals(200, response.getStatusCode());
        MatcherAssert.assertThat(responseGet, notNullValue());
    }
}

