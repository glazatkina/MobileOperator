package ru.tsystems.javaschool.mobile_operator.dao;

import ru.tsystems.javaschool.mobile_operator.entity.Contract;
import ru.tsystems.javaschool.mobile_operator.entity.ContractTariff;
import ru.tsystems.javaschool.mobile_operator.entity.Tariff;

import java.util.List;

public interface ContractTariffDAO {
    List<ContractTariff> findAll();
    ContractTariff findById(long id);
    List<ContractTariff> findAllByContract(Contract contract);
    void save(ContractTariff contractTariff);
}
