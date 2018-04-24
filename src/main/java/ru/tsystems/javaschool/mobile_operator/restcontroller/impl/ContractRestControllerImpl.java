package ru.tsystems.javaschool.mobile_operator.restcontroller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.javaschool.mobile_operator.dto.ContractDTO;
import ru.tsystems.javaschool.mobile_operator.restcontroller.ContractRestController;
import ru.tsystems.javaschool.mobile_operator.service.ContractService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/rest_contracts")
public class ContractRestControllerImpl implements ContractRestController {

    private ContractService service;

    @Autowired
    public ContractRestControllerImpl(ContractService contractService) {
        this.service = contractService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ContractDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/find_contract")
    public ResponseEntity<ContractDTO> find(@RequestParam String phoneNumber) {
        try {
            return new ResponseEntity<>(service.find(phoneNumber), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ContractDTO contract) {
        try {
            service.save(contract);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EntityExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Void> closeContract(ContractDTO contract) {
        try {
            service.closeContract(contract.getPhoneNumber());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{phoneNumber}/balance")
    public ResponseEntity<Void> getBalance(@PathVariable String phoneNumber) {
        try {
            service.getBalance(service.find(phoneNumber));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
