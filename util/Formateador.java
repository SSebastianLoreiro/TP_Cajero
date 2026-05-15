package util;

public class Formateador {
    public static String formatearMonto(double monto) {
        return String.format("$%,.2f", monto);
    }
}
