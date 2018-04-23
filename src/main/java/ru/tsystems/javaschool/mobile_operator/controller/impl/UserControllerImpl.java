package ru.tsystems.javaschool.mobile_operator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.javaschool.mobile_operator.controller.UserController;
import ru.tsystems.javaschool.mobile_operator.dto.UserDTO;
import ru.tsystems.javaschool.mobile_operator.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserControllerImpl implements UserController {
    private UserService service;

    @Autowired
    public UserControllerImpl(UserService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Override
//    @GetMapping("{id}")
    public ResponseEntity<UserDTO> find(@PathVariable long id) {
        try {
            return new ResponseEntity<>(service.find(id), HttpStatus.OK);
        }catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        List<UserDTO> userDTOS = service.findAll();
        model.addAttribute("users", userDTOS);
        return "users";
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public String getById(@PathVariable long id, Model model) {
        UserDTO userDTO = service.find(id);
        if (userDTO != null) {
            model.addAttribute("user", userDTO);
            return "user";
        }
        return "not_found";
    }
}
