package Unidireccional.demo.Controllers;

import Unidireccional.demo.Entities.Autor;
import Unidireccional.demo.Services.AutorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/tp5/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl>{
    @Autowired
    private AutorServiceImpl autorServiceImpl;
}
