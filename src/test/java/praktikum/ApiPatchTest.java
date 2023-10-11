package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import praktikum.model.EntityRequest;
import praktikum.steps.Steps;

import static org.hamcrest.CoreMatchers.equalTo;


public class ApiPatchTest {
    Steps steps = new Steps();
    String entityId;

    @Before
    public void createEntity(){
        EntityRequest request = steps.getCreate();
        ValidatableResponse response = steps.getResponseCreate(request);
        entityId = response.extract().body().asString();
    }
    @After
    public void deleteEntity(){
        steps.delete(entityId);
    }

    @Description("Тест проводит проверку изменения сущности")
    @Test
    public void testUpdate(){

        ValidatableResponse response1 = steps.update(entityId);
        ValidatableResponse response2 = steps.getEntityById(entityId);

        response1.assertThat()
                .statusCode(204);

        response2.assertThat()
                .statusCode(200)
                .body("title", equalTo("Новый заголовок сущности"))
                .body("verified", equalTo(true));
    }
}

