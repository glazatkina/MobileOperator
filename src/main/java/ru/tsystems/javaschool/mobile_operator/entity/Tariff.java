package ru.tsystems.javaschool.mobile_operator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tariff", schema = "mobile_operator")
public class Tariff implements Serializable {
    private long id;
    private String name;
    private long priceConn;
    private boolean isActive;
    @Transient
    private Collection<ContractTariff> contractTariffsById;
    @Transient
    private Collection<TariffOption> tariffOptionsById;
//    private Collection<TariffService> tariffServicesById;

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
        Tariff tariff = (Tariff) o;
        return id == tariff.id &&
                priceConn == tariff.priceConn &&
                isActive == tariff.isActive &&
                Objects.equals(name, tariff.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, priceConn, isActive);
    }

    @OneToMany(mappedBy = "tariffById")
    public Collection<ContractTariff> getContractTariffsById() {
        return contractTariffsById;
    }

    public void setContractTariffsById(Collection<ContractTariff> contractTariffsById) {
        this.contractTariffsById = contractTariffsById;
    }

    @OneToMany(mappedBy = "tariffByTariffId")
    public Collection<TariffOption> getTariffOptionsById() {
        return tariffOptionsById;
    }

    public void setTariffOptionsById(Collection<TariffOption> tariffOptionsById) {
        this.tariffOptionsById = tariffOptionsById;
    }
//    @OneToMany(mappedBy = "tariffByTariffId")
//    public Collection<TariffService> getTariffServicesById() {
//        return tariffServicesById;
//    }
//
//    public void setTariffServicesById(Collection<TariffService> tariffServicesById) {
//        this.tariffServicesById = tariffServicesById;
//    }
}
