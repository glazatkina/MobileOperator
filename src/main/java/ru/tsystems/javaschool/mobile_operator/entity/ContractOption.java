//package ru.tsystems.javaschool.mobile_operator.entity;
//
//import javax.persistence.*;
//import java.sql.Date;
//import java.util.Objects;
//
//@Entity
//@Table(name = "contract_option", schema = "mobile_operator", catalog = "")
//public class ContractOption {
//    private long id;
//    private long contractId;
//    private long optionId;
//    private Date startDate;
//    private Date endDate;
//    private boolean isActive;
//    private Contract contractByContractId;
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
//    @Column(name = "contract_id", nullable = false)
//    public long getContractId() {
//        return contractId;
//    }
//
//    public void setContractId(long contractId) {
//        this.contractId = contractId;
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
//    @Basic
//    @Column(name = "start_date", nullable = false)
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    @Basic
//    @Column(name = "end_date", nullable = true)
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }
//
//    @Basic
//    @Column(name = "is_active", nullable = false)
//    public boolean isActive() {
//        return isActive;
//    }
//
//    public void setActive(boolean active) {
//        isActive = active;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ContractOption that = (ContractOption) o;
//        return id == that.id &&
//                contractId == that.contractId &&
//                optionId == that.optionId &&
//                isActive == that.isActive &&
//                Objects.equals(startDate, that.startDate) &&
//                Objects.equals(endDate, that.endDate);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, contractId, optionId, startDate, endDate, isActive);
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "contract_id", referencedColumnName = "id", nullable = false)
//    public Contract getContractByContractId() {
//        return contractByContractId;
//    }
//
//    public void setContractByContractId(Contract contractByContractId) {
//        this.contractByContractId = contractByContractId;
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
