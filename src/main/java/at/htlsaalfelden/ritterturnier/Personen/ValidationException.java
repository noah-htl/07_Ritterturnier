package at.htlsaalfelden.ritterturnier.Personen;

public class ValidationException extends Exception {
    private String object;
    public ValidationException(String object, String message) {
        super(message);
        this.object = object;
    }

    public String getObject() {
        return object;
    }
}
