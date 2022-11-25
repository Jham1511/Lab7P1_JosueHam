package lab7p1_josueham;

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class Lab7P1_JosueHam {

    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();

    public static void main(String[] args) {

        int opcion = Menu();

        while (opcion != 4) {

            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese las filas de la matriz: ");
                    int filas = leer.nextInt();
                    System.out.println("Ingrese las columnas de la matriz: ");
                    int columnas = leer.nextInt();

                    if (filas != columnas) {
                        int[][] matriz = lectura(filas, columnas);
                        System.out.println("Matriz generada:\n" + imprimir(matriz));
                        JOptionPane.showMessageDialog(null, "Matriz generada:\n" + imprimir(matriz));
                        JOptionPane.showMessageDialog(null, "Matriz rotada:\n" + imprimir(portrait(matriz, filas, columnas)));
                    }//Fin if
                    else {
                        JOptionPane.showMessageDialog(null, "No puede ser una matriz cuadrada");
                    }//Fin else

                }//Fin case 1
                break;

                case 2: {
                    System.out.println("Ingrese las filas de la matriz: ");
                    int filas = leer.nextInt();
                    System.out.println("Ingrese las columnas de la matriz: ");
                    int columnas = leer.nextInt();

                    if (filas != columnas) {
                        int[][] matriz = lectura(filas, columnas);
                        System.out.println("Matriz generada:\n" + imprimir(matriz));
                        JOptionPane.showMessageDialog(null, "Matriz generada:\n" + imprimir(matriz));
                        JOptionPane.showMessageDialog(null, "El número generado es:\n" + NumeroMagico(matriz, filas, columnas));
                    }//Fin if
                    else {
                        JOptionPane.showMessageDialog(null, "La matriz no puede ser cuadrada");
                    }//Fin else
                }//Fin case 2
                break;

                case 3: {
                    System.out.println("Ingrese la primera cadena: ");
                    String cadena1 = leer.next();
                    System.out.println("Ingrese la segunda cadena: ");
                    String cadena2 = leer.next();
                    
                    String cadena1Final = "-" + cadena1;
                    String cadena2Final = "-" + cadena2;
                    
                    imprimir(Subsecuencia (cadena1Final, cadena2Final));
                    JOptionPane.showMessageDialog(null, imprimir(Subsecuencia(cadena1Final, cadena2Final)));
                    JOptionPane.showMessageDialog(null, "El size de la subsecuencia más grande es igual a:\n" + mayorSubsecuencia(Subsecuencia(cadena1Final, cadena2Final)));
                }//Fin case 3
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
            }//Fin del switch
            opcion = Menu();
        }//Fin del while 

    }//Fin del main

    public static int Menu() {
        String menu = "----- Bienvenido al menu del programa -----"
                + "\n1 -> Ejercicio 1 (Portrait)"
                + "\n2 -> Ejercicio 2 (Número mágico)"
                + "\n3 -> Ejercicio 3 (Subsecuencia)"
                + "\n4 -> Salir del programa"
                + "\nIngrese la opcion que desea: ";
        System.out.println(menu);
        int opcion = leer.nextInt();
        return opcion;
    }

    public static int[][] lectura(int filas, int columnas) {

        int temporal[][] = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                temporal[i][j] = 1 + aleatorio.nextInt(9);
            }
        }
        return temporal;
    }//Fin del metodo crear matriz

    public static String imprimir(int[][] numeros) {
        String cadena = "";

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                cadena += "[" + numeros[i][j] + "]";
            }
            cadena += "\n";
        }
        return cadena;
    }//Fin metodo imprimir

    public static int[][] portrait(int[][] matriz, int filas, int columnas) {
        int[][] resultado = new int[columnas][filas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[j][i] = matriz[matriz.length - i - 1][j];
            }
        }

        return resultado;
    }//Fin metodo del portrait

    public static int NumeroMagico(int[][] matriz, int filas, int columnas) {
        int acum_suma = 0;
        int acum_mult = 1;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if ((i == 0 || j == 0) || (i == matriz.length - 1 || j == matriz.length - 1)) {
                    acum_suma += matriz[i][j];
                }//Fin if
                else {
                    acum_mult *= matriz[i][j];
                }//Fin else
            }//Fin for j
        } //Fin for i
        System.out.println("Op.1: " + acum_suma);
        System.out.println("Op.2: " + acum_mult);
        int suma = acum_suma + acum_mult;

        return suma;
    }//Fin metodo numero magico

    public static int[][] Subsecuencia(String cadena1Final, String cadena2Final) {
        
        int[][] resultado = new int[cadena1Final.length()][cadena2Final.length()];
      
        
        
        for (int i = 0; i < cadena1Final.length(); i++) {
            for (int j = 0; j < cadena2Final.length(); j++) {
                if (i == 0 || j == 0) {
                    resultado[i][j]= 0;
                }//Fin if
                else if(cadena1Final.charAt(i) == cadena2Final.charAt(j)){
                    resultado[i][j]=resultado[i-1][j-1]+1;
                }//Fin else if
                else {
                    resultado[i][j]= Math.max(resultado[i][j-1], resultado[i-1][j]);
                }//Fin else
            }
            
        }
        
       
        return resultado;
    }//Fin metodo de subsecuencia 
    
   public static int mayorSubsecuencia (int[][]resultado){
       int mayor = 0;
       for (int i = 0; i < resultado.length; i++) {
           for (int j = 0; j < resultado[i].length; j++) {
               mayor = resultado[i][j];
           }
       }
       
       return mayor;
   }
}//Fin de la clase
