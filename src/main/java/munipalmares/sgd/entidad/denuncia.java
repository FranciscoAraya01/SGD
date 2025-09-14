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
public class denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDenuncia;

    String titulo;
    String descripcion;
    Date fechaCreacion;
    Long idCiudadano;
}