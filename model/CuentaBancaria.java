package model;

import java.util.ArrayList;
import java.util.List;
import exceptions.*;

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

    public void realizarTransaccion(Transaccion t, CuentaBancaria cuentaBancaria)
            throws CuentaInactivaException, MontoInvalidoException, LimiteExtraccionExcedidoException,
            SaldoInsuficienteException, TipoDeTransaccionInvalidaException {

        StringBuilder sb = new StringBuilder();
        switch (t.getTipo()) {
            case DEPÓSITO:
                if (t.getMonto() < 0) {
                    throw new MontoInvalidoException("Monto Invalido");
                } else {
                    this.saldo += t.getMonto();
                    sb.append("[");
                    sb.append(t.getFechaHora());
                    sb.append("]");
                    sb.append(t.getTipo());
                    sb.append(": $");
                    sb.append(t.getMonto());
                    sb.append(" | Saldo: $");
                    sb.append(this.getSaldo());
                    this.historialTransacciones.add(sb.toString());
                }

                break;
            case EXTRACCIÓN:
                if (t.getMonto() > 10000) {
                    throw new LimiteExtraccionExcedidoException("Limite de 10000 por operacion excedido");
                } else if (saldo < t.getMonto()) {
                    throw new SaldoInsuficienteException("Saldo Insuficiente");
                } else {
                    this.saldo -= t.getMonto();
                    sb.append("[");
                    sb.append(t.getFechaHora());
                    sb.append("]");
                    sb.append(t.getTipo());
                    sb.append(": $");
                    sb.append(t.getMonto());
                    sb.append(" | Saldo: $");
                    sb.append(this.getSaldo());
                    this.historialTransacciones.add(sb.toString());
                }
                break;
            case TRANSFERENCIA:
                if (t.getMonto() < 0) {
                    throw new MontoInvalidoException("Monto Invalido");
                } else if (this.saldo < t.getMonto()) {
                    throw new SaldoInsuficienteException("Saldo Insuficiente");
                } else {
                    if (cuentaBancaria.getActiva() == false) {
                        throw new CuentaInactivaException("Cuenta inactiva");
                    } else {
                        this.saldo -= t.getMonto();
                        cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() + t.getMonto());
                        sb.append("[");
                        sb.append(t.getFechaHora());
                        sb.append("]");
                        sb.append(t.getTipo());
                        sb.append(": $");
                        sb.append(t.getMonto());
                        sb.append(" | Saldo: $");
                        sb.append(this.getSaldo());
                        this.historialTransacciones.add(sb.toString());
                    }
                }
                break;
            default:
                throw new TipoDeTransaccionInvalidaException("Tipo de transaccion invalida");
        }

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