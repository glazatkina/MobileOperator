package ru.tsystems.javaschool.mobile_operator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.MeasureDAO;
import ru.tsystems.javaschool.mobile_operator.entity.Measure;
import ru.tsystems.javaschool.mobile_operator.service.MeasureService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MeasureServiceImpl implements MeasureService {
    private MeasureDAO measureDAO;

    @Autowired
    public MeasureServiceImpl(MeasureDAO measureDAO) {
        this.measureDAO = measureDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public List<Measure> findAll() {
        return measureDAO.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public Measure find(String name) {
        Measure measure = measureDAO.findByName(name);
        if (measure == null) {
            throw new EntityNotFoundException("Measure " + name + " not found.");
        }
        return measure;
    }
}
