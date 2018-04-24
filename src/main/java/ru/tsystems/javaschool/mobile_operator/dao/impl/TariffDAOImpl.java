package ru.tsystems.javaschool.mobile_operator.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS,
            readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Tariff> findAll() {
         return sessionFactory.getCurrentSession()
                .createQuery("from Tariff")
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS,
            readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Tariff> findAllActive() {
        return sessionFactory.getCurrentSession()
                .createQuery("select t from Tariff t where t.active=true")
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS,
            readOnly = true)
    public Tariff findById(long id) {
        return sessionFactory.getCurrentSession()
                .get(Tariff.class, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public Tariff findByName(String name) {
        return (Tariff) sessionFactory.getCurrentSession()
                .createQuery("from Tariff tariff where tariff.name = ?1")
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
                .createQuery("select tariff.active from Tariff tariff " +
                        "where tariff.name = ?1")
                .setParameter(1, name)
                .stream()
                .anyMatch(tariff -> true);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public boolean isActive(String name) {
        return sessionFactory.getCurrentSession()
                .createQuery("select tariff.active from Tariff tariff " +
                        "where tariff.name = ?1")
                .setParameter(1, name)
                .stream()
                .anyMatch(active -> active.equals(true));
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void save(Tariff tariff) {
        sessionFactory.getCurrentSession().persist(tariff);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void closeTariff(long id) {
        sessionFactory.getCurrentSession()
                .createQuery("update Tariff tariff set tariff.active=false where tariff.id=?1")
                .setParameter(1, id)
                .executeUpdate();
    }
}
