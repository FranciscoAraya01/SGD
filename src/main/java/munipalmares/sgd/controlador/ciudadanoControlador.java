package munipalmares.sgd.controlador;

import munipalmares.sgd.entidad.ciudadano;
import munipalmares.sgd.repositorio.ciudadanoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ciudadanoControlador {

    @Autowired
    ciudadanoRepositorio ciudadanoRepositorio;

    @GetMapping("/ciudadano")
    ResponseEntity <List<ciudadano>> getCiudadano(){
        return ResponseEntity.ok(ciudadanoRepositorio.findAll());
    }

    @PostMapping("/ciudadano")
    ResponseEntity<ciudadano> saveCiudadano(@RequestBody ciudadano ciudadano){
        return ResponseEntity.ok(ciudadanoRepositorio.save(ciudadano));
    }

    @PutMapping("/ciudadano")
    ResponseEntity<ciudadano> updateCiudadano(@RequestBody  ciudadano ciudadano) {
        return ResponseEntity.ok(ciudadanoRepositorio.save(ciudadano));
    }

    @DeleteMapping("/ciudadano/{id}")
    ResponseEntity<Void> deleteCiudadano(@PathVariable("id") Long idCiudadano ){
        ciudadanoRepositorio.deleteById(idCiudadano);
        return ResponseEntity.ok().build();
    }

}
