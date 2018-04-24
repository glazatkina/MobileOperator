package ru.tsystems.javaschool.mobile_operator.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.ContractBlockingDAO;
import ru.tsystems.javaschool.mobile_operator.entity.Contract;
import ru.tsystems.javaschool.mobile_operator.entity.ContractBlocking;

import java.util.List;

@Repository
public class ContractBlockingDAOImpl implements ContractBlockingDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public ContractBlockingDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public List<ContractBlocking> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from ContractBlocking")
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public List<ContractBlocking> findAllByContract(Contract contract) {
        return sessionFactory.getCurrentSession()
                .createQuery("select ct from ContractBlocking ct where ct.blockedContract.id=?1")
                .setParameter(1, contract.getId())
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public ContractBlocking findById(long id) {
        return sessionFactory.getCurrentSession()
                .get(ContractBlocking.class, id);
    }

    @Override
    public void save(ContractBlocking contractBlocking) {
        sessionFactory.getCurrentSession().persist(contractBlocking);
    }
}
