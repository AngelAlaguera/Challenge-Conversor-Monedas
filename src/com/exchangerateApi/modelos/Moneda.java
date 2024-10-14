package com.exchangerateApi.modelos;

public class Moneda {

    // Molde Pirncipal para la clase Moneda, contiene los atributos Principales de conversion.
    // Nota: La API Contiene las conversiones, No la cantidad a convertir por el Usuario . 

    private String monedaLocal;
    private String monedaExtranjera;
    private double valor;

    // constructor de la clase Moneda
    public Moneda(String monedaLocal, String monedaExtranjera, double valor) {

        this.monedaLocal = monedaLocal;
        this.monedaExtranjera = monedaExtranjera;
        this.valor = valor;
    }

    // Getter y Setters, Acceder y Modificar los atributos de la clase.
    public String getMonedaLocal() {
        return monedaLocal;
    }

    public void setMonedaLocal(String monedaLocal) {
        this.monedaLocal = monedaLocal;
    }

    public String getMonedaExtranjera() {
        return monedaExtranjera;
    }

    public void setMonedaExtranjera(String monedaExtranjera) {
        this.monedaExtranjera = monedaExtranjera;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // Metodo toString (Sobre-Escribir) para imprimir los atributos de la clase.
    @Override
    public String toString() {
    return String.format("\n\tMoneda Origen: %s\n\tMoneda Extranjera: %s", 
            monedaLocal, monedaExtranjera); // monedaLocal, valor, monedaExtranjera
    }

}
