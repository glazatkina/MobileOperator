//package ru.tsystems.javaschool.mobile_operator.entity;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.Objects;
//
//@Entity
//public class Service {
//    private long id;
//    private String name;
//    private long measureId;
//    private Measure measureByMeasureId;
////    private Collection<TariffService> tariffServicesById;
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
//    @Column(name = "measure_id", nullable = false)
//    public long getMeasureId() {
//        return measureId;
//    }
//
//    public void setMeasureId(long measureId) {
//        this.measureId = measureId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Service service = (Service) o;
//        return id == service.id &&
//                measureId == service.measureId &&
//                Objects.equals(name, service.name);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, name, measureId);
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
////
////    @OneToMany(mappedBy = "serviceByServiceId")
////    public Collection<TariffService> getTariffServicesById() {
////        return tariffServicesById;
////    }
////
////    public void setTariffServicesById(Collection<TariffService> tariffServicesById) {
////        this.tariffServicesById = tariffServicesById;
////    }
//}
