package co.com.poli.userservice.service;

import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.service.dto.UserInDTO;

import java.util.List;

public interface UserService {

    void save(User user);
    void delete(User user);
    List<User> findAll();
    User findById(Long id);
    User createUser(UserInDTO userInDTO);
}
