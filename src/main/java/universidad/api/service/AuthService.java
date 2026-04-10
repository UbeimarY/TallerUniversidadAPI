package universidad.api.service;

import universidad.api.model.Administrativo;
import universidad.api.model.Estudiante;
import universidad.api.model.Profesor;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final Estudiante estudiante = new Estudiante("María López", "maria@uni.edu", "EST-001");
    private final Profesor profesor = new Profesor("Carlos Ruiz", "carlos@uni.edu", "Ingeniería de Software");
    private final Administrativo administrativo = new Administrativo("Ana Torres", "ana@uni.edu", "Registro");

    public String autenticar(String rol, String usuario, String password) {
        return switch (rol.toLowerCase()) {
            case "estudiante" -> estudiante.login(usuario, password)
                    ? "Autenticado con éxito como Estudiante: " + estudiante.getNombre()
                    : "Credenciales incorrectas para Estudiante";
            case "profesor" -> profesor.login(usuario, password)
                    ? "Autenticado con éxito como Profesor: " + profesor.getNombre()
                    : "Credenciales incorrectas para Profesor";
            case "admin" -> administrativo.login(usuario, password)
                    ? "Autenticado con éxito como Administrativo: " + administrativo.getNombre()
                    : "Credenciales incorrectas para Administrativo";
            default -> "Rol desconocido: " + rol;
        };
    }

    public Estudiante getEstudiante()         { return estudiante; }
    public Profesor getProfesor()             { return profesor; }
    public Administrativo getAdministrativo() { return administrativo; }
}
