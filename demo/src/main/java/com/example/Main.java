package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] nombres = {"Juan Pérez", "María González"};
        double[] saldos = {1500.00, 800.00};

        Scanner scanner = new Scanner(System.in);
        while (true) {
            mostrarMenu();
            System.out.println("Seleccione una opción:");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            int usarCuenta = seleccionarCuenta(nombres); 

            switch (opcion) {
                case 1:
                    depositar(saldos, usarCuenta); 
                    break;
                case 2:
                    retirar(saldos, usarCuenta); 
                    break;
                case 3:
                    consultarSaldo(saldos, usarCuenta); 
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el Banco Simple!");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    // Creación de los métodos
    public static void mostrarMenu() {
        System.out.println("\n----- Menú -----");
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Salir");
        System.out.println("----------------");
    }

    public static int seleccionarCuenta(String[] nombres) {
        Scanner cuenta = new Scanner(System.in);
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Índice: " + i + " Titular de la cuenta: " + nombres[i]);
        }
        System.out.println("Seleccione el índice de la cuenta que desea utilizar:");
        int usarCuenta = cuenta.nextInt();
        cuenta.nextLine();

     
        if (usarCuenta >= 0 && usarCuenta < nombres.length) {
            System.out.println("Bienvenido " + nombres[usarCuenta]);
            return usarCuenta; 
        } else {
            System.out.println("Índice inválido. Intente nuevamente.");
            return -1; 
        }
    }

    public static void depositar(double[] saldos, int indice) {
        if (indice < 0) {
            System.out.println("No se ha seleccionado una cuenta válida para depositar.");
            return;
        }
        
        Scanner deposito = new Scanner(System.in);
        System.out.println("Ingrese el monto a depositar:");
        double depositarMonto = deposito.nextDouble();
        deposito.nextLine();

        saldos[indice] += depositarMonto;
        System.out.println("Se ha depositado $" + depositarMonto + " en su cuenta.");
        System.out.println("Su saldo total es: $" + saldos[indice]);
    }

    public static void retirar(double[] saldos, int indice) {
        if (indice < 0) {
            System.out.println("No se ha seleccionado una cuenta válida para retirar.");
            return;
        }

        Scanner retiro = new Scanner(System.in);
        System.out.println("Ingrese el monto a retirar:");
        double retirarMonto = retiro.nextDouble();

        if (retirarMonto <= saldos[indice]) {
            saldos[indice] -= retirarMonto; 
            System.out.println("Se ha retirado $" + retirarMonto + " de su cuenta.");
            System.out.println("Su saldo total es: $" + saldos[indice]);
        } else {
            System.out.println("No tiene suficiente saldo en su cuenta.");
        }
    }

    public static void consultarSaldo(double[] saldos, int indice) {
        if (indice < 0) {
            System.out.println("No se ha seleccionado una cuenta válida para consultar el saldo.");
            return;
        }
        System.out.println("Su saldo total es: $" + saldos[indice]); 
    }
}