package services;

import model.*;
import java.util.ArrayList;
import exceptions.*;

import java.time.LocalDateTime;

public class CajeroServices {
    private ArrayList<CuentaBancaria> cuentasBancarias;
    private int pin;

    public CajeroServices(int pin) {
        this.pin = pin;
        this.cuentasBancarias = new ArrayList<>();
    }

    public void agregarCuentaBancaria(CuentaBancaria cuenta) {
        cuentasBancarias.add(cuenta);
    }

    public void mostrarCuentas() {
        int i = 0;
        for (CuentaBancaria cuenta : cuentasBancarias) {
            System.out.println("Cuenta : " + (i + 1));
            System.out.println(cuenta);
            System.out.println("\n");
            i++;
        }
    }

    public void depositar(double monto, String descripcion, CuentaBancaria cuentaBancaria)
            throws CuentaInactivaException, MontoInvalidoException, LimiteExtraccionExcedidoException,
            SaldoInsuficienteException, TipoDeTransaccionInvalidaException {
        if ((cuentaBancaria.getActiva() == false)) {
            throw new CuentaInactivaException("Error: Cuenta Inactiva");
        } else if (monto < 0) {
            throw new MontoInvalidoException("Error: Monto Invalido");
        } else {
            Transaccion t = new Transaccion(TipoTransaccion.DEPÓSITO, monto, LocalDateTime.now(), descripcion);
            cuentaBancaria.realizarTransaccion(t, null);
        }
    }

    public void extraccion(double monto, String descripcion, CuentaBancaria cuentaBancaria)
            throws CuentaInactivaException, MontoInvalidoException, LimiteExtraccionExcedidoException,
            SaldoInsuficienteException, TipoDeTransaccionInvalidaException {
        if (cuentaBancaria.getActiva() == false) {
            throw new CuentaInactivaException("Error: Cuenta inactiva");
        } else if (monto < 0) {
            throw new MontoInvalidoException("Error: Monto invalido, menor que 0");
        } else if (monto > 10000) {
            throw new LimiteExtraccionExcedidoException("Error: Monto invalido: supera los $10.000");
        } else if (cuentaBancaria.getSaldo() < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        } else {
            Transaccion t = new Transaccion(TipoTransaccion.EXTRACCIÓN, monto, LocalDateTime.now(), descripcion);
            cuentaBancaria.realizarTransaccion(t, null);
        }
    }

    public void transferencia(double monto, String descripcion, CuentaBancaria cuentaBancaria,
            CuentaBancaria cuentaDestino)
            throws CuentaInactivaException, MontoInvalidoException, LimiteExtraccionExcedidoException,
            SaldoInsuficienteException, TipoDeTransaccionInvalidaException {

        if (cuentaBancaria.getActiva() == false || cuentaDestino.getActiva() == false) {
            throw new CuentaInactivaException("Error cuenta/s inactiva/s");
        } else if (monto < 0) {
            throw new MontoInvalidoException("Error monto invalido menor a 0");
        } else if (cuentaBancaria.getSaldo() < monto) {
            throw new SaldoInsuficienteException("Error: saldo insuficiente");
        } else {
            Transaccion t = new Transaccion(TipoTransaccion.TRANSFERENCIA, monto, LocalDateTime.now(), descripcion);
            cuentaBancaria.realizarTransaccion(t, cuentaDestino);
        }
    }

    public String consulta(CuentaBancaria cuentaBancaria) throws CuentaInactivaException {
        if (cuentaBancaria.getActiva()) {
            return cuentaBancaria.toString();
        } else {
            throw new CuentaInactivaException("Cuenta inactiva");
        }
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return this.pin;
    }

    @Override
    public String toString() {
        return "";
    }
}
