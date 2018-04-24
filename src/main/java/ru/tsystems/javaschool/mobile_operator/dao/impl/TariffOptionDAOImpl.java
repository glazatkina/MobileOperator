package ru.tsystems.javaschool.mobile_operator.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.TariffOptionDAO;
import ru.tsystems.javaschool.mobile_operator.entity.Tariff;
import ru.tsystems.javaschool.mobile_operator.entity.TariffOption;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TariffOptionDAOImpl implements TariffOptionDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public TariffOptionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public List<TariffOption> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from TariffOption")
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public TariffOption findById(long id) {
        return (TariffOption) sessionFactory.getCurrentSession()
                .createQuery("select t from TariffOption t where t.id=?1")
                .setParameter(1, id)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public List<TariffOption> findAllByTariff(Tariff tariff) {
        return sessionFactory.getCurrentSession()
                .createQuery("select t from TariffOption t where t.tariffByTariffId.id=?1")
                .setParameter(1, tariff.getId())
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void save(TariffOption tariffOption) {
        sessionFactory.getCurrentSession().persist(tariffOption);
    }
}
