package utils;

import org.apache.http.protocol.HTTP;
import static io.restassured.RestAssured.given;

public class ApiAdapter {
    private static String username;
    private static String password;
    private static String clientId;
    private static String clientSecret;
    private static String apiPostUrlToken;
    public static String loginUrl;
    public static String baseUrlClassic;
    public static String apiPostUtlCreatAccount;

    public ApiAdapter() {
        PropertiesReader propertiesReader = PropertiesReader.getInstance();
        username = propertiesReader.getValue("username");
        password = propertiesReader.getValue("password");
        loginUrl = propertiesReader.getValue("login.url");
        clientId = propertiesReader.getValue("api.client.id");
        clientSecret = propertiesReader.getValue("api.client.secret");
        baseUrlClassic = propertiesReader.getValue("base.url.classic");
        apiPostUrlToken = propertiesReader.getValue("api.post.url.token");
        apiPostUtlCreatAccount = propertiesReader.getValue("api.post.url.create.account");
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
