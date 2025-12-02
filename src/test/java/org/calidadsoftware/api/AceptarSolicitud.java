package org.calidadsoftware.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.calidadsoftware.config.PropertiesReader;

public class AceptarSolicitud {

    private static final String BASE_URL = PropertiesReader.getProperty("backend.baseUrl")
            + PropertiesReader.getProperty("backend.friendsRequestsBasePath");

    public static void enviar(String token, String receiverId) {

        String URL = BASE_URL + receiverId + "/accept/";

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .post(URL);

        response.then().statusCode(200);
    }
}
