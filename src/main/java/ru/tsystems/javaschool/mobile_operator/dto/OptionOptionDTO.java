package ru.tsystems.javaschool.mobile_operator.dto;

import ru.tsystems.javaschool.mobile_operator.entity.Option;
import ru.tsystems.javaschool.mobile_operator.entity.OptionOption;

import javax.persistence.Transient;

public class OptionOptionDTO {
    private long id;
    private boolean isBinded;
    @Transient
    private OptionDTO mainOption;
    @Transient
    private OptionDTO dependentOption;

    public OptionOptionDTO(OptionOption optionOption) {
        this.isBinded = optionOption.isBinded();
        this.id = optionOption.getId();
    }

    public OptionOptionDTO() {
    }

    public OptionOptionDTO(long id, boolean isBinded) {
        this.id = id;
        this.isBinded = isBinded;
    }

    public void fill(Option mainOption, Option dependentOption) {
        this.dependentOption = new OptionDTO(dependentOption);
        this.mainOption = new OptionDTO(mainOption);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isBinded() {
        return isBinded;
    }

    public void setBinded(boolean binded) {
        isBinded = binded;
    }

    public OptionDTO getMainOption() {
        return mainOption;
    }

    public void setMainOption(OptionDTO mainOption) {
        this.mainOption = mainOption;
    }

    public OptionDTO getDependentOption() {
        return dependentOption;
    }

    public void setDependentOption(OptionDTO dependentOption) {
        this.dependentOption = dependentOption;
    }
}
