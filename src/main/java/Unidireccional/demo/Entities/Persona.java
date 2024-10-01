package Unidireccional.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Audited
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "persona")
public class Persona extends Base {
    private String nombre;
    private String apellido;
    private int dni;
    @OneToMany
//    @JoinColumn(name = "libro_id")
    private List<Libro> libros = new ArrayList<>();
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;
}
