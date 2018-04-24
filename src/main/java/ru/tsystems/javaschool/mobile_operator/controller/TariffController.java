package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.ui.Model;
import ru.tsystems.javaschool.mobile_operator.dto.TariffDTO;
import ru.tsystems.javaschool.mobile_operator.entity.Tariff;

public interface TariffController {
    String findAll(Model model);
    String findByName(String name, Model model);
    String save(TariffDTO tariffDTO, Model model);
    String closeTariff(TariffDTO tariffDTO, Model model);
}
