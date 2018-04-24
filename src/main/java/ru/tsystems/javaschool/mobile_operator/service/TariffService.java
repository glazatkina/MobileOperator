package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.dto.TariffDTO;

import java.util.List;

public interface TariffService {
    List<TariffDTO> findAll();
    List<TariffDTO> findAllActive();
    TariffDTO findById(long id);
    TariffDTO findByName(String name);
    void save(TariffDTO tariffDTO);
    void closeTariff(long id);
}