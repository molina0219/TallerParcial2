package co.com.poli.showtimesservice.service;

import co.com.poli.showtimesservice.clientFeign.UserClient;
import co.com.poli.showtimesservice.model.User;
import co.com.poli.showtimesservice.persistence.entity.Booking;
import co.com.poli.showtimesservice.persistence.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository showTimeRepository;
    private final UserClient userClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Booking showtime) {
        showTimeRepository.save(showtime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        return showTimeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findById(Long id) {
        return showTimeRepository.findById(id).orElse(null);
    }

}
