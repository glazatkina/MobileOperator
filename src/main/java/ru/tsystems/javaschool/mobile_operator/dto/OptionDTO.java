package ru.tsystems.javaschool.mobile_operator.dto;

import ru.tsystems.javaschool.mobile_operator.entity.Measure;
import ru.tsystems.javaschool.mobile_operator.entity.Option;
import ru.tsystems.javaschool.mobile_operator.entity.OptionOption;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OptionDTO implements Serializable, AbstractDTO<Option> {
    private long id;
    private String name;
    private long priceConn;
    private long cost;
    private String description;
    @Transient
    private MeasureDTO measureDTO = null;
    @Transient
    private List<OptionOptionDTO> dependentOptions = new ArrayList<>();

    public OptionDTO() {
    }

    public OptionDTO(Option option) {
        this.id = option.getId();
        this.cost = option.getCost();
        this.description = option.getDescription();
        this.name = option.getName();
        this.priceConn = option.getPriceConn();
    }

    public OptionDTO(long id, String name, long priceConn, long cost, String description) {
        this.id = id;
        this.name = name;
        this.priceConn = priceConn;
        this.cost = cost;
        this.description = description;
    }

    public void fill(Measure measure, Collection<OptionOption> dependentOptions) {
        MeasureDTO measureDTO = new MeasureDTO(measure);
        this.measureDTO = measureDTO;
        for (OptionOption option: dependentOptions) {
            OptionOptionDTO optionOptionDTO = new OptionOptionDTO(option);
            optionOptionDTO.fill(option.getMainOption(), option.getDependentOption());
            this.dependentOptions.add(optionOptionDTO);
        }
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

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MeasureDTO getMeasureDTO() {
        return measureDTO;
    }

    public void setMeasureDTO(MeasureDTO measureDTO) {
        this.measureDTO = measureDTO;
    }

    public List<OptionOptionDTO> getDependentOptions() {
        return dependentOptions;
    }

    public void setDependentOptions(List<OptionOptionDTO> dependentOptions) {
        this.dependentOptions = dependentOptions;
    }

    @Override
    public String toString() {
        return "OptionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priceConn=" + priceConn +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", measureDTO=" + measureDTO +
                '}';
    }

    @Override
    public Option toEntity() {
        Option option = new Option();
        option.setId(getId());
        option.setCost(getCost());
        option.setDescription(getDescription());
        option.setName(getName());
        option.setPriceConn(getPriceConn());
        return option;
    }
}
