package ru.tsystems.javaschool.mobile_operator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "contract_blocking", schema = "mobile_operator")
public class ContractBlocking implements Serializable {
    private long id;
    private Date startDate;
    private Date endDate;
    @Transient
    private Contract blockedContract;
    @Transient
    private User blockingUser;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractBlocking that = (ContractBlocking) o;
        return id == that.id &&
                blockedContract.getId() == that.getBlockedContract().getId() &&
                blockingUser.getId() == that.getBlockingUser().getId() &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate);
    }

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id", nullable = false)
    public Contract getBlockedContract() {
        return blockedContract;
    }

    public void setBlockedContract(Contract blockedContract) {
        this.blockedContract = blockedContract;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getBlockingUser() {
        return blockingUser;
    }

    public void setBlockingUser(User blockingUser) {
        this.blockingUser = blockingUser;
    }
}
