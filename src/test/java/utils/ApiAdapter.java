package utils;

import org.apache.http.protocol.HTTP;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class ApiAdapter {
    private static String username;
    private static String password;
    private static String clientId;
    private static String clientSecret;
    private static String apiPostUrlToken;
    public static String loginUrl;
    public static String baseUrlClassic;
    public static String apiPostUrlCreateAccount;

    public ApiAdapter() {
        username = PropertyReader.getProperty("username");
        password = PropertyReader.getProperty("password");
        loginUrl = PropertyReader.getProperty("login.url");
        clientId = PropertyReader.getProperty("api.client.id");
        clientSecret = PropertyReader.getProperty("api.client.secret");
        baseUrlClassic = PropertyReader.getProperty("base.url.classic");
        apiPostUrlToken = PropertyReader.getProperty("api.post.url.token");
        apiPostUrlCreateAccount = PropertyReader.getProperty("api.post.url.create.account");
    }

    public String getAccessToken(){
        return
                given()
                        .param("client_id", clientId)
                        .param("client_secret", clientSecret)
                        .param("grant_type", "password")
                        .param("username", username)
                        .param("password", password)
                        .param(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded")
                        .when()
                        .post(loginUrl+apiPostUrlToken)
                        .then()
                        .log().ifError()
                        .statusCode(200)
                        .extract().path("access_token");
        //Response about 'invalid_grant' may be returned in case of incorrect password
    }
}
