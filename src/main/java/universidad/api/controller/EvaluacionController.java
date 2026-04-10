package universidad.api.controller;

import universidad.api.service.EvaluacionService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/evaluacion")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @PostMapping("/evaluar")
    public Map<String, String> evaluar(@RequestBody Map<String, Object> body) {
        double nota = Double.parseDouble(body.getOrDefault("nota", 0).toString());
        String resultado = evaluacionService.evaluar(nota);
        return Map.of("resultado", resultado);
    }
}