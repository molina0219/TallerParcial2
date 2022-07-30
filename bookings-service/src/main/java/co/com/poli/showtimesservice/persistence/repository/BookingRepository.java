package co.com.poli.showtimesservice.persistence.repository;

import co.com.poli.showtimesservice.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
