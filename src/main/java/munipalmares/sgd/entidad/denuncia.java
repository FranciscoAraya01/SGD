package munipalmares.sgd.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDenuncia;

    private LocalDateTime fechahora;
    private String direccion;
    private String gis;
    private String descripcion;
    private String categoria;
    @Lob
    private byte[] evidenciaFotografica;

    private Boolean anonimato;
    @ManyToOne
    @JoinColumn(name = "idCiudadano")
    private ciudadano ciudadano;
}