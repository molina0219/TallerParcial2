package co.com.poli.showtimesservice.persistence.repository;

import co.com.poli.showtimesservice.persistence.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository  extends JpaRepository<Showtime,Long> {
}
