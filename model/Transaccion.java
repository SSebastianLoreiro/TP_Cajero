package model;

import java.time.LocalDateTime;

public class Transaccion {

    private TipoTransaccion tipo;
    private double monto;
    private LocalDateTime fechaHora;
    private String descripcion;

    public Transaccion(TipoTransaccion tipo, double monto, LocalDateTime fechaHora, String descripcion) {
        this.tipo = tipo;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
    }

    public void setTipo(TipoTransaccion tipo) {
        this.tipo = tipo;
    }

    public TipoTransaccion getTipo() {
        return this.tipo;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return this.monto;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public LocalDateTime getFechaHora() {
        return this.fechaHora;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public String toString() {
        return "Transaccion de tipo: " + this.tipo + " monto: " + this.monto + " fecha y hora: " + this.fechaHora
                + " Descripcion: " + this.descripcion;
    }
}
