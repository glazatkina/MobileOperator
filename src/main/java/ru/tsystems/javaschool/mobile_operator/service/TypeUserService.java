package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.dto.TypeUserDTO;

import java.util.List;

public interface TypeUserService {
    List<TypeUserDTO> findAll();
    TypeUserDTO find(String name);
}
