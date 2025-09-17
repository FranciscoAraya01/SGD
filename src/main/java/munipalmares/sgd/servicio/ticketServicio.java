package munipalmares.sgd.servicio;

import munipalmares.sgd.entidad.estado;
import munipalmares.sgd.entidad.ticket;
import munipalmares.sgd.repositorio.estadoRepositorio;
import munipalmares.sgd.repositorio.ticketRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ticketServicio {

    @Autowired
    private ticketRepositorio ticketRepositorio;

    @Autowired
    private estadoRepositorio estadoRepositorio;

    public ticket crearTicketConEstadoPorDefecto(ticket nuevoTicket) {
        // Obtener el estado inicial por ID (ej. 1 = Enviado)
        estado estadoInicial = estadoRepositorio.findById(1)
                .orElseThrow(() -> new RuntimeException("No se encontró el estado con ID 1"));

        // Asignar el estado al ticket antes de guardarlo
        nuevoTicket.setEstado(estadoInicial);

        return ticketRepositorio.save(nuevoTicket);
    }
}


