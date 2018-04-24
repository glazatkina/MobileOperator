package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.dto.TariffOptionDTO;
import ru.tsystems.javaschool.mobile_operator.entity.Tariff;

import java.util.List;

public interface TariffOptionService {
    List<TariffOptionDTO> findAll();
    TariffOptionDTO findById(long id);
    List<TariffOptionDTO> findAllByTariff(Tariff tariff);
    void save(TariffOptionDTO tariffOption);
}
