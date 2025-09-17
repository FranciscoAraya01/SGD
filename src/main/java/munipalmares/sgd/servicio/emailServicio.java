package munipalmares.sgd.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailServicio {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationCode(String to, String code) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("felcor.0703@gmail.com");
            helper.setTo(to);
            helper.setSubject("Tu código de verificación");

            String htmlMsg = "<p>Hola,</p><p>Tu código de verificación es: <strong>" + code + "</strong></p><p>Este código es válido por 5 minutos.</p>";
            helper.setText(htmlMsg, true);

            mailSender.send(message);
        } catch (Exception e) {
            // Aquí debemos registrar el error.
            System.err.println("Error al enviar el correo: " + e.getMessage());
            throw new RuntimeException("Error al enviar el correo de verificación.", e);
        }
    }
}
