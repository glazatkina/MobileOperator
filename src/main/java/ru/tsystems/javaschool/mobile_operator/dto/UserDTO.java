package ru.tsystems.javaschool.mobile_operator.dto;

import ru.tsystems.javaschool.mobile_operator.entity.Contract;
import ru.tsystems.javaschool.mobile_operator.entity.TypeUser;
import ru.tsystems.javaschool.mobile_operator.entity.User;

import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserDTO implements Serializable, AbstractDTO<User> {
    private long id;
    private String name;
    private String surname;
    private Date dateBirth;
    private String passport;
    private String address;
    private String email;
    private long password;
    @Transient
    private TypeUserDTO typeId = null;
    @Transient
    private Collection<ContractDTO> userContractsById = null;

    public UserDTO(long id, String name, String surname, Date dateBirth, String passport, String address, String email, long password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.passport = passport;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.dateBirth = user.getDateBirth();
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.passport = user.getPassport();
    }

    public void fill(TypeUser typeUser, Collection<Contract> contracts) {
        this.typeId = new TypeUserDTO(typeUser);
        this.userContractsById = new ArrayList<>();
        for (Contract contract: contracts) {
            userContractsById.add(new ContractDTO(contract));
        }
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public TypeUserDTO getTypeId() {
        return typeId;
    }

    public void setTypeId(TypeUserDTO typeId) {
        this.typeId = typeId;
    }

    public Collection<ContractDTO> getUserContractsById() {
        return userContractsById;
    }

    public void setUserContractsById(Collection<Contract> userContractsById) {
        List<ContractDTO> contractDTOList = new ArrayList<>();
        for (Contract contract: userContractsById) {
            contractDTOList.add(new ContractDTO(contract));
        }
        this.userContractsById = contractDTOList;
    }

    @Override
    public String toString() {
        return "UserDTO {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateBirth=" + dateBirth +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", typeId=" + typeId +
                ", userContractsById=" + userContractsById +
                '}';
    }

    @Override
    public User toEntity() {
        User user = new User();
        user.setId(getId());
        user.setAddress(getAddress());
        user.setDateBirth(getDateBirth());
        user.setEmail(getEmail());
        user.setName(getName());
        user.setSurname(getSurname());
        user.setPassport(getPassport());
        user.setPassword(getPassword());
        user.setTypeId(getTypeId().toEntity());
        return user;
    }
}
