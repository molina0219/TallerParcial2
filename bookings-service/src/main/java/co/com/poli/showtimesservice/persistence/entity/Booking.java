package co.com.poli.showtimesservice.persistence.entity;

import co.com.poli.showtimesservice.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "userid", nullable = false)
    private long userid;

    @Column(name = "showtimeid", nullable = false)
    private long showtimeid;

    @Transient
    private User[] user;

}
