/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;
import java.util.Scanner;
import com.mycompany.excepciones.*;

/**
 *
 * @author Santi
 */
public class Calculadora {

    public static void main(String[] args) {
        
        int n1;
        int n2;
       
        Scanner scanner = new Scanner(System.in);
        
        // Bloque try-finally para asegurar que el Scanner se cierre al finalizar o salir
        try {
            for (;;){
                System.out.println("====== Calculadora ======");
                System.out.println("Digite una operación aritmetica");
                System.out.println("- Puedes salir escribiendo //");
                
                System.out.println("Digite la operacion aritmetica (+ | - | * | /)");
                String opc = scanner.nextLine();
                     
                if (opc.equalsIgnoreCase("//")) {
                     System.out.println("CIERRE: Saliendo del programa.");
                     System.out.println("--------------");
                     break; // Cambiado a break para que salga del ciclo y permita llegar al finally
                }
                
                if (!opc.equals("+") && !opc.equals("-") && !opc.equals("*") && !opc.equals("/")) {
                    try {
                        throw new operacionInvalida("ERROR: Se esperaba una operacion valida.");
                    } catch (operacionInvalida e) {
                        System.out.println(e.getMessage());
                        System.out.println("--------------------");
                        continue;
                    }
                }
               
                // 4. NumberFormatException: convertir texto no numérico
                try {
                    System.out.println("Digite el primer numero");
                    n1 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite el segundo numero");
                    n2 = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Se esperaba un numero valido.");
                    System.out.println("--------------------");
                    continue;
                }
                
                switch (opc) {
                    case "+" -> System.out.println("La suma es " + (n1+n2));
                    case "-" -> System.out.println("La resta es " + (n1-n2));
                    case "*" -> System.out.println("La multiplicacion es " + (n1*n2));
                    case "/" -> {
                        // 3. ArithmeticException: división por cero
                        try {
                            System.out.println("La division es " + (n1/n2));
                        } catch (ArithmeticException e) {
                            System.out.println("ERROR: Division por cero");
                        }
                    }
                    default -> {
                        break;
                    }
                }
                System.out.println("--------------------");
            }
        } finally {
            scanner.close();
        }
    }
}