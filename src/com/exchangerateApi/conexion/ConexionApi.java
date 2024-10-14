package com.exchangerateApi.conexion;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
//import java.net.URISyntaxException;

public class ConexionApi {

    // Variables de la clase URL
    private String url;
    private String json; // Variable para almacenar la respuesta JSON

    // Constructor de la clase ConexionApi que recibe la URL como parámetro.
    public ConexionApi(String url) {
        this.url = url;
    }

    // Getter y Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Crear Cliente HTTP.
    HttpClient client = HttpClient.newHttpClient();

    // Clase para realizar la peticion a la API y obtener la respuesta en formato JSON.
    public String getJsonResponse() {

        // Manejo de Excepciones IOException | InterruptedException
        try {
            // Crear Solicitud http, con la url de la API.
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            // Enviar Solicitud, Obtener respuesta de la API.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Obtener Respuesta Publica en formato JSON.
            json = response.body();

        } catch (IOException | InterruptedException e) {
            // Manejar las posibles excepciones (URISyntaxException, IOException,
            // InterruptedException)
            System.out.println("Error al realizar la petición a la API: " + e.getMessage());
            e.printStackTrace(); // Imprimir el stack trace para depuración.
        }
        return json;

    } // Fin del metodo getJsonResponse.

    // --------- Otra forma de manejar exepciones con Thows --------
    /* 
     public String getJsonResponse() throws URISyntaxException, IOException, InterruptedException {

        // Crear Solicitud http, con la url de la API.
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        // Enviar Solicitud, Obtener respuesta de la API.
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Obtener Respuesta Publica en formato JSON.
        json = response.body();
        
    } // Fin del metodo getJsonResponse.

        return json; // Retornar la respuesta en formato JSON, fuera del getJsonResponse()
     */
        
} // Fin de la clase ConexionApi


