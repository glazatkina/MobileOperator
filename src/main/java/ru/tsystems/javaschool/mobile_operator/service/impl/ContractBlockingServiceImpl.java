package ru.tsystems.javaschool.mobile_operator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.ContractBlockingDAO;
import ru.tsystems.javaschool.mobile_operator.dto.ContractBlockingDTO;
import ru.tsystems.javaschool.mobile_operator.entity.Contract;
import ru.tsystems.javaschool.mobile_operator.entity.ContractBlocking;
import ru.tsystems.javaschool.mobile_operator.service.ContractBlockingService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractBlockingServiceImpl implements ContractBlockingService {
    private ContractBlockingDAO contractBlockingDAO;

    @Autowired
    public ContractBlockingServiceImpl(ContractBlockingDAO contractBlockingDAO) {
        this.contractBlockingDAO = contractBlockingDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public List<ContractBlockingDTO> findAll() {
        List<ContractBlocking> contractBlockings = contractBlockingDAO.findAll();
        List<ContractBlockingDTO> contractBlockingDTOS = new ArrayList<>();
        for (ContractBlocking blocking: contractBlockings) {
            ContractBlockingDTO contractBlockingDTO = new ContractBlockingDTO(blocking);
            contractBlockingDTO.fill(blocking.getBlockedContract(), blocking.getBlockingUser());
            contractBlockingDTOS.add(contractBlockingDTO);
        }
        return contractBlockingDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public List<ContractBlockingDTO> findAllByContract(Contract contract) {
        List<ContractBlocking> contractBlockings = contractBlockingDAO.findAllByContract(contract);
        List<ContractBlockingDTO> contractBlockingDTOS = new ArrayList<>();
        for (ContractBlocking blocking: contractBlockings) {
            ContractBlockingDTO contractBlockingDTO = new ContractBlockingDTO(blocking);
            contractBlockingDTO.fill(blocking.getBlockedContract(), blocking.getBlockingUser());
            contractBlockingDTOS.add(contractBlockingDTO);
        }
        return contractBlockingDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public ContractBlockingDTO findById(long id) {
        ContractBlocking contractBlocking = contractBlockingDAO.findById(id);
        if (contractBlocking == null) {
            throw new EntityNotFoundException("Contract block " + id + " not found");
        }
        ContractBlockingDTO contractBlockingDTO = new ContractBlockingDTO(contractBlocking);
        contractBlockingDTO.fill(contractBlocking.getBlockedContract(), contractBlocking.getBlockingUser());
        return contractBlockingDTO;
    }

    @Override
    public void save(ContractBlockingDTO contractBlockingDTO) {
        contractBlockingDAO.save(contractBlockingDTO.toEntity());
    }
}
