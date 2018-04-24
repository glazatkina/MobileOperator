package ru.tsystems.javaschool.mobile_operator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.javaschool.mobile_operator.controller.ContractBlockingController;
import ru.tsystems.javaschool.mobile_operator.dto.ContractBlockingDTO;
import ru.tsystems.javaschool.mobile_operator.service.ContractBlockingService;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/contract_blockings")
public class ContractBlockingControllerImpl implements ContractBlockingController {
    private ContractBlockingService service;

    @Autowired
    public ContractBlockingControllerImpl(ContractBlockingService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("blockings", service.findAll());
        return "contract_blockings";
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public String findById(@PathVariable long id, Model model) {
        try {
            model.addAttribute("block", service.findById(id));
            return "block";
        } catch (EntityNotFoundException e) {
            return "not_found";
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestBody ContractBlockingDTO contractBlockingDTO, Model model) {
        try {
            service.save(contractBlockingDTO);
            return "operation_success";
        } catch (EntityNotFoundException e) {
            return "operation_fail";
        }
    }
}
