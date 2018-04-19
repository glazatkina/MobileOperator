package ru.tsystems.javaschool.mobile_operator.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "contract_tariff", schema = "mobile_operator", catalog = "")
public class ContractTariff {
    private long id;
    private long contractId;
    private long tariffId;
    private Date startDate;
    private Date endDate;
    private Contract contractByContractId;
    private Tariff tariffByTariffId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "contract_id", nullable = false)
    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    @Basic
    @Column(name = "tariff_id", nullable = false)
    public long getTariffId() {
        return tariffId;
    }

    public void setTariffId(long tariffId) {
        this.tariffId = tariffId;
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
        ContractTariff that = (ContractTariff) o;
        return id == that.id &&
                contractId == that.contractId &&
                tariffId == that.tariffId &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, contractId, tariffId, startDate, endDate);
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
    @JoinColumn(name = "tariff_id", referencedColumnName = "id", nullable = false)
    public Tariff getTariffByTariffId() {
        return tariffByTariffId;
    }

    public void setTariffByTariffId(Tariff tariffByTariffId) {
        this.tariffByTariffId = tariffByTariffId;
    }
}
