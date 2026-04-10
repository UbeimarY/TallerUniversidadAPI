package universidad.api.model;

import universidad.api.interfaces.Autenticable;
import universidad.api.interfaces.Notificable;
import universidad.api.interfaces.Evaluador;

public class Profesor extends Persona implements Autenticable, Notificable, Evaluador {

    private static final String USUARIO_CONSTANTE  = "profesor";
    private static final String PASSWORD_CONSTANTE = "prof123";

    private String especialidad;

    public Profesor(String nombre, String correo, String especialidad) {
        super(nombre, correo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public boolean login(String usuario, String password) {
        return USUARIO_CONSTANTE.equals(usuario) && PASSWORD_CONSTANTE.equals(password);
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("[NOTIFICACIÓN → Profesor " + getNombre() + "]: " + mensaje);
    }

    @Override
    public void evaluar(Estudiante estudiante, double nota) {
        System.out.println("Profesor " + getNombre() + " evalúa a "
                + estudiante.getNombre() + " con nota: " + nota);
    }
}