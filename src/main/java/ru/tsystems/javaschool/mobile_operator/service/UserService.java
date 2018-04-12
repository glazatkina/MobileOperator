package ru.tsystems.javaschool.mobile_operator.service;

import ru.tsystems.javaschool.mobile_operator.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User find(long id);
}
