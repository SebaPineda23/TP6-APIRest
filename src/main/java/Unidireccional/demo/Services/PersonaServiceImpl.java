package Unidireccional.demo.Services;

import Unidireccional.demo.Entities.Domicilio;
import Unidireccional.demo.Entities.Libro;
import Unidireccional.demo.Entities.Persona;
import Unidireccional.demo.Repositories.BaseRepository;
import Unidireccional.demo.Repositories.DomicilioRepository;
import Unidireccional.demo.Repositories.LibroRepository;
import Unidireccional.demo.Repositories.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {
    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private DomicilioRepository domicilioRepository;
    @Autowired
    private LibroRepository libroRepository;

    public Persona addDomicilio(Long personaId, Long domicilioId){
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(()-> new EntityNotFoundException("No se encontró una persona con ID igual a "+personaId));
        Domicilio domicilio = domicilioRepository.findById(domicilioId)
                .orElseThrow(()->new EntityNotFoundException("No se encontró un domicilio con ID igual a "+domicilioId));
        if(persona.getDomicilio()!=null && persona.getDomicilio().equals(domicilio)){
            throw new IllegalArgumentException("Esta persona ya tiene un domicilio vinculado con el ID "+domicilioId);
        }
        persona.setDomicilio(domicilio);
        return personaRepository.save(persona);
    }

    @Transactional
    public Persona addPersona( Long personaId, Long libroId){
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(()-> new EntityNotFoundException("No se encontró una persona con ID igual a "+personaId));
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(()->new EntityNotFoundException("No se encontró un libro con ID igual a "+libroId));

        if(persona.getLibros().contains(libro)){
            throw new IllegalArgumentException("El libro con ID "+libroId+" ya esta vinculada a una persona");
        }

        persona.getLibros().add(libro);
        return personaRepository.save(persona);
    }

}
