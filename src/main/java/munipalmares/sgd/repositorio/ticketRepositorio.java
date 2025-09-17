package munipalmares.sgd.repositorio;

import munipalmares.sgd.entidad.ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ticketRepositorio extends JpaRepository<ticket, Integer> {
    Optional<ticket> findByCodigoRastreo(String codigoRastreo);
}

