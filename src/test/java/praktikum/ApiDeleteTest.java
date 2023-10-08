package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.Test;
import praktikum.model.request.RequestCreate;
import praktikum.steps.Steps;
import static org.junit.Assert.assertEquals;

public class ApiDeleteTest {
    Steps steps = new Steps();

    @Description("Тест проводит проверку удаления сущности")
    @Test
    public void testDelete(){
        RequestCreate request = steps.getCreate();
        Response response = steps.getResponseCreate(request);
        String entityId = response.getBody().asString();

        Response deleteResponse = steps.delete(entityId);
        assertEquals(204, deleteResponse.getStatusCode());
    }
}

