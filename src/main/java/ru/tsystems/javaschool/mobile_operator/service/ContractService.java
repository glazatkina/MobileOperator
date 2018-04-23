package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.dto.ContractDTO;

import java.util.List;

public interface ContractService {
    List<ContractDTO> findAll();
    ContractDTO find(String phoneNumber);
    void save(ContractDTO contract);
    void closeContract(String phoneNumber);
    long getBalance(ContractDTO contract);
}
