package ru.tsystems.javaschool.mobile_operator.dto;

import ru.tsystems.javaschool.mobile_operator.entity.Option;
import ru.tsystems.javaschool.mobile_operator.entity.Tariff;
import ru.tsystems.javaschool.mobile_operator.entity.TariffOption;

import javax.persistence.Transient;
import java.io.Serializable;

public class TariffOptionDTO implements Serializable, AbstractDTO<TariffOption> {
    private long id;
    @Transient
    private TariffDTO tariffByTariffId = null;
    @Transient
    private OptionDTO optionByOptionId = null;

    public TariffOptionDTO(TariffOption tariffOption) {
        this.id = tariffByTariffId.getId();
    }

    public TariffOptionDTO(long id) {
        this.id = id;
    }

    public TariffOptionDTO() {
    }

    public void fill(Tariff tariff, Option option) {
        this.tariffByTariffId = new TariffDTO(tariff);
        this.optionByOptionId = new OptionDTO(option);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TariffDTO getTariffByTariffId() {
        return tariffByTariffId;
    }

    public void setTariffByTariffId(TariffDTO tariffByTariffId) {
        this.tariffByTariffId = tariffByTariffId;
    }

    public OptionDTO getOptionByOptionId() {
        return optionByOptionId;
    }

    public void setOptionByOptionId(OptionDTO optionByOptionId) {
        this.optionByOptionId = optionByOptionId;
    }

    @Override
    public String toString() {
        return "TariffOptionDTO{" +
                "id=" + id +
                ", tariffByTariffId=" + tariffByTariffId +
                ", optionByOptionId=" + optionByOptionId +
                '}';
    }

    @Override
    public TariffOption toEntity() {
        TariffOption tariffOption = new TariffOption();
        tariffOption.setId(this.id);
        tariffOption.setOptionByOptionId(optionByOptionId.toEntity());
        tariffOption.setTariffByTariffId(tariffByTariffId.toEntity());
        return tariffOption;
    }
}
