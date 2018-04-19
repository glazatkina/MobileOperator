package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.http.ResponseEntity;
import ru.tsystems.javaschool.mobile_operator.dto.ContractDTO;
import ru.tsystems.javaschool.mobile_operator.entity.Contract;

import java.util.List;

public interface ContractController {
    ResponseEntity<List<ContractDTO>> findAll();
    ResponseEntity<ContractDTO> find(String phoneNumber);
    ResponseEntity<Void> save(ContractDTO contract);
    ResponseEntity<Void> closeContract(ContractDTO contract);
    ResponseEntity<Void> getBalance(String phoneNumber);
}
