package ru.tsystems.javaschool.mobile_operator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "`option`", schema = "mobile_operator")
public class Option implements Serializable {
    private long id;
    private String name;
    private long priceConn;
    private long cost;
    private String description;
    @Transient
    private Collection<ContractOption> contractOptionsById;
    @Transient
    private Measure measure;
    @Transient
    private Collection<OptionOption> dependentOptions;
    @Transient
    private Collection<TariffOption> tariffOptionsById;

    public Option() {
    }

    public Option(long id, String name, long priceConn, long cost, String description) {
        this.id = id;
        this.name = name;
        this.priceConn = priceConn;
        this.cost = cost;
        this.description = description;
    }

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
    @Column(name = "price_conn", nullable = false)
    public long getPriceConn() {
        return priceConn;
    }

    public void setPriceConn(long priceConn) {
        this.priceConn = priceConn;
    }

    @Basic
    @Column(name = "cost", nullable = false)
    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return id == option.id &&
                priceConn == option.priceConn &&
                cost == option.cost &&
                this.measure.getId() == option.measure.getId() &&
                Objects.equals(name, option.name) &&
                Objects.equals(description, option.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, priceConn, cost, description);
    }

    @OneToMany(mappedBy = "optionByOptionId")
    public Collection<ContractOption> getContractOptionsById() {
        return contractOptionsById;
    }

    public void setContractOptionsById(Collection<ContractOption> contractOptionsById) {
        this.contractOptionsById = contractOptionsById;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measure_id", referencedColumnName = "id", nullable = false)
    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    @OneToMany(mappedBy = "dependentOption")
    public Collection<OptionOption> getDependentOptions() {
        return dependentOptions;
    }

    public void setDependentOptions(Collection<OptionOption> dependentOptions) {
        this.dependentOptions = dependentOptions;
    }

    @OneToMany(mappedBy = "optionByOptionId")
    public Collection<TariffOption> getTariffOptionsById() {
        return tariffOptionsById;
    }

    public void setTariffOptionsById(Collection<TariffOption> tariffOptionsById) {
        this.tariffOptionsById = tariffOptionsById;
    }
}
