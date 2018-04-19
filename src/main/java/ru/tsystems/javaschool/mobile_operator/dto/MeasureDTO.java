package ru.tsystems.javaschool.mobile_operator.dto;

import ru.tsystems.javaschool.mobile_operator.entity.Measure;

import java.io.Serializable;

public class MeasureDTO implements Serializable {
    private long id;
    private String name;

    public MeasureDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MeasureDTO() {

    }

    public MeasureDTO(Measure measure) {
        this.id = measure.getId();
        this.name = measure.getName();
    }

    @Override
    public String toString() {
        return "MeasureDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
}
