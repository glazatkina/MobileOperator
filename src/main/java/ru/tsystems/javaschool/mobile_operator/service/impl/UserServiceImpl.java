package ru.tsystems.javaschool.mobile_operator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tsystems.javaschool.mobile_operator.dao.UserDAO;
import ru.tsystems.javaschool.mobile_operator.entity.User;
import ru.tsystems.javaschool.mobile_operator.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User find(long id) {
        return userDAO.findById(id);
    }
}
