package ru.tsystems.javaschool.mobile_operator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.TariffOptionDAO;
import ru.tsystems.javaschool.mobile_operator.dto.TariffOptionDTO;
import ru.tsystems.javaschool.mobile_operator.entity.Tariff;
import ru.tsystems.javaschool.mobile_operator.entity.TariffOption;
import ru.tsystems.javaschool.mobile_operator.service.TariffOptionService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TariffOptionServiceImpl implements TariffOptionService {
    private TariffOptionDAO tariffOptionDAO;

    @Autowired
    public TariffOptionServiceImpl(TariffOptionDAO tariffOptionDAO) {
        this.tariffOptionDAO = tariffOptionDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public List<TariffOptionDTO> findAll() {
        List<TariffOption> tariffOptions = tariffOptionDAO.findAll();
        List<TariffOptionDTO> result = new ArrayList<>();
        for (TariffOption to: tariffOptions) {
            TariffOptionDTO dto = new TariffOptionDTO(to);
//            dto.fill(to.getTariffByTariffId(), to.getOptionByOptionId());
            result.add(dto);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public TariffOptionDTO findById(long id) {
        TariffOption tariffOption = tariffOptionDAO.findById(id);
        if (tariffOption == null) {
            throw new EntityNotFoundException("TariffOption " + id + " not found");
        }
        TariffOptionDTO dto = new TariffOptionDTO(tariffOption);
        dto.fill(tariffOption.getTariffByTariffId(), tariffOption.getOptionByOptionId());
        return dto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public List<TariffOptionDTO> findAllByTariff(Tariff tariff) {
        List<TariffOption> tariffOptions = tariffOptionDAO.findAllByTariff(tariff);
        List<TariffOptionDTO> result = new ArrayList<>();
        for (TariffOption to: tariffOptions) {
            TariffOptionDTO dto = new TariffOptionDTO(to);
//            dto.fill(to.getTariffByTariffId(), to.getOptionByOptionId());
            result.add(dto);
        }
        return result;
    }

    @Override
    public void save(TariffOptionDTO tariffOption) {
        TariffOption tariffOption1 = tariffOption.toEntity();
        tariffOptionDAO.save(tariffOption1);
    }
}
