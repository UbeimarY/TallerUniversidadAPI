package universidad.api.model;

import universidad.api.interfaces.Autenticable;
import universidad.api.interfaces.Notificable;
import universidad.api.interfaces.Aprobador;

public class Administrativo extends Persona implements Autenticable, Notificable, Aprobador {

    private static final String USUARIO_CONSTANTE  = "admin";
    private static final String PASSWORD_CONSTANTE = "adm123";

    private String area;

    public Administrativo(String nombre, String correo, String area) {
        super(nombre, correo);
        this.area = area;
    }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    @Override
    public boolean login(String usuario, String password) {
        return USUARIO_CONSTANTE.equals(usuario) && PASSWORD_CONSTANTE.equals(password);
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("[NOTIFICACIÓN → Administrativo " + getNombre() + "]: " + mensaje);
    }

    @Override
    public void aprobarSolicitud(String codigoSolicitud) {
        System.out.println("Administrativo " + getNombre()
                + " aprueba la solicitud: " + codigoSolicitud);
    }
}
