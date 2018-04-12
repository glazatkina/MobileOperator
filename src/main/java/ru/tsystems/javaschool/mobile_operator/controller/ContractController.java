package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.http.ResponseEntity;
import ru.tsystems.javaschool.mobile_operator.entity.Contract;

import java.util.List;

public interface ContractController {
    ResponseEntity<List<Contract>> findAll();
    ResponseEntity<Contract> find(String phoneNumber);
    ResponseEntity<Void> save(Contract contract);
    ResponseEntity<Void> closeContract(Contract contract);
    ResponseEntity<Void> getBalance(String phoneNumber);
}
