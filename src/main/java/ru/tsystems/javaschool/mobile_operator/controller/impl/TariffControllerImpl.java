package ru.tsystems.javaschool.mobile_operator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.javaschool.mobile_operator.controller.TariffController;
import ru.tsystems.javaschool.mobile_operator.dto.TariffDTO;
import ru.tsystems.javaschool.mobile_operator.service.TariffService;

@Controller
@RequestMapping("/tariffs")
public class TariffControllerImpl implements TariffController {
    private TariffService service;

    @Autowired
    public TariffControllerImpl(TariffService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("tariffs", service.findAll());
        return "tariffs";
    }

    @Override
    public String findByName(String name, Model model) {
        return null;
    }

    @Override
    public String save(TariffDTO tariffDTO, Model model) {
        return null;
    }

    @Override
    public String closeTariff(TariffDTO tariffDTO, Model model) {
        return null;
    }
}
