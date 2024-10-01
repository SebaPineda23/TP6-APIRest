package Unidireccional.demo.Controllers;

import Unidireccional.demo.Entities.Localidad;
import Unidireccional.demo.Services.BaseServiceImpl;
import Unidireccional.demo.Services.LocalidadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("tp5/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{
    @Autowired
    private LocalidadServiceImpl localidadServiceImpl;
}
