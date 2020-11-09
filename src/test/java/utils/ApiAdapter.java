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
        username = System.getenv().getOrDefault("USERNAME_SF", PropertyReader.getProperty("username"));
        log.atInfo().log("'Username' is set to {}", username);
        password = System.getenv().getOrDefault("PASSWORD_SF", PropertyReader.getProperty("password"));
        log.atInfo().log("'Password' is set to {}", password);
        loginUrl = System.getenv().getOrDefault("LOGIN_URL", PropertyReader.getProperty("login.url"));
        log.atInfo().log("'LoginUrl' is set to {}", loginUrl);
        clientId = System.getenv().getOrDefault("API_CLIENT_ID", PropertyReader.getProperty("api.client.id"));
        log.atInfo().log("'Client Id' is set to {}", clientId);
        clientSecret = System.getenv().getOrDefault("API_CLIENT_SECRET", PropertyReader.getProperty("api.client.secret"));
        log.atInfo().log("'Client Secret' is set to {}", clientSecret);
        baseUrlClassic = System.getenv().getOrDefault("BASE_URL_CLASSIC", PropertyReader.getProperty("base.url.classic"));
        log.atInfo().log("'BaseUrlClassic' is set to {}", baseUrlClassic);
        apiPostUrlToken = System.getenv().getOrDefault("API_POST_URL_TOKEN", PropertyReader.getProperty("api.post.url.token"));
        log.atInfo().log("'ApiPostUrlToken' is set to {}", apiPostUrlToken);
        apiPostUrlCreateAccount = System.getenv().getOrDefault("API_POST_IRL_CREATE_ACCOUNT", PropertyReader.getProperty("api.post.url.create.account"));
        log.atInfo().log("'ApiPostUrlCreateAccount' is set to {}", apiPostUrlCreateAccount);
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
