package ru.tsystems.javaschool.mobile_operator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "contract_option", schema = "mobile_operator")
public class ContractOption implements Serializable {
    private long id;
    private Date startDate;
    private Date endDate;
    private boolean isActive;
    @Transient
    private Contract contractByContractId;
    @Transient
    private Option optionByOptionId;

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
        ContractOption that = (ContractOption) o;
        return id == that.id &&
                contractByContractId.getId() == that.contractByContractId.getId() &&
                optionByOptionId.getId() == that.optionByOptionId.getId() &&
                isActive == that.isActive &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, startDate, endDate, isActive);
    }

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id", nullable = false)
    public Contract getContractByContractId() {
        return contractByContractId;
    }

    public void setContractByContractId(Contract contractByContractId) {
        this.contractByContractId = contractByContractId;
    }

    @ManyToOne
    @JoinColumn(name = "option_id", referencedColumnName = "id", nullable = false)
    public Option getOptionByOptionId() {
        return optionByOptionId;
    }

    public void setOptionByOptionId(Option optionByOptionId) {
        this.optionByOptionId = optionByOptionId;
    }
}
