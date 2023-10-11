package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.testng.annotations.Test;
import praktikum.model.EntityRequest;
import praktikum.steps.Steps;

public class ApiDeleteTest {
    Steps steps = new Steps();
    ValidatableResponse response;
    @Before
    public void createEntity(){
        EntityRequest request = steps.getCreate();
        response = steps.getResponseCreate(request);
    }

    @Description("Тест проводит проверку удаления сущности")
    @Test
    public void testDelete(){

        String entityId = response.extract().body().asString();

        ValidatableResponse deleteResponse = steps.delete(entityId);
        deleteResponse.statusCode(204);
    }
}

