package ru.tsystems.javaschool.mobile_operator.restcontroller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tsystems.javaschool.mobile_operator.dto.TypeUserDTO;
import ru.tsystems.javaschool.mobile_operator.restcontroller.TypeUserRestController;
import ru.tsystems.javaschool.mobile_operator.service.TypeUserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/rest_type_users")
public class TypeUserRestControllerImpl implements TypeUserRestController {
    private TypeUserService service;

    @Autowired
    public TypeUserRestControllerImpl(TypeUserService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<TypeUserDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{name}")
    public ResponseEntity<TypeUserDTO> find(@PathVariable String name) {
        try {
            return new ResponseEntity<>(service.find(name), HttpStatus.OK);
        }catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
