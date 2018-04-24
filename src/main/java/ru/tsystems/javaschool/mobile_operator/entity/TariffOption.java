package ru.tsystems.javaschool.mobile_operator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tariff_option", schema = "mobile_operator")
public class TariffOption implements Serializable {
    private long id;
    @Transient
    private Tariff tariffByTariffId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TariffOption that = (TariffOption) o;
        return id == that.id &&
                tariffByTariffId.getId() == that.tariffByTariffId.getId() &&
                optionByOptionId.getId() == that.optionByOptionId.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "tariff_id", referencedColumnName = "id", nullable = false)
    public Tariff getTariffByTariffId() {
        return tariffByTariffId;
    }

    public void setTariffByTariffId(Tariff tariffByTariffId) {
        this.tariffByTariffId = tariffByTariffId;
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
