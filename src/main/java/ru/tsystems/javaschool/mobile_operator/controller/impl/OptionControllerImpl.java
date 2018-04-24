package ru.tsystems.javaschool.mobile_operator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.javaschool.mobile_operator.controller.OptionController;
import ru.tsystems.javaschool.mobile_operator.dto.OptionDTO;
import ru.tsystems.javaschool.mobile_operator.service.OptionService;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/options")
public class OptionControllerImpl implements OptionController {
    private OptionService service;

    @Autowired
    public OptionControllerImpl(OptionService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("options", service.findAll());
        return "options";
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public String findById(@PathVariable long id, Model model) {
        try {
            model.addAttribute("option", service.findById(id));
            return "option";
        } catch (EntityNotFoundException e) {
            return "not_found";
        }
    }

    @Override
    public String save(OptionDTO optionDTO, Model model) {
        return null;
    }
}
