package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.ui.Model;
import ru.tsystems.javaschool.mobile_operator.dto.TariffOptionDTO;

public interface TariffOptionController {
    String findAll(Model model);
    String findByName(String name, Model model);
    String save(TariffOptionDTO tariffOptionDTO, Model model);
//    String closeTariff(TariffDTO tariffDTO, Model model);
}
