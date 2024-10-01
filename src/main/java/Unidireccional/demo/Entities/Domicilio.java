package Unidireccional.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Audited
@Entity(name = "domicilio")
public class Domicilio extends Base{
    private String calle;
    private int numero;
}
