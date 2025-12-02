package org.calidadsoftware.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.calidadsoftware.config.PropertiesReader;

public class EnviarSolicitud {

    private static final String BASE_URL = PropertiesReader.getProperty("backend.baseUrl") + PropertiesReader.getProperty("backend.friendsRequestsPath");
    public static String enviar(String token, String receiverId) {

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{\"receiver_id\": \"" + receiverId + "\"}")
                .post(BASE_URL);

        response.then().statusCode(201);

        return response.path("_id"); // request_id
    }
}
