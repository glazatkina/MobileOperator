package ru.tsystems.javaschool.mobile_operator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "measure", schema = "mobile_operator", catalog = "")
public class Measure implements Serializable {
    private long id;
    private String name;
//    private Collection<Option> optionsById;
//    private Collection<Service> servicesById;

    public Measure() {

    }

    public Measure(long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measure measure = (Measure) o;
        return id == measure.id &&
                Objects.equals(name, measure.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

//    @OneToMany(mappedBy = "measureByMeasureId")
//    public Collection<Option> getOptionsById() {
//        return optionsById;
//    }
//
//    public void setOptionsById(Collection<Option> optionsById) {
//        this.optionsById = optionsById;
//    }
//
//    @OneToMany(mappedBy = "measureByMeasureId")
//    public Collection<Service> getServicesById() {
//        return servicesById;
//    }
//
//    public void setServicesById(Collection<Service> servicesById) {
//        this.servicesById = servicesById;
//    }
}
