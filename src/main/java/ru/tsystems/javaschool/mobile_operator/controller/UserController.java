package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.http.ResponseEntity;
import ru.tsystems.javaschool.mobile_operator.dto.UserDTO;
import ru.tsystems.javaschool.mobile_operator.entity.User;

import java.util.List;

public interface UserController {
    ResponseEntity<List<UserDTO>> findAll();
    ResponseEntity<UserDTO> find(long id);
}
