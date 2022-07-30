package co.com.poli.customerservice.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @NotEmpty(message = "El titulo de la pelicula no puede ser vacio")
    @Column(name = "Title")
    private String title;
    @NotEmpty(message = "El titulo de la pelicula no puede ser vacio")
    @Column(name = "director")
    private String director;
    @Min(1)
    @Max(5)
    @Column(name = "rating")
    private int rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return Objects.equals(id, movies.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
