package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.http.ResponseEntity;
import ru.tsystems.javaschool.mobile_operator.entity.Measure;

import java.util.List;

public interface MeasureController {
    ResponseEntity<List<Measure>> findAll();
    ResponseEntity<Measure> find(String name);
}
