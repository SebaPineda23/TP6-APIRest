package Unidireccional.demo.Repositories;

import Unidireccional.demo.Entities.Autor;
import Unidireccional.demo.Entities.Libro;
import Unidireccional.demo.Entities.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long>{
    List<Libro> findByAutores(Autor autor);
}
