package org.calidadsoftware.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.calidadsoftware.config.PropertiesReader;

public class LoginUsuario {

    public static String enBackend(String email, String password) {

        String url = PropertiesReader.getProperty("backend.baseUrl")
                + PropertiesReader.getProperty("backend.authLoginPath");

        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{"
                        + "\"email\":\"" + email + "\","
                        + "\"password\":\"" + password + "\""
                        + "}")
                .post(url);

        response.then().statusCode(200);

        return response.path("access_token");
    }
}
