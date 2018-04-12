package ru.tsystems.javaschool.mobile_operator.dao;

import ru.tsystems.javaschool.mobile_operator.entity.TypeUser;

import java.util.List;

public interface TypeUserDAO {
    List<TypeUser> findAll();
    TypeUser findById(long id);
    TypeUser findByName(String name);
    boolean isExists(String name);
}
