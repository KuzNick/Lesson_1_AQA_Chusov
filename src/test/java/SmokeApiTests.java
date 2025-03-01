import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SmokeApiTests {
    public static final String BASE_URL = "https://petstore.swagger.io/v2/";

    @Test
    @Order(1)
    void createUserTest() {
        //given -config
        //when - http
        //then - assert

        String bodyJson = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }
                """;

        given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(bodyJson)
                .baseUri(BASE_URL)
                .basePath("user")
                .when().post()
                .then().log().body().statusCode(200);
    }

    @Test
    @Order(2)
    void checkUserTest() {
        //given -config
        //when - http
        //then - assert


        given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .baseUri(BASE_URL)
                .basePath("user/string")
                .when().get()
                .then().log().body().statusCode(200);
    }

    @Test
    @Order(3)
    void delUserTest() {
        //given -config
        //when - http
        //then - assert


        given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .baseUri(BASE_URL)
                .basePath("user/string")
                .when().delete()
                .then().log().body().statusCode(200);
    }
}
