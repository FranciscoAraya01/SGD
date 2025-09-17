package munipalmares.sgd.controlador;

import munipalmares.sgd.entidad.ticket;
;
import munipalmares.sgd.repositorio.ticketRepositorio;
import munipalmares.sgd.servicio.ticketServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ticketControlador {

    @Autowired
    ticketRepositorio ticketRepositorio;
    @Autowired
    ticketServicio ticketServicio;

    @GetMapping("/ticket")
    ResponseEntity<List<ticket>> getTicket(){
        return ResponseEntity.ok(ticketRepositorio.findAll());
    }

    @GetMapping("/ticket/codigo/{codigoRastreo}")
    public ResponseEntity<ticket> getTicketByCodigoRastreo(@PathVariable String codigoRastreo) {
        return ticketRepositorio.findByCodigoRastreo(codigoRastreo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/ticket")
    ResponseEntity<ticket> saveTicket(@RequestBody ticket ticket){
        return ResponseEntity.ok(ticketServicio.crearTicketConEstadoPorDefecto(ticket));
    }

    @PutMapping("/ticket")
    ResponseEntity<ticket> updateTicket(@RequestBody  ticket ticket) {
        return ResponseEntity.ok(ticketRepositorio.save(ticket));
    }

    @DeleteMapping("/ticket/{id}")
    ResponseEntity<Void> deleteTicket(@PathVariable("id") Integer idTicket ) {
        ticketRepositorio.deleteById(idTicket);
        return ResponseEntity.ok().build();
    }
}