package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import ru.tsystems.javaschool.mobile_operator.entity.Measure;

import java.util.List;

public interface MeasureController {
    String findAll(Model model);
    String find(String name, Model model);
}
