package universidad.api.interfaces;

import universidad.api.model.Estudiante;

public interface Evaluador {
    void evaluar(Estudiante estudiante, double nota);
}