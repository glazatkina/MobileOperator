package ru.tsystems.javaschool.mobile_operator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.ContractDAO;
import ru.tsystems.javaschool.mobile_operator.dto.ContractDTO;
import ru.tsystems.javaschool.mobile_operator.entity.Contract;
import ru.tsystems.javaschool.mobile_operator.service.ContractService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl implements ContractService {
    private ContractDAO contractDAO;

    @Autowired
    public ContractServiceImpl(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public List<ContractDTO> findAll() {
        List<Contract> contracts = contractDAO.findAll();
        List<ContractDTO> contractDTOS = new ArrayList<>();
        for (Contract contract: contracts) {
            ContractDTO contractDTO = new ContractDTO(contract);
            contractDTO.fill(contract.getCustomer());
            contractDTOS.add(contractDTO);
        }
        return contractDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public ContractDTO find(String phoneNumber) {
        Contract contract = contractDAO.findByPhoneNumber(phoneNumber);
        if (contract == null) {
            throw new EntityNotFoundException("Contract " + phoneNumber + " not found");
        }
        ContractDTO contractDTO = new ContractDTO(contract);
        contractDTO.fill(contract.getCustomer());
        return contractDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void save(ContractDTO contract) {
        if (contractDAO.isExists(contract.getPhoneNumber())) {
            throw new EntityExistsException("Contract " + contract.getPhoneNumber() + " is already exist");
        }
        Contract contract1 = contract.toEntity();
        contractDAO.save(contract1);
    }

    @Override
    public void closeContract(String phoneNumber) {
        //??? надо сохранять и дату, и изменять поле is_active
    }

    @Override
    public long getBalance(ContractDTO contract) {
        return contract.getBalance();
    }
}
