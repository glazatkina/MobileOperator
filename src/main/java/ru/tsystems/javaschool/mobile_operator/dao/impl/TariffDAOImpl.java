package ru.tsystems.javaschool.mobile_operator.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tsystems.javaschool.mobile_operator.dao.TariffDAO;
import ru.tsystems.javaschool.mobile_operator.entity.Tariff;

import java.util.List;

@Repository
public class TariffDAOImpl  implements TariffDAO {
    private SessionFactory sessionFactory;
    @Autowired
    public TariffDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Tariff> findAll() {
        return null;
    }

    @Override
    public Tariff findById(long id) {
        return null;
    }

    @Override
    public Tariff findByName(String name) {
        return null;
    }

    @Override
    public boolean isExists(String name) {
        return false;
    }

    @Override
    public boolean isActive(String name) {
        return false;
    }

    @Override
    public void save(Tariff contract) {

    }
}
