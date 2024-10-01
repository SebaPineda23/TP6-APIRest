package Unidireccional.demo.Repositories;

import Unidireccional.demo.Entities.Domicilio;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {
}
