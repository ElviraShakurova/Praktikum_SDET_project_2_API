package praktikum;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.Test;
import praktikum.model.request.RequestCreate;
import praktikum.steps.Steps;

public class ApiCreateTest {

    Steps steps = new Steps();

    @Description("Тест проводит проверку создания сущности")
    @Test
    public void testCreateEntity(){
        RequestCreate request = steps.getCreate();

        Response response = steps.getResponseCreate(request);
        String entityId = response.getBody().asString();

        System.out.println(entityId);
    }
}

