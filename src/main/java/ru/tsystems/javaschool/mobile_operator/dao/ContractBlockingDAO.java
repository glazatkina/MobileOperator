package ru.tsystems.javaschool.mobile_operator.dao;

import ru.tsystems.javaschool.mobile_operator.entity.Contract;
import ru.tsystems.javaschool.mobile_operator.entity.ContractBlocking;

import java.util.List;

public interface ContractBlockingDAO {
    List<ContractBlocking> findAll();
    List<ContractBlocking> findAllByContract(Contract contract);
    ContractBlocking findById(long id);
    void save(ContractBlocking contractBlocking);
}
