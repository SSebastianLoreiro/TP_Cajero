package exceptions;

public class TipoDeTransaccionInvalidaException extends Exception {
    public TipoDeTransaccionInvalidaException(String mensaje) {
        super(mensaje);
    }
}
