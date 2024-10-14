package com.exchangerateApi.modelos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonParser {

    // Manejo de la logicas para, crear, procesar, Retornar y obtener la informacion del JSON.

    /* ---- Explicación de JsonParser:-----
    1. Recibe el JSON, Moneda local y la extranjera.
    2. Del JSON Obtiene, Result, base_code, conversion_rates --> Clave valor.
    Calcula el valor: Si monedaLocal == base_code, Retornar: monedaLocal, monedaExtranjera, valor 
    */

     // Como la clase Moneda esta en el Mismo nivel que JsonParser, no es necesario importar.
     // Método para crear una nueva Moneda (Intancia Moneda) y retorna los resultados calculados.
     public Moneda parsearJson(String json, String monedaLocal, String monedaExtranjera, double valorCliente) {

        // Instancia para leer el JSON
        Gson gson = new Gson();

        // Convertir el JSON a un objeto JsonObject
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        // Obtiene el código de la moneda base del JSON y lo guarda en 'baseCode'.
        String baseCode = jsonObject.get("base_code").getAsString();
        // Obtiene el objeto JSON con las tasas de conversión y lo guarda en 'conversionRates'.
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        
        // Asumiendo que monedaLocal es la moneda base
        if (baseCode.equals(monedaLocal)) {

            double valor = conversionRates.get(monedaExtranjera).getAsDouble(); // Obtener el valor de la moneda extranjera
            double valorTotal= valorCliente * valor; // Multiplicar valor del cliente * valor en la moneda extranjera.
            return new Moneda(monedaLocal, monedaExtranjera, valorTotal); // nueva instancia de Moneda con los resultados calculados.

        } else {
            // Manejar el caso donde monedaLocal no es la moneda base 
            // (se podría hacer otra petición a la API o calcular la tasa)
            return null; // O lanzar una excepción
        }

     }



}
