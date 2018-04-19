package ru.tsystems.javaschool.mobile_operator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.javaschool.mobile_operator.dao.UserDAO;
import ru.tsystems.javaschool.mobile_operator.dto.UserDTO;
import ru.tsystems.javaschool.mobile_operator.entity.User;
import ru.tsystems.javaschool.mobile_operator.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public List<UserDTO> findAll() {
        List<User> users = userDAO.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            UserDTO userDTO = new UserDTO(user);
            userDTO.fill(user.getTypeId(), user.getUserContractsById());
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS, readOnly =
            true)
    public UserDTO find(long id) {
        User user = userDAO.findById(id);
        UserDTO userDTO = null;
        if (user != null) {
            userDTO = new UserDTO(user);
            userDTO.fill(user.getTypeId(), user.getUserContractsById());
        }
        return userDTO;
    }
}
