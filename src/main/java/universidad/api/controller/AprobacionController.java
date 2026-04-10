package universidad.api.controller;

import universidad.api.service.AprobacionService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/aprobacion")
public class AprobacionController {

    private final AprobacionService aprobacionService;

    public AprobacionController(AprobacionService aprobacionService) {
        this.aprobacionService = aprobacionService;
    }

    @PostMapping("/aprobar")
    public Map<String, String> aprobar(@RequestBody Map<String, String> body) {
        String codigo    = body.getOrDefault("codigoSolicitud", "");
        String resultado = aprobacionService.aprobarSolicitud(codigo);
        return Map.of("resultado", resultado);
    }
}
