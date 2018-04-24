package ru.tsystems.javaschool.mobile_operator.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import ru.tsystems.javaschool.mobile_operator.dto.UserDTO;

import java.util.List;

public interface UserRestController {
    ResponseEntity<List<UserDTO>> findAll();
    ResponseEntity<UserDTO> find(long id);
}
