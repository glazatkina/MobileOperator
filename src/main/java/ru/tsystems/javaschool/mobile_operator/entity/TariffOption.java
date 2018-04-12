//package ru.tsystems.javaschool.mobile_operator.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "tariff_option", schema = "mobile_operator", catalog = "")
//public class TariffOption {
//    private long id;
//    private long tariffId;
//    private long optionId;
//    private Tariff tariffByTariffId;
//    private Option optionByOptionId;
//
//    @Id
//    @Column(name = "id", nullable = false)
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "tariff_id", nullable = false)
//    public long getTariffId() {
//        return tariffId;
//    }
//
//    public void setTariffId(long tariffId) {
//        this.tariffId = tariffId;
//    }
//
//    @Basic
//    @Column(name = "option_id", nullable = false)
//    public long getOptionId() {
//        return optionId;
//    }
//
//    public void setOptionId(long optionId) {
//        this.optionId = optionId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TariffOption that = (TariffOption) o;
//        return id == that.id &&
//                tariffId == that.tariffId &&
//                optionId == that.optionId;
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, tariffId, optionId);
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "tariff_id", referencedColumnName = "id", nullable = false)
//    public Tariff getTariffByTariffId() {
//        return tariffByTariffId;
//    }
//
//    public void setTariffByTariffId(Tariff tariffByTariffId) {
//        this.tariffByTariffId = tariffByTariffId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "option_id", referencedColumnName = "id", nullable = false)
//    public Option getOptionByOptionId() {
//        return optionByOptionId;
//    }
//
//    public void setOptionByOptionId(Option optionByOptionId) {
//        this.optionByOptionId = optionByOptionId;
//    }
//}
