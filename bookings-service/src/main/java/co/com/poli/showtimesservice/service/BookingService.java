package co.com.poli.showtimesservice.service;

import co.com.poli.showtimesservice.persistence.entity.Booking;

import java.util.List;

public interface BookingService {
    void save(Booking showtime);
    List<Booking> findAll();
    Booking findById(Long id);
}
