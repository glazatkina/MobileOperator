//package ru.tsystems.javaschool.mobile_operator.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "tariff_service", schema = "mobile_operator", catalog = "")
//public class TariffService {
//    private long id;
//    private long tariffId;
//    private long serviceId;
//    private long price;
//    private Tariff tariffByTariffId;
//    private Service serviceByServiceId;
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
//    @Column(name = "service_id", nullable = false)
//    public long getServiceId() {
//        return serviceId;
//    }
//
//    public void setServiceId(long serviceId) {
//        this.serviceId = serviceId;
//    }
//
//    @Basic
//    @Column(name = "price", nullable = false)
//    public long getPrice() {
//        return price;
//    }
//
//    public void setPrice(long price) {
//        this.price = price;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TariffService that = (TariffService) o;
//        return id == that.id &&
//                tariffId == that.tariffId &&
//                serviceId == that.serviceId &&
//                price == that.price;
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, tariffId, serviceId, price);
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
//    @JoinColumn(name = "service_id", referencedColumnName = "id", nullable = false)
//    public Service getServiceByServiceId() {
//        return serviceByServiceId;
//    }
//
//    public void setServiceByServiceId(Service serviceByServiceId) {
//        this.serviceByServiceId = serviceByServiceId;
//    }
//}
