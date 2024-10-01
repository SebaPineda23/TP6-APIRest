package Unidireccional.demo.Repositories;

import Unidireccional.demo.Entities.Domicilio;
import Unidireccional.demo.Entities.Libro;
import Unidireccional.demo.Entities.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long>{

    List<Persona> findByDomicilio(Domicilio domicilio);
    List<Persona> findByLibros(Libro libro);
}
