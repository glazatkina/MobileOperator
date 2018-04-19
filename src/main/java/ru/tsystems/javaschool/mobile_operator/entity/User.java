package ru.tsystems.javaschool.mobile_operator.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "mobile_operator")
public class User implements Serializable {
    private long id;
    private String name;
    private String surname;
    private Date dateBirth;
    private String passport;
    private String address;
    private String email;
    private long password;
//    private Collection<ContractBlocking> contractBlockingsById;
    private TypeUser typeId;
    private Collection<Contract> userContractsById;

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
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    public TypeUser getTypeId() {
        return typeId;
    }

    public void setTypeId(TypeUser typeId) {
        this.typeId = typeId;
    }

    @OneToMany(mappedBy = "customer")
    public Collection<Contract> getUserContractsById() {
        return userContractsById;
    }

    public void setUserContractsById(Collection<Contract> userContractsById) {
        this.userContractsById = userContractsById;
    }
}
