package ru.tsystems.javaschool.mobile_operator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.TypeUserDAO;
import ru.tsystems.javaschool.mobile_operator.entity.TypeUser;
import ru.tsystems.javaschool.mobile_operator.service.TypeUserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TypeUserServiceImpl implements TypeUserService {
    private TypeUserDAO typeUserDAO;

    @Autowired
    public TypeUserServiceImpl(TypeUserDAO typeUserDAO) {
        this.typeUserDAO = typeUserDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public List<TypeUser> findAll() {
        return typeUserDAO.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public TypeUser find(String name) {
        TypeUser typeUser = typeUserDAO.findByName(name);
        if (typeUser == null) {
            throw new EntityNotFoundException("TypeUser " + name + " not found");
        }
        return typeUser;
    }
}
