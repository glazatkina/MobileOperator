package ru.tsystems.javaschool.mobile_operator.restcontroller;

import org.springframework.http.ResponseEntity;
import ru.tsystems.javaschool.mobile_operator.dto.TypeUserDTO;

import java.util.List;

public interface TypeUserRestController {
    ResponseEntity<List<TypeUserDTO>> findAll();
    ResponseEntity<TypeUserDTO> find(String name);
}
