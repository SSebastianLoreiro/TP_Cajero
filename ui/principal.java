package ui;

import model.*;
import services.CajeroServices;

public class principal {
    public static void main(String[] args) {
        CajeroServices cajero = new CajeroServices(1234);
        CuentaBancaria sebastian = new CuentaBancaria(400000, "Sergio Sebastian Loreiro");
        CuentaBancaria francesco = new CuentaBancaria(999999, "Francesco Stefano Pedrocca Nieto");
        CuentaBancaria antonella = new CuentaBancaria(-50, "Lola Pedrocca");

        // Depósitos

        try {
            cajero.depositar(5000, "Depósito sueldo", sebastian);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        // Extracciones

        try {
            cajero.depositar(2000, "Depósito extra", francesco);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            cajero.depositar(100, "Depósito inicial", antonella);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            cajero.extraccion(1000, "Extracción supermercado", sebastian);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            cajero.extraccion(500, "Extracción nafta", francesco);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        // Transferencias

        try {
            cajero.transferencia(3000, "Pago alquiler", sebastian, francesco);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            cajero.transferencia(200, "Devolución", francesco, antonella);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        // Consultas
        try {

            cajero.consulta(sebastian);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            cajero.consulta(francesco);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        // Casos que lanzan excepciones
        try {

            cajero.extraccion(15000, "Retiro cajero", sebastian);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            cajero.extraccion(999999, "Retiro cajero", antonella);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            cajero.depositar(-100, "Deposito en cuenta", francesco);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            cajero.transferencia(100, "Envio a familiar", sebastian, antonella);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            cajero.depositar(5000, "Depósito sueldo", sebastian);
            System.out.print("Operacion Exitosa\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
