package ru.tsystems.javaschool.mobile_operator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tsystems.javaschool.mobile_operator.controller.TariffOptionController;
import ru.tsystems.javaschool.mobile_operator.dto.TariffOptionDTO;
import ru.tsystems.javaschool.mobile_operator.service.TariffOptionService;

import java.util.List;

@Controller
@RequestMapping("/tariff_options")
public class TariffOptionControllerImpl implements TariffOptionController {
    private TariffOptionService service;

    @Autowired
    public TariffOptionControllerImpl(TariffOptionService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        List<TariffOptionDTO> tariffOptionDTOList = service.findAll();
        model.addAttribute("tariff_options", tariffOptionDTOList);
        return "tariff_options";
    }

    @Override
    public String findByName(String name, Model model) {
        return null;
    }

    @Override
    public String save(TariffOptionDTO tariffOptionDTO, Model model) {
        return null;
    }
}
