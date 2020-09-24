package utils;

import static io.restassured.RestAssured.given;

public class ApiAdapter {
    PropertiesReader propertiesReader;
    private static String username;
    private static String password;
    private static String client_id;
    private static String client_secret;

    public ApiAdapter() {
        propertiesReader = PropertiesReader.getInstance();
        username = propertiesReader.getValue("USERNAME");
        password = propertiesReader.getValue("PASSWORD");
        client_id = propertiesReader.getValue("API.CLIENT.ID");
        client_secret = propertiesReader.getValue("API.CLIENT.SECRET");
    }

    public String getAccessToken(){
        return
                given()
                        .param("client_id", client_id)
                        .param("client_secret", client_secret)
                        .param("grant_type", "password")
                        .param("username", username)
                        .param("password", password)
                        .param("Content-type", "application/x-www-form-urlencoded")
                        .when()
                        .post("https://login.salesforce.com/services/oauth2/token")
                        .then()
                        .log().ifError()
                        .statusCode(200)
                        .extract().path("access_token");
        //Response about 'invalid_grant' may be returned in case of incorrect password
    }
}
