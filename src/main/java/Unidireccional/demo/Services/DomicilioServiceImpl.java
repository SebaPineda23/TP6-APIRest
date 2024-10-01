package Unidireccional.demo.Services;

import Unidireccional.demo.Entities.Domicilio;
import Unidireccional.demo.Entities.Localidad;
import Unidireccional.demo.Entities.Persona;
import Unidireccional.demo.Repositories.BaseRepository;
import Unidireccional.demo.Repositories.DomicilioRepository;
import Unidireccional.demo.Repositories.LocalidadRepository;
import Unidireccional.demo.Repositories.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService{
    public DomicilioServiceImpl (BaseRepository<Domicilio, Long> baseRepository){
        super(baseRepository);
    }

    @Autowired
    private DomicilioRepository domicilioRepository;
    @Autowired
    private LocalidadRepository localidadRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Transactional
    public Domicilio addLocalidad(Long domicilioId, Long localidadId){
        Domicilio domicilio = domicilioRepository.findById(domicilioId)
                .orElseThrow(()-> new EntityNotFoundException("El domicilio con ID igual a "+domicilioId+" no existe."));
        Localidad localidad = localidadRepository.findById(localidadId)
                .orElseThrow(()-> new EntityNotFoundException("La localidad con ID igual a "+localidadId+" no existe."));
        if(localidad.getDomicilios().contains(domicilio)){
                throw new IllegalArgumentException("El domicilio ya tiene relacionado la localidad "+localidad.getDenominacion());
        }
        localidad.getDomicilios().add(domicilio);
        return domicilioRepository.save(domicilio);
    }
    @Transactional
    @Override
    public boolean delete(Long domicilioId){
        Domicilio domicilio = domicilioRepository.findById(domicilioId)
                .orElseThrow(()-> new EntityNotFoundException("El domicilio con ID igual a "+domicilioId+" no existe."));
        List<Persona> personas = personaRepository.findByDomicilio(domicilio);
        for(Persona persona : personas){
            persona.setDomicilio(null);
            personaRepository.save(persona);
        }
        domicilioRepository.delete(domicilio);
        return true;
    }
}
