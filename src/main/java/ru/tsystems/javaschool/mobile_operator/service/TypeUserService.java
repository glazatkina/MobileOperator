package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.entity.TypeUser;

import java.util.List;

public interface TypeUserService {
    List<TypeUser> findAll();
    TypeUser find(String name);
}
