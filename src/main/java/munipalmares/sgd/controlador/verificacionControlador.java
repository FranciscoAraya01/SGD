package munipalmares.sgd.controlador;

import munipalmares.sgd.servicio.emailServicio;
import munipalmares.sgd.servicio.verificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/verification")
public class verificacionControlador {

    @Autowired
    private verificacionServicio verificacionServicio;

    @Autowired
    private emailServicio emailServicio ;

    @PostMapping("/send-code")
    public ResponseEntity<Map<String, String>> sendCode(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "El correo es obligatorio."));
        }

        try {
            String code = verificacionServicio.generateAndStoreCode(email);
            emailServicio.sendVerificationCode(email, code);
            return ResponseEntity.ok(Map.of("message", "Código enviado correctamente."));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("message", "Error al enviar el código."));
        }
    }

    @PostMapping("/verify-code")
    public ResponseEntity<Map<String, String>> verifyCode(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String code = request.get("code");

        if (email == null || code == null || email.isEmpty() || code.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "El correo y el código son obligatorios."));
        }

        boolean isValid = verificacionServicio.verifyCode(email, code);

        if (isValid) {
            return ResponseEntity.ok(Map.of("message", "Código verificado correctamente."));
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "Código incorrecto o expirado."));
        }
    }
}
