package ru.tsystems.javaschool.mobile_operator.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.TypeUserDAO;
import ru.tsystems.javaschool.mobile_operator.entity.TypeUser;

import java.util.List;

@Repository
public class TypeUserDAOImpl implements TypeUserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public TypeUserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public List<TypeUser> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from TypeUser")
                .list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public TypeUser findById(long id) {
        return sessionFactory.getCurrentSession()
                .get(TypeUser.class, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    @SuppressWarnings("unchecked")
    public TypeUser findByName(String name) {
        return (TypeUser) sessionFactory.getCurrentSession()
                .createQuery("from TypeUser typeUser where typeUser.name = ?1")
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
                .createQuery("select typeUser.name from TypeUser typeUser where typeUser.name = ?1")
                .setParameter(1, name)
                .stream()
                .anyMatch(typeUser -> true);
    }
}
