package ru.tsystems.javaschool.mobile_operator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tsystems.javaschool.mobile_operator.controller.TypeUserController;
import ru.tsystems.javaschool.mobile_operator.dto.TypeUserDTO;
import ru.tsystems.javaschool.mobile_operator.service.TypeUserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/type_users")
public class TypeUserControllerImpl implements TypeUserController {
    private TypeUserService service;

    @Autowired
    public TypeUserControllerImpl(TypeUserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TypeUserDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TypeUserDTO> find(@PathVariable String name) {
        try {
            return new ResponseEntity<>(service.find(name), HttpStatus.OK);
        }catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String findAll(Model model) {
        return null;
    }

    @Override
    public String find(String name, Model model) {
        return null;
    }
}
