package ru.tsystems.javaschool.mobile_operator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.OptionDAO;
import ru.tsystems.javaschool.mobile_operator.dto.OptionDTO;
import ru.tsystems.javaschool.mobile_operator.entity.Option;
import ru.tsystems.javaschool.mobile_operator.service.OptionService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    private OptionDAO optionDAO;

    @Autowired
    public OptionServiceImpl(OptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }


    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public List<OptionDTO> findAll() {
        List<Option> options = optionDAO.findAll();
        List<OptionDTO> optionDTOS = new ArrayList<>();
        for (Option option: options) {
            OptionDTO optionDTO = new OptionDTO(option);
            optionDTO.fill(option.getMeasure(), option.getDependentOptions());
            optionDTOS.add(optionDTO);
        }
        return optionDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public OptionDTO findById(long id) {
        Option option = optionDAO.findById(id);
        if (option == null) {
            throw new EntityNotFoundException("Option " + id + " not found");
        }
        OptionDTO optionDTO = new OptionDTO(option);
        optionDTO.fill(option.getMeasure(), option.getDependentOptions());
        return optionDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public OptionDTO findByName(String name) {
        Option option = optionDAO.findByName(name);
        if (option == null) {
            throw new EntityNotFoundException("Option " + name + " not found");
        }
        OptionDTO optionDTO = new OptionDTO(option);
        optionDTO.fill(option.getMeasure(), option.getDependentOptions());
        return optionDTO;    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public boolean isExists(String name) {
        return optionDAO.isExists(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void save(OptionDTO option) {
        if (optionDAO.isExists(option.getName())) {
            throw new EntityExistsException("Contract " + option.getName() + " is already exist");
        }
        Option option1 = option.toEntity();
        optionDAO.save(option1);
    }
}
