package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.http.ResponseEntity;
import ru.tsystems.javaschool.mobile_operator.dto.TypeUserDTO;
import ru.tsystems.javaschool.mobile_operator.entity.TypeUser;

import java.util.List;

public interface TypeUserController {
    ResponseEntity<List<TypeUserDTO>> findAll();
    ResponseEntity<TypeUserDTO> find(String name);
}
