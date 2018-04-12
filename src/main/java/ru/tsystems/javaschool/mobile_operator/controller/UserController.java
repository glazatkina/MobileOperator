package ru.tsystems.javaschool.mobile_operator.controller;

import org.springframework.http.ResponseEntity;
import ru.tsystems.javaschool.mobile_operator.entity.User;

import java.util.List;

public interface UserController {
    ResponseEntity<List<User>> findAll();
    ResponseEntity<User> find(long id);
}
