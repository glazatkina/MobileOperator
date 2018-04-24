package ru.tsystems.javaschool.mobile_operator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "contract", schema = "mobile_operator")
public class Contract implements Serializable {
    private long id;
    private String phoneNumber;
    private long balance;
    private Date startDate;
    private Date endDate;
    private boolean isActive;
    @Transient
    private User customer;
    @Transient
    private Tariff currentTariff;
    @Transient
    private Collection<ContractBlocking> contractBlockingsById;
//    private Collection<ContractOption> contractOptionsById;
    @Transient
    private Collection<ContractTariff> contractTariffsById;
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
    @Column(name = "phone_number", nullable = false, length = 15)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "balance", nullable = false)
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "start_date", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "is_active", nullable = false)
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id &&
                balance == contract.balance &&
                isActive == contract.isActive &&
                Objects.equals(phoneNumber, contract.phoneNumber) &&
                Objects.equals(startDate, contract.startDate) &&
                Objects.equals(endDate, contract.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNumber, balance, startDate, endDate, isActive);
    }

    @OneToMany(mappedBy = "blockedContract", fetch = FetchType.LAZY)
    public Collection<ContractBlocking> getContractBlockingsById() {
        return contractBlockingsById;
    }

    public void setContractBlockingsById(Collection<ContractBlocking> contractBlockingsById) {
        this.contractBlockingsById = contractBlockingsById;
    }

//    @OneToMany(mappedBy = "contractByContractId")
//    public Collection<ContractOption> getContractOptionsById() {
//        return contractOptionsById;
//    }
//
//    public void setContractOptionsById(Collection<ContractOption> contractOptionsById) {
//        this.contractOptionsById = contractOptionsById;
//    }
//
    @OneToMany(mappedBy = "contractTariffsById", fetch = FetchType.LAZY)
    public Collection<ContractTariff> getContractTariffsById() {
        return contractTariffsById;
    }

    public void setContractTariffsById(Collection<ContractTariff> contractTariffsById) {
        this.contractTariffsById = contractTariffsById;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariff_id", referencedColumnName = "id", nullable = false)
    public Tariff getCurrentTariff() {
        return currentTariff;
    }

    public void setCurrentTariff(Tariff currentTariff) {
        this.currentTariff = currentTariff;
    }
}
