package com.exchangerateApi.principal;

import java.util.Scanner;

import com.exchangerateApi.conexion.ConexionApi;
import com.exchangerateApi.modelos.JsonParser;
import com.exchangerateApi.modelos.Moneda;
import com.exchangerateApi.modelos.PaisMoneda;

public class App {
    public static void main(String[] args) throws Exception {

        // Programa de Conversion de Monedas con Java Usando Una API exchangerate-api

        // Crear instancia de la clase Scanner para leer la entrada del usuario.
        Scanner scanner = new Scanner(System.in);

        System.out.println("******************************************************");
        System.out.println("\nBienvenidos al conversor de monedas Online");
        System.out.println("** Digite Acrónimos de Monedas como: USD, EUR, GBP, etc **");
        System.out.println("** Si no Conoce la Moneda Digite el pais o La Zona correspondiente **");
        System.out.println("** Para Euros Digite EUR o Eurozona **");

        try {
            // De pais (nombre pais) a moneda (abreviatura)
            PaisMoneda paisMoneda = new PaisMoneda();

            String monedaOrigen = null; // Var, almacena la moneda de origen si no es null.

            while (monedaOrigen == null) {

                System.err.print("\n* Digite la moneda de origen que desea convertir: ");
                monedaOrigen = scanner.nextLine().toUpperCase(); // Leer la moneda ingresada por el usuario.

                monedaOrigen = paisMoneda.getMoneda(monedaOrigen);
                // busca la abreviatura o pais de la moneda en el mapa o devuelve null si no lo encuentra.
                if (monedaOrigen == null) {
                    System.err.println("Moneda de Origen no válida. Por favor, ingrese una moneda o Pais válidos.");
                }
            } // Fin del While.

            String monedaConversion = null; // Var, almacena la moneda de conversion si no es null.

            while (monedaConversion == null) {

                System.out.print("* Digite la Moneda a la que desea convertir: ");
                monedaConversion = scanner.nextLine().toUpperCase(); // Leer la moneda ingresada por el usuario.

                // De pais (nombre completo) a moneda (abreviatura), en dado caso que el cliente
                // no sabe la abreviatura.
                monedaConversion = paisMoneda.getMoneda(monedaConversion);
                if (monedaConversion == null) {
                    System.err.println("Moneda a convertir no válida. Por favor, ingrese una moneda o Pais válidos.");
                }
            } // Fin del While.

            double cantidadConvertir = 0; // Var, almacena la cantidad a convertir si es mayor 0.
            boolean condition = false;
            while (!condition) {

                System.out.print("* Digite la cantidad a convertir: ");
                try {
                    cantidadConvertir = Double.valueOf(scanner.nextLine()); // Cantidad Digitada Por el Usuario
                    //cantidadConvertir = Double.parseDouble(scanner.nextLine()); 
                    if (cantidadConvertir >= 0) {
                        condition = true;
                    } else {
                        System.err.println("La Cantidad debe ser un número positivo......");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Cantidad no válida. Por favor, ingrese solo Numeros Positivos.");
                }
            } // Fin del While.

            var url = "https://v6.exchangerate-api.com/v6/9d4a4e7796117edb31856862/latest/%s".formatted(monedaOrigen);

            // Crear instancia de la clase ConexionApi con la URL de la API
            ConexionApi conexionApi = new ConexionApi(url);
            String json = conexionApi.getJsonResponse();

            // Pasamos la Informacion de la API (Json) a la clase Modena.
            // Moneda moneda1 = new Moneda("USD", "EUR", 0.85, json);

            JsonParser jsonParser = new JsonParser();
            Moneda resultadoConvercion = jsonParser.parsearJson(json, monedaOrigen, monedaConversion,
                    cantidadConvertir);

            System.out.println("\n********** Informacion de la conversion ***********");
            System.out.println(resultadoConvercion.toString());
            System.out.println("\t"+cantidadConvertir + " " + resultadoConvercion.getMonedaLocal() + " Equivale a: "
                               + resultadoConvercion.getValor() + " " + resultadoConvercion.getMonedaExtranjera() + "\n");
                               // Revisar esta liea de codigo ya que no pude pasar cantidadConvertir a la clase moneda.
            System.out.println("******************************************************");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }

    }
}
