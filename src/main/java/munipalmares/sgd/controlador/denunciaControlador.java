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

//    @PostMapping("/denuncia")
//    ResponseEntity<denuncia> saveDenuncia(@RequestBody denuncia den) {
//
//        // Verificar si se envió evidenciaFotografica como String Base64
//        // Esto solo aplica si en Postman envías la imagen como String
//        if (den.getEvidenciaFotografica() != null) {
//            try {
//                // Intentar decodificar Base64
//                byte[] decoded = java.util.Base64.getDecoder().decode(new String(den.getEvidenciaFotografica()));
//                den.setEvidenciaFotografica(decoded);
//            } catch (IllegalArgumentException e) {
//                // Si no es Base64, lo dejamos como está (ya es byte[])
//            }
//        }
//
//        return ResponseEntity.ok(denunciaRepositorio.save(den));
//    }

    @PutMapping("/denuncia")
    ResponseEntity<denuncia> updateDenuncia(@RequestBody  denuncia denuncia) {
        return ResponseEntity.ok(denunciaRepositorio.save(denuncia));
    }

    @DeleteMapping("/denuncia/{id}")
    ResponseEntity<Void> deleteDenuncia(@PathVariable("id") Integer idDenuncia ){
        denunciaRepositorio.deleteById(idDenuncia);
        return ResponseEntity.ok().build();
    }
}
