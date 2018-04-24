package ru.tsystems.javaschool.mobile_operator.dto;

import ru.tsystems.javaschool.mobile_operator.entity.Tariff;

import java.io.Serializable;

public class TariffDTO implements Serializable, AbstractDTO<Tariff> {
    private long id;
    private String name;
    private long priceConn;
    private boolean isActive;

    public TariffDTO(long id, String name, long priceConn, boolean isActive) {
        this.id = id;
        this.name = name;
        this.priceConn = priceConn;
        this.isActive = isActive;
    }

    public TariffDTO() {
    }

    public TariffDTO(Tariff tariff) {
        this.id = tariff.getId();
        this.name = tariff.getName();
        this.priceConn = tariff.getPriceConn();
        this.isActive = tariff.isActive();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPriceConn() {
        return priceConn;
    }

    public void setPriceConn(long priceConn) {
        this.priceConn = priceConn;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public Tariff toEntity() {
        Tariff tariff = new Tariff();
        tariff.setId(getId());
        tariff.setActive(isActive());
        tariff.setName(getName());
        tariff.setPriceConn(getPriceConn());
        return tariff;
    }
}
