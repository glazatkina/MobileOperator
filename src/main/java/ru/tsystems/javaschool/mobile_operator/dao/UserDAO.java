package ru.tsystems.javaschool.mobile_operator.dao;

import ru.tsystems.javaschool.mobile_operator.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(long id);
}
