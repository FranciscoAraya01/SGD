package munipalmares.sgd.servicio;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class verificacionServicio {

    // Almacenamiento en memoria para los códigos de verificación.
    // En una aplicación real, se usaría una base de datos o una caché como Redis.
    private final ConcurrentHashMap<String, CodeEntry> codeStore = new ConcurrentHashMap<>();
    private final Random random = new Random();

    // Genera, almacena y devuelve un nuevo código para un correo electrónico.
    public String generateAndStoreCode(String email) {
        String code = String.format("%06d", random.nextInt(999999)); // Código de 6 dígitos
        LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(10); // Válido por 10 minutos
        codeStore.put(email.toLowerCase(), new CodeEntry(code, expiresAt));
        return code;
    }

    // Verifica si el código proporcionado para un correo es válido y no ha expirado.
    public boolean verifyCode(String email, String code) {
        CodeEntry entry = codeStore.get(email.toLowerCase());

        if (entry == null) {
            return false; // No hay código para este email
        }

        // Verifica si el código ha expirado
        if (LocalDateTime.now().isAfter(entry.expiresAt())) {
            codeStore.remove(email.toLowerCase()); // Limpiar código expirado
            return false;
        }

        // Si el código es correcto, lo eliminamos para que no se pueda volver a usar
        if (entry.code().equals(code)) {
            codeStore.remove(email.toLowerCase());
            return true;
        }

        return false;
    }

    // Clase interna para almacenar el código y su fecha de expiración.
    private record CodeEntry(String code, LocalDateTime expiresAt) {}
}
