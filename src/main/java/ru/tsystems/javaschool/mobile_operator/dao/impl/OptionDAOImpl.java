package ru.tsystems.javaschool.mobile_operator.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.OptionDAO;
import ru.tsystems.javaschool.mobile_operator.entity.Option;

import java.util.List;

@Repository
public class OptionDAOImpl implements OptionDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public OptionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
//    @SuppressWarnings("unchecked")
    public List<Option> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Option")
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public Option findById(long id) {
        return sessionFactory.getCurrentSession()
                .get(Option.class, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public Option findByName(String name) {
        return (Option) sessionFactory.getCurrentSession()
                .createQuery("select option from Option option where option.name = ?1")
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
                .createQuery("select option.name from Option option where option.name=?1")
                .setParameter(1, name)
                .stream()
                .anyMatch(contract -> true);
    }


    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void save(Option option) {
        sessionFactory.getCurrentSession().persist(option);
    }
}
