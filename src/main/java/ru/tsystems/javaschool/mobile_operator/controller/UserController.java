package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import ru.tsystems.javaschool.mobile_operator.dto.UserDTO;

import java.util.List;

public interface UserController {
    ResponseEntity<List<UserDTO>> findAll();
    ResponseEntity<UserDTO> find(long id);
    String getAll(Model model);
}
