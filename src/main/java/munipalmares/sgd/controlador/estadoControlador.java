package munipalmares.sgd.controlador;

import munipalmares.sgd.entidad.estado;
import munipalmares.sgd.repositorio.estadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class estadoControlador {

    @Autowired
    estadoRepositorio estadoRepositorio;

    @GetMapping("/estado")
    ResponseEntity <List<estado>> getEstado(){
        return ResponseEntity.ok(estadoRepositorio.findAll());
    }

    @PostMapping("/estado")
    ResponseEntity<estado> saveEstado(@RequestBody estado estado){
        return ResponseEntity.ok(estadoRepositorio.save(estado));
    }


    @PutMapping("/estado")
    ResponseEntity<estado> updateEstado(@RequestBody estado estado) {
        return ResponseEntity.ok(estadoRepositorio.save(estado));
    }

    @DeleteMapping("/estado/{id}")
    ResponseEntity<Void> deleteEstado(@PathVariable("id") Integer idEstado ) {
        estadoRepositorio.deleteById(idEstado);
        return ResponseEntity.ok().build();
    }

}
