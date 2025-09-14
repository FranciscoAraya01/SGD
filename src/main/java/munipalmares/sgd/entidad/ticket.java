package munipalmares.sgd.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTicket;

    Date fechaVencimiento;
    Long idDenuncia;
    Long idUsuarioMunicipal;
    Long idEstado;
    Long idPrioridad;
    Long idComentario;

}