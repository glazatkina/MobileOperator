package ru.tsystems.javaschool.mobile_operator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.TypeUserDAO;
import ru.tsystems.javaschool.mobile_operator.dto.TypeUserDTO;
import ru.tsystems.javaschool.mobile_operator.entity.TypeUser;
import ru.tsystems.javaschool.mobile_operator.service.TypeUserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<TypeUserDTO> findAll() {
        List<TypeUserDTO> typeUserDTOS = typeUserDAO.findAll()
                .stream()
                .map(typeUser -> {
                    return new TypeUserDTO(typeUser);
                })
                .collect(Collectors.toList());
        return typeUserDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public TypeUserDTO find(String name) {
        TypeUser typeUser = typeUserDAO.findByName(name);
        if (typeUser == null) {
            throw new EntityNotFoundException("TypeUser " + name + " not found");
        }
        return new TypeUserDTO(typeUser);
    }
}
