package universidad.api.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    private final AuthService authService;
    private final JavaMailSender mailSender;

    public NotificacionService(AuthService authService, JavaMailSender mailSender) {
        this.authService = authService;
        this.mailSender  = mailSender;
    }

    public String enviarNotificacion(String rol, String mensaje) {
        return switch (rol.toLowerCase()) {
            case "estudiante" -> {
                authService.getEstudiante().enviarNotificacion(mensaje);
                yield "Notificación enviada al estudiante: " + authService.getEstudiante().getNombre();
            }
            case "profesor" -> {
                authService.getProfesor().enviarNotificacion(mensaje);
                yield "Notificación enviada al profesor: " + authService.getProfesor().getNombre();
            }
            case "admin" -> {
                authService.getAdministrativo().enviarNotificacion(mensaje);
                yield "Notificación enviada al administrativo: " + authService.getAdministrativo().getNombre();
            }
            default -> "Rol desconocido: " + rol;
        };
    }

    public String enviarCorreoReal(String destinatario, String asunto, String cuerpo) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject(asunto);
        mensaje.setText(cuerpo);
        mailSender.send(mensaje);
        return "Correo enviado correctamente a: " + destinatario;
    }
}