package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.javaschool.mobile_operator.dto.UserDTO;
import ru.tsystems.javaschool.mobile_operator.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private UserService service;

    @Autowired
    public RegistrationController(UserService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(UserDTO userDTO, Model model) {
//        service.register(userDTO);
        return userDTO.getEmail();
//        return "operation_success";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model) {
        return "register";
    }
}
