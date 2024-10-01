package Unidireccional.demo.Services;

import Unidireccional.demo.Entities.Autor;
import Unidireccional.demo.Entities.Libro;
import Unidireccional.demo.Repositories.AutorRepository;
import Unidireccional.demo.Repositories.BaseRepository;
import Unidireccional.demo.Repositories.LibroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{
    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LibroRepository libroRepository;
    @Transactional
    @Override
    public boolean delete(Long autorId){
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(()->new EntityNotFoundException("No se encontró un autor con ID igual a "+autorId));
        List<Libro> libros= libroRepository.findByAutores(autor);
        for(Libro libro : libros){
            libro.getAutores().remove(autor);
            libroRepository.save(libro);
        }
        autorRepository.delete(autor);
        return true;
    }
}
