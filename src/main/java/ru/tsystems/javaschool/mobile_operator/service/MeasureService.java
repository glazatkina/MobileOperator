package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.entity.Measure;

import java.util.List;

public interface MeasureService {
    List<Measure> findAll();
    Measure find(String name);
}
