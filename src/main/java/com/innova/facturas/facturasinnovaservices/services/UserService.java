package com.innova.facturas.facturasinnovaservices.services;

import java.util.List;

import com.innova.facturas.facturasinnovaservices.model.dto.UserDto;
import com.innova.facturas.facturasinnovaservices.model.entity.User;

public interface UserService {

    User save(UserDto userDto);

    User findById(Integer id);

    void delete(User user);

    List<User> getAllUsers();

    boolean existsById(Integer id);

}
