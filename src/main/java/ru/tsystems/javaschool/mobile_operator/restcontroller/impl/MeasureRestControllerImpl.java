package ru.tsystems.javaschool.mobile_operator.restcontroller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tsystems.javaschool.mobile_operator.entity.Measure;
import ru.tsystems.javaschool.mobile_operator.restcontroller.MeasureRestController;
import ru.tsystems.javaschool.mobile_operator.service.MeasureService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/rest_measures")
public class MeasureRestControllerImpl implements MeasureRestController {

    private MeasureService measureService;

    @Autowired
    public MeasureRestControllerImpl(MeasureService measureService) {
        this.measureService = measureService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Measure>> findAll() {
        return new ResponseEntity<>(measureService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{name}")
    public ResponseEntity<Measure> find(@PathVariable String name) {
        try {
            return new ResponseEntity<>(measureService.find(name), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
