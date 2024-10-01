package Unidireccional.demo.Controllers;

import Unidireccional.demo.Entities.Libro;
import Unidireccional.demo.Services.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/tp5/libros")
public class LibroController extends BaseControllerImpl<Libro, LibroServiceImpl>{
    @Autowired
    private LibroServiceImpl libroServiceImpl;
    @PostMapping("/{libroId}/addAutor/{autorId}")
    public ResponseEntity<?> addAutor(@PathVariable Long libroId, @PathVariable Long autorId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroServiceImpl.addAutor(libroId,autorId));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Porfavor intente más tarde.\"}");
        }
    }
}
