package ru.tsystems.javaschool.mobile_operator.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "mobile_operator", catalog = "")
public class User {
    private long id;
    private String name;
    private String surname;
    private Date dateBirth;
    private String passport;
    private String address;
    private String email;
    private long password;
    private long typeId;
//    private Collection<ContractBlocking> contractBlockingsById;
//    private TypeUser typeUserByTypeId;
//    private Collection<UserContract> userContractsById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "date_birth", nullable = false)
    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Basic
    @Column(name = "passport", nullable = false, length = 45)
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false)
    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    @Basic
    @Column(name = "type_id", nullable = false)
    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                password == user.password &&
                typeId == user.typeId &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(dateBirth, user.dateBirth) &&
                Objects.equals(passport, user.passport) &&
                Objects.equals(address, user.address) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, dateBirth, passport, address, email, password, typeId);
    }

//    @OneToMany(mappedBy = "userByUserId")
//    public Collection<ContractBlocking> getContractBlockingsById() {
//        return contractBlockingsById;
//    }
//
//    public void setContractBlockingsById(Collection<ContractBlocking> contractBlockingsById) {
//        this.contractBlockingsById = contractBlockingsById;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
//    public TypeUser getTypeUserByTypeId() {
//        return typeUserByTypeId;
//    }
//
//    public void setTypeUserByTypeId(TypeUser typeUserByTypeId) {
//        this.typeUserByTypeId = typeUserByTypeId;
//    }
//
//    @OneToMany(mappedBy = "userByUserId")
//    public Collection<UserContract> getUserContractsById() {
//        return userContractsById;
//    }
//
//    public void setUserContractsById(Collection<UserContract> userContractsById) {
//        this.userContractsById = userContractsById;
//    }
}
