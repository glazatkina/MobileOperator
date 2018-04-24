package ru.tsystems.javaschool.mobile_operator.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.ContractTariffDAO;
import ru.tsystems.javaschool.mobile_operator.entity.Contract;
import ru.tsystems.javaschool.mobile_operator.entity.ContractTariff;

import java.util.List;

@Repository
public class ContractTariffDAOImpl implements ContractTariffDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public ContractTariffDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS,
            readOnly = true)
    @SuppressWarnings("unchecked")
    public List<ContractTariff> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from ContractTariff ct")
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS,
            readOnly = true)
    public ContractTariff findById(long id) {
        return sessionFactory.getCurrentSession()
                .get(ContractTariff.class, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public List<ContractTariff> findAllByContract(Contract contract) {
        return sessionFactory.getCurrentSession()
                .createQuery("select ct from ContractTariff ct where contractTariffsById=?1")
                .setParameter(1, contract)
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void save(ContractTariff contractTariff) {
        sessionFactory.getCurrentSession().persist(contractTariff);
    }
}
