package model;

import java.util.ArrayList;
import java.util.List;
import model.Transaccion;

public class CuentaBancaria {
    private double saldo;
    private String titular;
    private boolean activa;
    private List<String> historialTransacciones;

    public CuentaBancaria(double saldo, String titular, boolean activa) {
        this.saldo = saldo;
        this.titular = titular;
        this.activa = activa;
        this.historialTransacciones = new ArrayList<String>();
    }

    public void getHistorialTransacciones() {

    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public boolean getActiva() {
        return this.activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @Override
    public String toString() {
        return " Saldo: " + this.saldo + " titular: " + this.titular + " Activa: " + this.activa;
    }
}