package munipalmares.sgd.repositorio;

import munipalmares.sgd.entidad.estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface estadoRepositorio extends JpaRepository<estado, Integer> {
    boolean existsByTipoEstado(String tipoEstado);
}
