package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.testng.annotations.Test;
import praktikum.model.EntityRequest;
import praktikum.model.EntityResponse;
import praktikum.steps.Steps;

public class ApiCreateTest {
    Steps steps = new Steps();

    @Description("Тест проводит проверку создания сущности")
    @Test
    public void testCreateEntity(){
        EntityRequest request = steps.getCreate();

        ValidatableResponse response = steps.getResponseCreate(request);
        String entityId = response.extract().body().asString();

        Assert.assertNotNull("Id сущности не должен быть пустым", entityId);
        ValidatableResponse responseGet = steps.getEntityById(entityId);

        EntityResponse entityResponse = responseGet.extract().body().as(EntityResponse.class);

        Assert.assertEquals("Проверка заголовка сущности", request.getTitle(), entityResponse.getTitle());
        Assert.assertEquals("Проверка типа сущности", request.getImportantNumbers(), entityResponse.getImportantNumbers());
    }
}

