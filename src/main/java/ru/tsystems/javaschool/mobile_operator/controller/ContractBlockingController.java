package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.ui.Model;
import ru.tsystems.javaschool.mobile_operator.dto.ContractBlockingDTO;

public interface ContractBlockingController {
    String findAll(Model model);
//    String findAllByContract(, Model model);
    String findById(long id, Model model);
    String save(ContractBlockingDTO contractBlockingDTO, Model model);
}

