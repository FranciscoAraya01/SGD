package munipalmares.sgd.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;
import java.util.Random;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTicket;
    @Column(unique = true)
    private String codigoRastreo;
    LocalDate fechaVencimiento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDenuncia")
    private denuncia denuncia;

    private Integer idUsuarioMunicipal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado")
    private estado estado;
    private Integer idPrioridad;
    private Integer idComentario;


    @PrePersist
    public void prePersist() {
        generarCodigoRastreo();
        generarFechaVencimiento();
    }
    public void generarCodigoRastreo() {
        if (this.codigoRastreo == null || this.codigoRastreo.isEmpty()) {
            int numeroAleatorio = new Random().nextInt(9000) + 1000; // genera número de 4 dígitos
            int anioActual = Year.now().getValue();
            this.codigoRastreo = "DN-" + anioActual + "-" + numeroAleatorio;
        }
    }

//    private void generarCodigoRastreo() {
//        if (this.codigoRastreo == null || this.codigoRastreo.isEmpty()) {
//            int anioActual = Year.now().getValue();
//            // Usamos UUID para asegurar unicidad
//            String uuidFragment = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
//            this.codigoRastreo = "DN-" + anioActual + "-" + uuidFragment;
//        }
//    }

    private void generarFechaVencimiento() {
        if (this.fechaVencimiento == null) {
            this.fechaVencimiento = LocalDate.now().plusMonths(3);
        }
    }
}