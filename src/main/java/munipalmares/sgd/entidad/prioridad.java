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
public class prioridad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrioridad;

    private String descripcion;
}
