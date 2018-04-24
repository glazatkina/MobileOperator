package ru.tsystems.javaschool.mobile_operator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.javaschool.mobile_operator.controller.UserController;
import ru.tsystems.javaschool.mobile_operator.dto.UserDTO;
import ru.tsystems.javaschool.mobile_operator.entity.User;
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
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        List<UserDTO> userDTOS = service.findAll();
        model.addAttribute("users", userDTOS);
        return "users";
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public String findById(@PathVariable long id, Model model) {
        UserDTO userDTO = service.find(id);
        if (userDTO != null) {
            model.addAttribute("user", userDTO);
            return "user";
        }
        return "not_found";
    }
}
