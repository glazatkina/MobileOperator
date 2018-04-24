package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.ui.Model;
import ru.tsystems.javaschool.mobile_operator.dto.OptionDTO;

public interface OptionController {
    String findAll(Model model);
    String findById(long id, Model model);
    String save(OptionDTO optionDTO, Model model);
}
