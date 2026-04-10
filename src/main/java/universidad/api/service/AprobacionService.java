package universidad.api.service;

import org.springframework.stereotype.Service;

@Service
public class AprobacionService {

    private final AuthService authService;

    public AprobacionService(AuthService authService) {
        this.authService = authService;
    }

    public String aprobarSolicitud(String codigoSolicitud) {
        if (codigoSolicitud == null || codigoSolicitud.isBlank()) {
            return "El código de solicitud no puede estar vacío";
        }
        authService.getAdministrativo().aprobarSolicitud(codigoSolicitud);
        return "Solicitud " + codigoSolicitud + " aprobada por: "
                + authService.getAdministrativo().getNombre();
    }
}