package co.com.poli.showtimesservice.persistence.entity;

import co.com.poli.showtimesservice.model.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "showtimes")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Transient
    private Movie[] movie;

}
