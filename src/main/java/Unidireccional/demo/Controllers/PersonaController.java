package Unidireccional.demo.Controllers;

import Unidireccional.demo.Entities.Persona;
import Unidireccional.demo.Services.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/tp5/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{
    @Autowired
    private PersonaServiceImpl personaServiceImpl;

    @PostMapping("/{personaId}/addDomicilio/{domicilioId}")
    public ResponseEntity<?> addDomicilio(@PathVariable Long personaId, @PathVariable Long domicilioId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaServiceImpl.addDomicilio(personaId, domicilioId));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Porfavor vuelva a intentar más tarde.\"}");
        }
    }
    @PostMapping("/{personaId}/addLibro/{libroId}")
    public ResponseEntity<?> addLibro(@PathVariable Long personaId, @PathVariable Long libroId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaServiceImpl.addPersona(personaId, libroId));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Porfavor vuelva a intentar más tarde.\"}");
        }
    }
}
