package ru.tsystems.javaschool.mobile_operator.dto;

import org.hibernate.mapping.Collection;
import ru.tsystems.javaschool.mobile_operator.entity.TypeUser;
import ru.tsystems.javaschool.mobile_operator.entity.User;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TypeUserDTO implements Serializable, AbstractDTO<TypeUser> {
    private long id;
    private String name;
    @Transient
    private List<UserDTO> users;

    public TypeUserDTO() {
    }

    public TypeUserDTO(long id, String name) {

        this.id = id;
        this.name = name;
    }

    public TypeUserDTO(TypeUser typeUser) {
        this.id = typeUser.getId();
        this.name = typeUser.getName();
    }

    @Override
    public String toString() {
        return "TypeUserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public TypeUser toEntity() {
        TypeUser typeUser = new TypeUser();
        typeUser.setId(getId());
        typeUser.setName(getName());
        return typeUser;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = new ArrayList<>();
        for (User user: users) {
            UserDTO userDTO = new UserDTO(user);
            this.users.add(userDTO);
        }
    }
}
