package exceptions;

public class AliasForWaiterIsNotSetException extends Exception {
    public AliasForWaiterIsNotSetException() {
        super("Obligatory parameter alias is not set for your Waiter instance");
    }
}
