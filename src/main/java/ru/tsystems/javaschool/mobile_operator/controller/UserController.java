package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import ru.tsystems.javaschool.mobile_operator.dto.UserDTO;

import java.util.List;

public interface UserController {
    String findAll(Model model);
    String findById(long id, Model model);
}
