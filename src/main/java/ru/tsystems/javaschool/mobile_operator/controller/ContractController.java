package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import ru.tsystems.javaschool.mobile_operator.dto.ContractDTO;

import javax.jws.WebParam;
import java.util.List;

public interface ContractController {
    String findAll(Model model);
    String findByPhoneNumber(String phoneNumber, Model model);
    String save(ContractDTO contract, Model model);
    String lockContract(ContractDTO contract, Model model);
}
