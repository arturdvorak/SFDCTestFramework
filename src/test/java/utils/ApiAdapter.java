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
        username = System.getenv().getOrDefault("USERNAME", PropertyReader.getProperty("username"));
        password = System.getenv().getOrDefault("PASSWORD", PropertyReader.getProperty("password"));
        loginUrl = System.getenv().getOrDefault("LOGIN_URL", PropertyReader.getProperty("login.url"));
        clientId = System.getenv().getOrDefault("API_CLIENT_ID", PropertyReader.getProperty("api.client.id"));
        clientSecret = System.getenv().getOrDefault("API_CLIENT_SECRET", PropertyReader.getProperty("api.client.secret"));
        baseUrlClassic = System.getenv().getOrDefault("BASE_URL_CLASSIC", PropertyReader.getProperty("base.url.classic"));
        apiPostUrlToken = System.getenv().getOrDefault("API_POST_URL_TOKEN", PropertyReader.getProperty("api.post.url.token"));
        apiPostUrlCreateAccount = System.getenv().getOrDefault("API_POST_IRL_CREATE_ACCOUNT", PropertyReader.getProperty("api.post.url.create.account"));
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
