package universidad.api.service;

import universidad.api.model.Estudiante;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionService {

    private final AuthService authService;

    public EvaluacionService(AuthService authService) {
        this.authService = authService;
    }

    public String evaluar(double nota) {
        if (nota < 0 || nota > 10) {
            return "La nota debe estar entre 0 y 10";
        }
        Estudiante est = authService.getEstudiante();
        authService.getProfesor().evaluar(est, nota);

        String estado = nota >= 6.0 ? "APROBADO" : "REPROBADO";
        return "Evaluación registrada → " + est.getNombre()
                + " | Nota: " + nota + " | Estado: " + estado;
    }
}