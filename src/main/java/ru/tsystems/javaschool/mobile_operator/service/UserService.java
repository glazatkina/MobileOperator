package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO find(long id);
}
