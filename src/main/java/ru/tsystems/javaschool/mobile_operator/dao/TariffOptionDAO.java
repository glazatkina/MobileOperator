package ru.tsystems.javaschool.mobile_operator.dao;

import ru.tsystems.javaschool.mobile_operator.entity.Tariff;
import ru.tsystems.javaschool.mobile_operator.entity.TariffOption;

import java.util.List;

public interface TariffOptionDAO {
    List<TariffOption> findAll();
    TariffOption findById(long id);
    List<TariffOption> findAllByTariff(Tariff tariff);
    void save(TariffOption tariffOption);
}
