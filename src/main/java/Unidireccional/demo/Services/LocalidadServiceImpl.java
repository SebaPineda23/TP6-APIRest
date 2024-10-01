package Unidireccional.demo.Services;

import Unidireccional.demo.Entities.Domicilio;
import Unidireccional.demo.Entities.Localidad;
import Unidireccional.demo.Entities.Persona;
import Unidireccional.demo.Repositories.BaseRepository;
import Unidireccional.demo.Repositories.DomicilioRepository;
import Unidireccional.demo.Repositories.LocalidadRepository;
import Unidireccional.demo.Repositories.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService{
    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository){
        super(baseRepository);
    }
    @Autowired
    private LocalidadRepository localidadRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private DomicilioRepository domicilioRepository;
    @Transactional
    @Override
    public boolean delete(Long localidadId) {
        Localidad localidad = localidadRepository.findById(localidadId)
                .orElseThrow(() -> new EntityNotFoundException("La localidad con ID " + localidadId + " no existe"));

        // Iterar sobre cada domicilio y desasociar personas antes de eliminar
        for (Domicilio domicilio : new ArrayList<>(localidad.getDomicilios())) {
            // Desasociar el domicilio de las personas
            List<Persona> personas = personaRepository.findByDomicilio(domicilio);
            for (Persona persona : personas) {
                persona.setDomicilio(null);  // Desasociar el domicilio
                personaRepository.save(persona);  // Guardar los cambios en la persona
            }

            // Ahora eliminar el domicilio
            domicilioRepository.delete(domicilio);
        }

        // Ahora elimina la localidad
        localidadRepository.delete(localidad);
        return true;
    }

}
