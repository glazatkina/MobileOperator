package ru.tsystems.javaschool.mobile_operator.dao;

import ru.tsystems.javaschool.mobile_operator.entity.Option;

import java.util.List;

public interface OptionDAO {
    List<Option> findAll();
    Option findById(long id);
    Option findByName(String name);
    boolean isExists(String name);
    void save(Option option);
}
