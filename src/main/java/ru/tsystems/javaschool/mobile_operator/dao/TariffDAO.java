package ru.tsystems.javaschool.mobile_operator.dao;

import ru.tsystems.javaschool.mobile_operator.entity.Tariff;

import java.util.List;

public interface TariffDAO {
    List<Tariff> findAll();
    List<Tariff> findAllActive();
    Tariff findById(long id);
    Tariff findByName(String name);
    boolean isExists(String name);
    boolean isActive(String name);
    void save(Tariff tariff);
    void closeTariff(long id);
}
