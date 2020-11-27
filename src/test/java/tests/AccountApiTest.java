package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import models.AccountFactory;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;
import utils.ApiAdapter;

import static io.restassured.RestAssured.given;

@Log4j2
public class AccountApiTest {
    ApiAdapter apiAdapter = new ApiAdapter();
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    @Test(description = "Create account using API", enabled = false)
    public void createAccountUsingAPI() {
        log.atInfo().log("Access token: {}", apiAdapter.getAccessToken());
          Response response = given().auth().oauth2(apiAdapter.getAccessToken()).header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body(gson.toJson(new AccountFactory().getAccount("0012w00000M1yrYAAR")))
                .when()
                .post(ApiAdapter.baseUrlClassic + ApiAdapter.apiPostUrlCreateAccount)
                .then()
                .statusCode(201)
                .extract().response();
        log.atInfo().log("Response body is the following {}", response.body().asString());
    }
}
