package com.exchangerateApi.modelos;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
    // Clase para manejar los Nombres completos de los paises 
    // en dado caso  que el cliente no sepa su abreviacion del pais.

    public class PaisMoneda {

        // Clase para manejar los Nombres completos de los paises 
        // en dado caso  que el cliente no sepa su abreviacion del pais.

        private Map<String, String> mapaMonedaPais;

        public PaisMoneda() {
            try {
                // Lee el JSON 
                String jsonContent = Files.readString(Paths.get("src/com/exchangerateApi/monedapais/monedaPais.json"));

                // Crear una instancia de Gson
                Gson gson = new Gson();

                // Crear un tipo de dato para el mapa de moneda-país
                Type tipoMapa = new TypeToken<Map<String, String>>() {}.getType();
                //JsonObject jsonObject = gson.fromJson(jsonContent, JsonObject.class);

                mapaMonedaPais = gson.fromJson(jsonContent, tipoMapa);

            } catch (IOException e) {
                e.printStackTrace(); 
                // O Tambien se puede manejar una excepción personalizada
            }
        }
        public String getMoneda(String nombrePais) {
            // Busca la abreviatura de la moneda en el mapa
            for (Map.Entry<String, String> entry : mapaMonedaPais.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(nombrePais) || entry.getKey().equalsIgnoreCase(nombrePais)) {
                    return entry.getKey(); 
                }
            }
            
            return null; // O lanza una excepción si no se encuentra el país
            
        }
}


