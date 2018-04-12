package ru.tsystems.javaschool.mobile_operator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.ContractDAO;
import ru.tsystems.javaschool.mobile_operator.entity.Contract;
import ru.tsystems.javaschool.mobile_operator.service.ContractService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

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
    public List<Contract> findAll() {
        return contractDAO.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public Contract find(String phoneNumber) {
        Contract contract = contractDAO.findByPhoneNumber(phoneNumber);
        if (contract == null) {
            throw new EntityNotFoundException("Contract " + phoneNumber + " not found");
        }
        return contract;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void save(Contract contract) {
        if (contractDAO.isExists(contract.getPhoneNumber())) {
            throw new EntityExistsException("Contract " + contract.getPhoneNumber() + " is already exist");
        }
        contractDAO.save(contract);
    }

    @Override
    public void closeContract(String phoneNumber) {
        //??? надо сохранять и дату, и изменять поле is_active
    }

    @Override
    public int getBalance(Contract contract) {
        return 0;
    }
}
