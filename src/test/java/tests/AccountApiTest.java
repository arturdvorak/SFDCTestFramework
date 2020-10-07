package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.AccountFactory;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;
import utils.ApiAdapter;

import static io.restassured.RestAssured.given;

public class AccountApiTest {
    ApiAdapter apiAdapter = new ApiAdapter();
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    @Test
    public void createAccountUsingAPI() {
          Response response = given().auth().oauth2(apiAdapter.getAccessToken()).header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body(gson.toJson(new AccountFactory().getAccount("0012w00000M1yrYAAR"))).log().all()
                .when()
                .post(ApiAdapter.baseUrlClassic + ApiAdapter.apiPostUtlCreatAccount)
                .then().log().all()
                .statusCode(201)
                .extract().response();
        System.out.println(response.body().asString());
    }
}
