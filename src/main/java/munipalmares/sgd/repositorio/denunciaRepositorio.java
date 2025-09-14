package munipalmares.sgd.repositorio;

import munipalmares.sgd.entidad.denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface denunciaRepositorio extends JpaRepository<denuncia, Long> {
}
