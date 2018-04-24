package ru.tsystems.javaschool.mobile_operator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "option_option", schema = "mobile_operator")
public class OptionOption implements Serializable {
    private long id;
    private boolean isBinded;
    @Transient
    private Option mainOption;
    @Transient
    private Option dependentOption;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "is_binded", nullable = false)
    public boolean isBinded() {
        return isBinded;
    }

    public void setBinded(boolean binded) {
        isBinded = binded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptionOption that = (OptionOption) o;
        return id == that.id &&
                mainOption.getId() == that.mainOption.getId() &&
                dependentOption.getId() == that.dependentOption.getId() &&
                isBinded == that.isBinded;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, isBinded);
    }

    @ManyToOne
    @JoinColumn(name = "option_id_1", referencedColumnName = "id", nullable = false)
    public Option getMainOption() {
        return mainOption;
    }

    public void setMainOption(Option mainOption) {
        this.mainOption = mainOption;
    }

    @ManyToOne
    @JoinColumn(name = "option_id_2", referencedColumnName = "id", nullable = false)
    public Option getDependentOption() {
        return dependentOption;
    }

    public void setDependentOption(Option dependentOption) {
        this.dependentOption = dependentOption;
    }
}
