package utils;

import lombok.extern.log4j.Log4j2;
import org.apache.http.protocol.HTTP;
import static io.restassured.RestAssured.given;

@Log4j2
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
        loginUrl = PropertyReader.getFromEnvOrFile("LOGIN_URL", "login.url");
        username = PropertyReader.getFromEnvOrFile("USERNAME_SF", "username");
        password = PropertyReader.getFromEnvOrFile("PASSWORD_SF", "password");
        clientId = PropertyReader.getFromEnvOrFile("API_CLIENT_ID", "api.client.id");
        clientSecret = PropertyReader.getFromEnvOrFile("API_CLIENT_SECRET", "api.client.secret");
        baseUrlClassic = PropertyReader.getFromEnvOrFile("BASE_URL_CLASSIC", "base.url.classic");
        apiPostUrlToken = PropertyReader.getFromEnvOrFile("API_POST_URL_TOKEN", "api.post.url.token");
        apiPostUrlCreateAccount = PropertyReader.getFromEnvOrFile("API_POST_IRL_CREATE_ACCOUNT", "api.post.url.create.account");
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
