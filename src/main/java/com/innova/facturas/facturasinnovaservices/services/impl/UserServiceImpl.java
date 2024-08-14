package com.innova.facturas.facturasinnovaservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innova.facturas.facturasinnovaservices.model.dao.UserDao;
import com.innova.facturas.facturasinnovaservices.model.dto.UserDto;
import com.innova.facturas.facturasinnovaservices.model.entity.User;
import com.innova.facturas.facturasinnovaservices.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<User> getAllUsers() {
        return (List) userDao.findAll();
    }

    @Transactional
    @Override
    public User save(UserDto userDto) {

        User user = User.builder()
                .idUser(userDto.getIdUser())
                .idEmpresa(userDto.getIdEmpresa())
                .rol(userDto.getRol())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .lastLogin(userDto.getLastLogin())
                .createdAt(userDto.getCreatedAt())
                .updatedAt(userDto.getUpdatedAt())
                .persona(userDto.getPersona())
                .statusUser(userDto.getStatusUser())
                .createdBy(userDto.getCreatedBy())
                .build();
        return userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public boolean existsById(Integer id) {
        return userDao.existsById(id);
    }

}
