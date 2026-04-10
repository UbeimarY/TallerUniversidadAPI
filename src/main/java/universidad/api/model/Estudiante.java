package universidad.api.model;

import universidad.api.interfaces.Autenticable;
import universidad.api.interfaces.Notificable;

public class Estudiante extends Persona implements Autenticable, Notificable {

    private static final String USUARIO_CONSTANTE  = "estudiante";
    private static final String PASSWORD_CONSTANTE = "est123";

    private String codigo;

    public Estudiante(String nombre, String correo, String codigo) {
        super(nombre, correo);
        this.codigo = codigo;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    @Override
    public boolean login(String usuario, String password) {
        return USUARIO_CONSTANTE.equals(usuario) && PASSWORD_CONSTANTE.equals(password);
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("[NOTIFICACIÓN → Estudiante " + getNombre() + "]: " + mensaje);
    }
}