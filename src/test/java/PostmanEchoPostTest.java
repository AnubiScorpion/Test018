import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoPostTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    void shouldSendDataAndVerifyItInResponse() {
        String payload = "some data";

        RestAssured
                // Given - When - Then
                // Предусловия
                .given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo(payload));
    }
}
