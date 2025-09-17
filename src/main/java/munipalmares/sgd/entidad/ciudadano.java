package munipalmares.sgd.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ciudadano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCiudadano;

    private String nombreCiudadano;
    private String correoElectronico;
    private String identificacion;
}
