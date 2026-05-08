package services;

import model.*;
import java.util.ArrayList;

public class CajeroServices {
    private ArrayList<CuentaBancaria> cuentasBancarias;
    private int pin;

    public CajeroServices(int pin) {
        this.pin = pin;
        this.cuentasBancarias = new ArrayList<>();
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
