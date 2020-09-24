package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class AccountTestAPI extends BaseTest {

    @Test
    public void createAccountUsingAPI() {
          Response response = given().auth().oauth2(apiAdapter.getAccessToken()).header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body("{\"name\": \"Test100\", \"description\": \"Test100 description\"}")
                .when()
                .post("https://ap16.salesforce.com/services/data/v49.0/sobjects/account/")
                .then()
                .statusCode(201)
                .extract().response();
        System.out.println(response.body().asString());
    }
}
