package ru.tsystems.javaschool.mobile_operator.restcontroller;

import org.springframework.http.ResponseEntity;
import ru.tsystems.javaschool.mobile_operator.dto.ContractDTO;

import java.util.List;

public interface ContractRestController {
    ResponseEntity<List<ContractDTO>> findAll();
    ResponseEntity<ContractDTO> find(String phoneNumber);
    ResponseEntity<Void> save(ContractDTO contract);
    ResponseEntity<Void> closeContract(ContractDTO contract);
    ResponseEntity<Void> getBalance(String phoneNumber);
}
