package ru.tsystems.javaschool.mobile_operator.dao.impl;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.ContractDAO;
import ru.tsystems.javaschool.mobile_operator.entity.Contract;

import java.util.List;

@Repository
public class ContractDAOImpl implements ContractDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public ContractDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public List<Contract> findAll() {
        List<Contract> contracts = sessionFactory.getCurrentSession()
                .createQuery("select c from Contract c join fetch c.customer u")
                .list();
        for (Contract c : contracts) {
            if (!Hibernate.isInitialized(c.getCustomer()))
                Hibernate.initialize(c.getCustomer());
        }
        return contracts;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public Contract findById(long id) {
        return sessionFactory.getCurrentSession()
                .get(Contract.class, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public Contract findByPhoneNumber(String phoneNumber) {
        return (Contract) sessionFactory.getCurrentSession()
                .createQuery("from Contract contract where contract.phoneNumber = ?1")
                .setParameter(1, phoneNumber)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public boolean isExists(String phoneNumber) {
        return sessionFactory.getCurrentSession()
                .createQuery("select contract.phoneNumber from Contract contract " +
                        "where contract.phoneNumber = ?1")
                .setParameter(1, phoneNumber)
                .stream()
                .anyMatch(contract -> true);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public boolean isActive(String phoneNumber) {
        return sessionFactory.getCurrentSession()
                .createQuery("select contract.active from Contract contract " +
                "where contract.phoneNumber = ?1")
                .setParameter(1, phoneNumber)
                .stream()
                .anyMatch(active -> active.equals(true));
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void save(Contract contract) {
        sessionFactory.getCurrentSession().persist(contract);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public boolean updateEndDateById(Contract contract) {
        return sessionFactory.getCurrentSession()
                .createQuery("update Contract contract set contract.endDate = ?1 where contract.id = ?2")
                .setParameter(1, contract.getEndDate())
                .setParameter(2, contract.getId())
                .executeUpdate() > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public boolean updateEndDateByPhoneNumber(Contract contract) {
        return sessionFactory.getCurrentSession()
                .createQuery("update Contract contract set contract.endDate = ?1 where contract.phoneNumber = ?2")
                .setParameter(1, contract.getEndDate())
                .setParameter(2, contract.getPhoneNumber())
                .executeUpdate() > 0;
    }
}
