package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.dto.OptionDTO;

import java.util.List;

public interface OptionService {
    List<OptionDTO> findAll();
    OptionDTO findById(long id);
    OptionDTO findByName(String name);
    boolean isExists(String name);
    void save(OptionDTO option);
}
