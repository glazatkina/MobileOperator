package ru.tsystems.javaschool.mobile_operator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.javaschool.mobile_operator.controller.ContractController;
import ru.tsystems.javaschool.mobile_operator.dto.ContractDTO;
import ru.tsystems.javaschool.mobile_operator.service.ContractService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/contracts")
public class ContractControllerImpl implements ContractController {

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

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "{phoneNumber}")
    public String findByPhoneNumber(@PathVariable String phoneNumber, Model model) {
        try {
            model.addAttribute("contract", service.find(phoneNumber));
            return "contract";
        } catch (EntityNotFoundException e) {
            return "not_found";
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestBody ContractDTO contract, Model model) {
        try {
            service.save(contract);
            return "operation_success";
        } catch (EntityExistsException e) {
            return "operation_fail";
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public String lockContract(ContractDTO contract, Model model) {
        try {
            service.closeContract(contract.getPhoneNumber());
            return "operation_success";
        } catch (EntityNotFoundException e) {
            return "operation_fail";
        }
    }
}
