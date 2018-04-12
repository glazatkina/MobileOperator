package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.entity.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    Contract find(String phoneNumber);
    void save(Contract contract);
    void closeContract(String phoneNumber);
    int getBalance(Contract contract);
}
