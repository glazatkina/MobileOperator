package ru.tsystems.javaschool.mobile_operator.dto;

import ru.tsystems.javaschool.mobile_operator.entity.Contract;
import ru.tsystems.javaschool.mobile_operator.entity.User;

import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Date;

public class ContractDTO implements Serializable, AbstractDTO<Contract> {
    private long id;
    private String phoneNumber;
    private long balance;
    private Date startDate;
    private Date endDate;
    private boolean isActive;
    @Transient
    private UserDTO customer = null;

    public ContractDTO() {
    }

    public ContractDTO(long id, String phoneNumber, long balance, Date startDate, Date endDate, boolean isActive, UserDTO customer) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    public ContractDTO(Contract contract) {
        this.id = contract.getId();
        this.phoneNumber = contract.getPhoneNumber();
        this.balance = contract.getBalance();
        this.startDate = contract.getStartDate();
        this.endDate = contract.getEndDate();
        this.isActive = contract.isActive();
    }

    public void fill(User customer) {
        this.customer = new UserDTO(customer);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserDTO getCustomer() {
        return customer;
    }

    public void setCustomer(UserDTO customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ContractDTO{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", balance=" + balance +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isActive=" + isActive +
                ", customer=" + customer +
                '}';
    }

    public Contract toEntity() {
        Contract contract = new Contract();
        contract.setId(getId());
        contract.setCustomer(getCustomer().toEntity());
        contract.setBalance(getBalance());
        contract.setActive(isActive());
        contract.setStartDate(getStartDate());
        contract.setEndDate(getEndDate());
        contract.setPhoneNumber(getPhoneNumber());
        return contract;
    }
}
