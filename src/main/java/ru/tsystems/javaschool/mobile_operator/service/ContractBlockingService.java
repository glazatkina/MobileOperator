package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.dto.ContractBlockingDTO;
import ru.tsystems.javaschool.mobile_operator.entity.Contract;

import java.util.List;

public interface ContractBlockingService {
    List<ContractBlockingDTO> findAll();
    List<ContractBlockingDTO> findAllByContract(Contract contract);
    ContractBlockingDTO findById(long id);
    void save(ContractBlockingDTO contractBlockingDTO);
}
