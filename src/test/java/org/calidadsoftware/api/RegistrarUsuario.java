package org.calidadsoftware.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.calidadsoftware.config.PropertiesReader;

public class RegistrarUsuario {

    public static String enBackend(String email, String fullName, String username, String password) {

        String url = PropertiesReader.getProperty("backend.baseUrl")
                + PropertiesReader.getProperty("backend.authRegisterPath");

        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{"
                        + "\"full_name\":\"" + fullName + "\","
                        + "\"username\":\"" + username + "\","
                        + "\"email\":\"" + email + "\","
                        + "\"password\":\"" + password + "\""
                        + "}")
                .post(url);

        response.then().statusCode(201);

        return response.path("access_token");
    }
}
