package universidad.api.controller;

import universidad.api.service.NotificacionService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @PostMapping("/enviar")
    public Map<String, String> enviarNotificacion(@RequestBody Map<String, String> body) {
        String rol     = body.getOrDefault("rol", "");
        String mensaje = body.getOrDefault("mensaje", "");

        String resultado = notificacionService.enviarNotificacion(rol, mensaje);
        return Map.of("mensaje", resultado);
    }

    @PostMapping("/correo")
    public Map<String, String> enviarCorreo(@RequestBody Map<String, String> body) {
        String destinatario = body.getOrDefault("destinatario", "");
        String asunto       = body.getOrDefault("asunto", "");
        String cuerpo       = body.getOrDefault("cuerpo", "");

        String resultado = notificacionService.enviarCorreoReal(destinatario, asunto, cuerpo);
        return Map.of("mensaje", resultado);
    }
}
