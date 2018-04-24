package ru.tsystems.javaschool.mobile_operator.restcontroller;

import org.springframework.http.ResponseEntity;
import ru.tsystems.javaschool.mobile_operator.entity.Measure;

import java.util.List;

public interface MeasureRestController {
    ResponseEntity<List<Measure>> findAll();
    ResponseEntity<Measure> find(String name);
}
