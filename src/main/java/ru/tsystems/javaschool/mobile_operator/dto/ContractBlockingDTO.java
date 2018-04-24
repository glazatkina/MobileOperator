package ru.tsystems.javaschool.mobile_operator.dto;

import ru.tsystems.javaschool.mobile_operator.entity.Contract;
import ru.tsystems.javaschool.mobile_operator.entity.ContractBlocking;
import ru.tsystems.javaschool.mobile_operator.entity.User;

import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Date;

public class ContractBlockingDTO implements Serializable, AbstractDTO<ContractBlocking> {
    private long id;
    private Date startDate;
    private Date endDate;
    @Transient
    private ContractDTO blockedContract;
    @Transient
    private UserDTO blockingUser;


    public ContractBlockingDTO() {
    }

    public ContractBlockingDTO(ContractBlocking contractBlocking) {
        this.id = contractBlocking.getId();
        this.startDate = contractBlocking.getStartDate();
        this.endDate = contractBlocking.getEndDate();
    }

    public ContractBlockingDTO(long id, Date startDate, Date endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void fill(Contract blockedContract, User blockingUser) {
        this.blockedContract = new ContractDTO(blockedContract);
        this.blockingUser = new UserDTO(blockingUser);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ContractDTO getBlockedContract() {
        return blockedContract;
    }

    public void setBlockedContract(ContractDTO blockedContract) {
        this.blockedContract = blockedContract;
    }

    public UserDTO getBlockingUser() {
        return blockingUser;
    }

    public void setBlockingUser(UserDTO blockingUser) {
        this.blockingUser = blockingUser;
    }

    @Override
    public ContractBlocking toEntity() {
        ContractBlocking contractBlocking = new ContractBlocking();
        contractBlocking.setId(getId());
        contractBlocking.setEndDate(getEndDate());
        contractBlocking.setStartDate(getStartDate());
        return contractBlocking;
    }
}
