package Unidireccional.demo.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
@Entity(name = "localidad")
public class Localidad extends Base{
    private String denominacion;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "localidad_id")
    private List<Domicilio> domicilios = new ArrayList<>();
}
