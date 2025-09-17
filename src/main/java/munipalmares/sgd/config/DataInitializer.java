package munipalmares.sgd.config;

import munipalmares.sgd.entidad.estado;
import munipalmares.sgd.repositorio.estadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private estadoRepositorio estadoRepositorio;

    @Bean
    CommandLineRunner initEstado() {
        return args -> {
            // Verifica si el estado con tipo "Enviado" ya existe
            if (estadoRepositorio.count() == 0 || !estadoRepositorio.existsByTipoEstado("Enviado")) {
                estado estadoInicial = new estado();
                estadoInicial.setTipoEstado("Enviado");

                //  No establecer manualmente el ID si está autogenerado
                estadoRepositorio.save(estadoInicial);
                System.out.println(" Estado 'Enviado' creado");
            } else {
                System.out.println(" Estado 'Enviado' ya existe");
            }
        };
    }
}

