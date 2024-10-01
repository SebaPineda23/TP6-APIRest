package Unidireccional.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Audited
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "libro")
public class Libro extends Base{
    private String titulo;
    private int fecha;
    private String genero;
    private int paginas;
    private String autor;
    @ManyToMany()
    @JoinTable(
          name = "libro_autor",
          joinColumns = @JoinColumn(name = "libro_id"),
          inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores = new ArrayList<>();
}
