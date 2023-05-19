package com.example.practica03java;

public class Calculadora {
    public static double sumar(double num1, double num2) {
        return num1 + num2;
    }

    public static double restar(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public static double dividir(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            // Manejo de la excepción: mostrar un mensaje de error en lugar de lanzar la excepción
            throw new IllegalArgumentException("No se puede dividir entre cero");
        }
    }
}



