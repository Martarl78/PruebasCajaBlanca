package com.mycompany.galactico;

import java.util.Random;
import java.util.Scanner;

public class Galactico {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Random rnd = new Random();
            
            // Casilla inicial
            int posicion = 1; 
            
            // Galaxia 000  suma = 0
            int sumaAnterior = 0; 
            
            System.out.println("Empiezas en la casilla 1 (galaxia 000). Pulsa ENTER para tirar los dados.");
            
            while (true) {
                sc.nextLine(); 
                
                // Tirar 3 dados de 9 caras
                int d1 = rnd.nextInt(9);
                int d2 = rnd.nextInt(9);
                int d3 = rnd.nextInt(9);
                
                int suma = d1 + d2 + d3;
                
                // Reducir a un dígito
                while (suma >= 10) {
                    suma = (suma / 10) + (suma % 10);
                }
                
                System.out.println("Dados: " + d1 + d2 + d3 + "  suma reducida = " + suma);
                
                int diferencia = Math.abs(suma - sumaAnterior);
                if (diferencia <= 4) {
                    posicion += diferencia;
                    System.out.println("Avanzas " + diferencia + " casillas.");
                } else {
                    System.out.println("Galaxia lejana, no avanzas.");
                }
                
                // Reglas especiales
                if (posicion == 31) {
                    posicion = 13;
                    System.out.println("Extraterrestres en casilla 31  vuelves a 13.");
                }
                if (posicion == 33) {
                    System.out.println("Agujero negro en casilla 33  pierdes.");
                    break;
                }
                if (posicion == 42) {
                    System.out.println("¡Has llegado a la casilla 42, ganas!");
                    break;
                }
                if (posicion > 42) {
                    posicion = 1;
                    System.out.println("Sobrepasaste 42  vuelves a 1.");
                }
                
                System.out.println("Estas en la casilla " + posicion);
                
                // Actualizar para la siguiente tirada
                sumaAnterior = suma; 
            }
        }
    }
}
