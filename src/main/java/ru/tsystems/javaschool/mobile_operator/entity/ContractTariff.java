package ru.tsystems.javaschool.mobile_operator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "contract_tariff", schema = "mobile_operator")
public class ContractTariff implements Serializable {
    private long id;
    private Date startDate;
    private Date endDate;
    @Transient
    private Contract contractTariffsById;
    @Transient
    private Tariff tariffById;

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
        ContractTariff that = (ContractTariff) o;
        return id == that.id &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, startDate, endDate);
    }

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id", nullable = false)
    public Contract getContractTariffsById() {
        return contractTariffsById;
    }

    public void setContractTariffsById(Contract contractTariffsById) {
        this.contractTariffsById = contractTariffsById;
    }

    @ManyToOne
    @JoinColumn(name = "tariff_id", referencedColumnName = "id", nullable = false)
    public Tariff getTariffById() {
        return tariffById;
    }

    public void setTariffById(Tariff tariffById) {
        this.tariffById = tariffById;
    }
}
