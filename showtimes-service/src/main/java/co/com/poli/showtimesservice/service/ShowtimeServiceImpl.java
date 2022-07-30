package co.com.poli.showtimesservice.service;

import co.com.poli.showtimesservice.persistence.entity.Showtime;
import co.com.poli.showtimesservice.persistence.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showTimeRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Showtime showtime) {
        showTimeRepository.save(showtime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {
        return showTimeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Showtime findById(Long id) {
        return showTimeRepository.findById(id).orElse(null);
    }


}
