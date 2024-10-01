package Unidireccional.demo.Controllers;

import Unidireccional.demo.Entities.Domicilio;
import Unidireccional.demo.Services.DomicilioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/tp5/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{
    @Autowired
    private DomicilioServiceImpl domicilioServiceImpl;

    @PostMapping("/{domicilioId}/addLocalidad/{localidadId}")
    public ResponseEntity<?> addLocalidad(@PathVariable Long domicilioId, @PathVariable Long localidadId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioServiceImpl.addLocalidad(domicilioId, localidadId));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Porfavor intente más tarde.\"}");
        }
    }
}
