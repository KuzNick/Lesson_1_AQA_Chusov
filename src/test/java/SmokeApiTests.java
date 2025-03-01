import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SmokeApiTests {
    public static final String BASE_URL = "https://petstore.swagger.io/v2/";

    @Test
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

}
