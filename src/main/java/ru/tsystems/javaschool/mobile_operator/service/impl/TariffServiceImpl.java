package ru.tsystems.javaschool.mobile_operator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.TariffDAO;
import ru.tsystems.javaschool.mobile_operator.dto.TariffDTO;
import ru.tsystems.javaschool.mobile_operator.entity.Tariff;
import ru.tsystems.javaschool.mobile_operator.service.TariffService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {
    private TariffDAO tariffDAO;

    @Autowired
    public TariffServiceImpl(TariffDAO tariffDAO) {
        this.tariffDAO = tariffDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public List<TariffDTO> findAll() {
        List<Tariff> tariffs = tariffDAO.findAll();
        List<TariffDTO> tariffDTOS = new ArrayList<>();
        for (Tariff tariff: tariffs) {
            tariffDTOS.add(new TariffDTO(tariff));
        }
        return tariffDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public List<TariffDTO> findAllActive() {
        List<Tariff> tariffs = tariffDAO.findAllActive();
        List<TariffDTO> tariffDTOS = new ArrayList<>();
        for (Tariff tariff: tariffs) {
            tariffDTOS.add(new TariffDTO(tariff));
        }
        return tariffDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public TariffDTO findById(long id) {
        Tariff tariff = tariffDAO.findById(id);
        if (tariff == null) {
            throw new EntityNotFoundException("Tariff " + id + " not found");
        }
        return new TariffDTO(tariff);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public TariffDTO findByName(String name) {
        Tariff tariff = tariffDAO.findByName(name);
        if (tariff == null) {
            throw new EntityNotFoundException("Tariff " + name + " not found");
        }
        return new TariffDTO(tariff);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void save(TariffDTO tariffDTO) {
        if (tariffDAO.isExists(tariffDTO.getName())) {
            throw new EntityExistsException("Tariff " + tariffDTO.getName() + " is already exist");
        }
        Tariff tariff = tariffDTO.toEntity();
        tariffDAO.save(tariff);
    }

    @Override
    public void closeTariff(long id) {
        //todo
    }
}
