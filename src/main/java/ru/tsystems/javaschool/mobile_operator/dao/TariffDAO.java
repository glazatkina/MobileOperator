package ru.tsystems.javaschool.mobile_operator.dao;

import ru.tsystems.javaschool.mobile_operator.entity.Tariff;

import java.util.List;

public interface TariffDAO {
    List<Tariff> findAll();
    Tariff findById(long id);
    Tariff findByName(String name);
    boolean isExists(String name);
    boolean isActive(String name);
    void save(Tariff contract);
}
