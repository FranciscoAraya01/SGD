package munipalmares.sgd.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idComentario;

    String descripcion;
    Date fechaComentario;
    Long idUsuarioMunicipal;
}
