package universidad.api.interfaces;

public interface Autenticable {
    boolean login(String usuario, String password);
}