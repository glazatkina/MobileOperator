package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.dto.UserDTO;
import ru.tsystems.javaschool.mobile_operator.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO find(long id);
}
