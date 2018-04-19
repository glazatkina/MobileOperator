package ru.tsystems.javaschool.mobile_operator.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.MeasureDAO;
import ru.tsystems.javaschool.mobile_operator.entity.Measure;

import java.util.List;

@Repository
public class MeasureDAOImpl implements MeasureDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public MeasureDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public List<Measure> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Measure")
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public Measure findById(long id) {
        return sessionFactory.getCurrentSession()
                .get(Measure.class, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public Measure findByName(String name) {
        return (Measure) sessionFactory.getCurrentSession()
                .createQuery("from Measure measure where measure.name = ?1")
                .setParameter(1, name)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public boolean isExists(String name) {
        return sessionFactory.getCurrentSession()
                .createQuery("select measure.name from Measure measure where measure.name = ?1")
                .setParameter(1, name)
                .stream()
                .anyMatch(measure -> true);
    }
}
