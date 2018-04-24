package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import ru.tsystems.javaschool.mobile_operator.dto.TypeUserDTO;

import java.util.List;

public interface TypeUserController {
    String findAll(Model model);
    String find(String name, Model model);
}
