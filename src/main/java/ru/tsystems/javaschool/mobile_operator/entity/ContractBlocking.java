//package ru.tsystems.javaschool.mobile_operator.entity;
//
//import javax.persistence.*;
//import java.sql.Date;
//import java.util.Objects;
//
//@Entity
//@Table(name = "contract_blocking", schema = "mobile_operator", catalog = "")
//public class ContractBlocking {
//    private long id;
//    private long contractId;
//    private Date startDate;
//    private Date endDate;
//    private long userId;
//    private Contract contractByContractId;
//    private User userByUserId;
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
//    @Column(name = "contract_id", nullable = false)
//    public long getContractId() {
//        return contractId;
//    }
//
//    public void setContractId(long contractId) {
//        this.contractId = contractId;
//    }
//
//    @Basic
//    @Column(name = "start_date", nullable = false)
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    @Basic
//    @Column(name = "end_date", nullable = true)
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
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
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ContractBlocking that = (ContractBlocking) o;
//        return id == that.id &&
//                contractId == that.contractId &&
//                userId == that.userId &&
//                Objects.equals(startDate, that.startDate) &&
//                Objects.equals(endDate, that.endDate);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, contractId, startDate, endDate, userId);
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
//}
