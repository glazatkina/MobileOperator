//package ru.tsystems.javaschool.mobile_operator.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "user_contract", schema = "mobile_operator", catalog = "")
//public class UserContract {
//    private long id;
//    private long userId;
//    private long contractId;
//    private User userByUserId;
//    private Contract contractByContractId;
//
//    @Id
//    @Column(name = "id", nullable = false)
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "user_id", nullable = false)
//    public long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }
//
//    @Basic
//    @Column(name = "contract_id", nullable = false)
//    public long getContractId() {
//        return contractId;
//    }
//
//    public void setContractId(long contractId) {
//        this.contractId = contractId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserContract that = (UserContract) o;
//        return id == that.id &&
//                userId == that.userId &&
//                contractId == that.contractId;
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, userId, contractId);
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
//    public User getUserByUserId() {
//        return userByUserId;
//    }
//
//    public void setUserByUserId(User userByUserId) {
//        this.userByUserId = userByUserId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "contract_id", referencedColumnName = "id", nullable = false)
//    public Contract getContractByContractId() {
//        return contractByContractId;
//    }
//
//    public void setContractByContractId(Contract contractByContractId) {
//        this.contractByContractId = contractByContractId;
//    }
//}
