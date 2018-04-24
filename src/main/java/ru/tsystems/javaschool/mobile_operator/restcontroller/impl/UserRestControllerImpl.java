package ru.tsystems.javaschool.mobile_operator.restcontroller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.javaschool.mobile_operator.dto.UserDTO;
import ru.tsystems.javaschool.mobile_operator.restcontroller.UserRestController;
import ru.tsystems.javaschool.mobile_operator.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/rest_users")
public class UserRestControllerImpl implements UserRestController {
    private UserService service;

    @Autowired
    public UserRestControllerImpl(UserService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> find(@PathVariable long id) {
        try {
            return new ResponseEntity<>(service.find(id), HttpStatus.OK);
        }catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
