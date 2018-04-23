package ru.tsystems.javaschool.mobile_operator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.javaschool.mobile_operator.controller.ContractController;
import ru.tsystems.javaschool.mobile_operator.dto.ContractDTO;
import ru.tsystems.javaschool.mobile_operator.service.ContractService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractControllerImpl {

    private ContractService service;

    @Autowired
    public ContractControllerImpl(ContractService contractService) {
        this.service = contractService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("contracts", service.findAll());
        return "contracts";
    }

    @RequestMapping(method = RequestMethod.GET, path = "{phoneNumber}")
    public String find(@PathVariable String phoneNumber, Model model) {
        try {
            model.addAttribute("contract", service.find(phoneNumber));
            return "contract";
        } catch (EntityNotFoundException e) {
            return "not_found";
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
