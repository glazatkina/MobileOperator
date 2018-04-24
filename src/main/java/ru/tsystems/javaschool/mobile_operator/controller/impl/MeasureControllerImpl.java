package ru.tsystems.javaschool.mobile_operator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tsystems.javaschool.mobile_operator.entity.Measure;
import ru.tsystems.javaschool.mobile_operator.controller.MeasureController;
import ru.tsystems.javaschool.mobile_operator.service.MeasureService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/measures")
public class MeasureControllerImpl implements MeasureController {

    private MeasureService measureService;

    @Autowired
    public MeasureControllerImpl(MeasureService measureService) {
        this.measureService = measureService;
    }

    @GetMapping
    public ResponseEntity<List<Measure>> findAll() {
        return new ResponseEntity<>(measureService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Measure> find(@PathVariable String name) {
        try {
            return new ResponseEntity<>(measureService.find(name), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String findAll(Model model) {
        return null;
    }

    @Override
    public String find(String name, Model model) {
        return null;
    }
}
