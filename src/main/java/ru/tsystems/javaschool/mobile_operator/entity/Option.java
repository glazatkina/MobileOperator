//package ru.tsystems.javaschool.mobile_operator.entity;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.Objects;
//
//@Entity
//public class Option {
//    private long id;
//    private String name;
//    private long priceConn;
//    private long cost;
//    private long measureId;
//    private String description;
//    private Collection<ContractOption> contractOptionsById;
//    private Measure measureByMeasureId;
//    private Collection<OptionOption> optionOptionsById;
//    private Collection<OptionOption> optionOptionsById_0;
//    private Collection<TariffOption> tariffOptionsById;
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
//    @Column(name = "name", nullable = false, length = 45)
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Basic
//    @Column(name = "price_conn", nullable = false)
//    public long getPriceConn() {
//        return priceConn;
//    }
//
//    public void setPriceConn(long priceConn) {
//        this.priceConn = priceConn;
//    }
//
//    @Basic
//    @Column(name = "cost", nullable = false)
//    public long getCost() {
//        return cost;
//    }
//
//    public void setCost(long cost) {
//        this.cost = cost;
//    }
//
//    @Basic
//    @Column(name = "measure_id", nullable = false)
//    public long getMeasureId() {
//        return measureId;
//    }
//
//    public void setMeasureId(long measureId) {
//        this.measureId = measureId;
//    }
//
//    @Basic
//    @Column(name = "description", nullable = true, length = 45)
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Option option = (Option) o;
//        return id == option.id &&
//                priceConn == option.priceConn &&
//                cost == option.cost &&
//                measureId == option.measureId &&
//                Objects.equals(name, option.name) &&
//                Objects.equals(description, option.description);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, name, priceConn, cost, measureId, description);
//    }
//
//    @OneToMany(mappedBy = "optionByOptionId")
//    public Collection<ContractOption> getContractOptionsById() {
//        return contractOptionsById;
//    }
//
//    public void setContractOptionsById(Collection<ContractOption> contractOptionsById) {
//        this.contractOptionsById = contractOptionsById;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "measure_id", referencedColumnName = "id", nullable = false)
//    public Measure getMeasureByMeasureId() {
//        return measureByMeasureId;
//    }
//
//    public void setMeasureByMeasureId(Measure measureByMeasureId) {
//        this.measureByMeasureId = measureByMeasureId;
//    }
//
//    @OneToMany(mappedBy = "optionByOptionId1")
//    public Collection<OptionOption> getOptionOptionsById() {
//        return optionOptionsById;
//    }
//
//    public void setOptionOptionsById(Collection<OptionOption> optionOptionsById) {
//        this.optionOptionsById = optionOptionsById;
//    }
//
//    @OneToMany(mappedBy = "optionByOptionId2")
//    public Collection<OptionOption> getOptionOptionsById_0() {
//        return optionOptionsById_0;
//    }
//
//    public void setOptionOptionsById_0(Collection<OptionOption> optionOptionsById_0) {
//        this.optionOptionsById_0 = optionOptionsById_0;
//    }
//
//    @OneToMany(mappedBy = "optionByOptionId")
//    public Collection<TariffOption> getTariffOptionsById() {
//        return tariffOptionsById;
//    }
//
//    public void setTariffOptionsById(Collection<TariffOption> tariffOptionsById) {
//        this.tariffOptionsById = tariffOptionsById;
//    }
//}
