package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.model.EntityRequest;
import praktikum.model.EntityResponse;
import praktikum.steps.Steps;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class ApiGetIdTest {
    Steps steps = new Steps();
    String entityId;
    ValidatableResponse response;

    @Before
    public void сreateEntity(){
        EntityRequest request = steps.getCreate();
        response = steps.getResponseCreate(request);
        entityId = response.extract().body().asString();
    }
    @After
    public void deleteEntity(){
        steps.delete(entityId);
    }

    @Description("Тест проводит проверку получения сущности по его id")
    @Test
    public void testGetEntity() {
        ValidatableResponse response2 = steps.getEntityById(entityId);
        assertEquals(200, response2.extract().statusCode());
        assertThat(response2, notNullValue());
    }
}

