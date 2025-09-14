package munipalmares.sgd.controlador;

import munipalmares.sgd.entidad.denuncia;
import munipalmares.sgd.repositorio.denunciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class denunciaControlador {
    
    @Autowired
    denunciaRepositorio denunciaRepositorio;
    
    
    @GetMapping("/denuncia")
    ResponseEntity<List<denuncia>> getDenuncia(){
        return ResponseEntity.ok(denunciaRepositorio.findAll());
    }

    @PostMapping("/denuncia")
    ResponseEntity<denuncia> saveDenuncia(@RequestBody denuncia denuncia){
        return ResponseEntity.ok(denunciaRepositorio.save(denuncia));
    }

    @PutMapping("/denuncia")
    ResponseEntity<denuncia> updateDenuncia(@RequestBody  denuncia denuncia) {
        return ResponseEntity.ok(denunciaRepositorio.save(denuncia));
    }

    @DeleteMapping("/denuncia/{id}")
    ResponseEntity<Void> deleteDenuncia(@PathVariable("id") Long idDenuncia ){
        denunciaRepositorio.deleteById(idDenuncia);
        return ResponseEntity.ok().build();
    }
}
