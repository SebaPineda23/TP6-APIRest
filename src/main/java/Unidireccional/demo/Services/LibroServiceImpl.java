package Unidireccional.demo.Services;

import Unidireccional.demo.Entities.Autor;
import Unidireccional.demo.Entities.Libro;
import Unidireccional.demo.Entities.Persona;
import Unidireccional.demo.Repositories.AutorRepository;
import Unidireccional.demo.Repositories.BaseRepository;
import Unidireccional.demo.Repositories.LibroRepository;
import Unidireccional.demo.Repositories.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long> implements LibroService{
    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository) {
        super(baseRepository);
    }
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Transactional
    @Override
    public boolean delete(Long libroId){
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(()->new EntityNotFoundException("No se encotró un libro con ID igual a "+libroId));
        List<Persona> personas = personaRepository.findByLibros(libro);
        for(Persona persona : personas){
            persona.getLibros().remove(libro);
            personaRepository.save(persona);
        }
        libroRepository.delete(libro);
        return true;
    }
    @Transactional
    public Libro addAutor(Long libroId, Long autorId){
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(()->new EntityNotFoundException("No se encotró un libro con ID igual a "+libroId));
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(()->new EntityNotFoundException("No se encontró un autor con ID igual a "+autorId));
        if(libro.getAutores().contains(autor)){
            throw new IllegalArgumentException("El libro con ID igual a "+libroId+" ya esta vinculado con el autor con ID "+autorId);
        }
        libro.getAutores().add(autor);
        libroRepository.save(libro);
        return libro;
    }
}
