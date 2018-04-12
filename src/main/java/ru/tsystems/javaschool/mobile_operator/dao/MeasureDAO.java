package ru.tsystems.javaschool.mobile_operator.dao;

import ru.tsystems.javaschool.mobile_operator.entity.Measure;

import java.util.List;

public interface MeasureDAO {
    List<Measure> findAll();
    Measure findById(long id);
    Measure findByName(String name);
    boolean isExists(String name);
}
