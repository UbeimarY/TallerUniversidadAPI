package universidad.api.controller;

import universidad.api.service.AuthService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AutenticarController {

    private final AuthService authService;

    public AutenticarController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String rol      = body.getOrDefault("rol", "");
        String usuario  = body.getOrDefault("usuario", "");
        String password = body.getOrDefault("password", "");

        String resultado = authService.autenticar(rol, usuario, password);
        String estado    = resultado.startsWith("Autenticado") ? "exito" : "error";

        return Map.of(
                "estado",  estado,
                "mensaje", resultado
        );
    }
}
