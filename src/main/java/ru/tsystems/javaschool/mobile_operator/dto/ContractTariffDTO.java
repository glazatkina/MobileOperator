package ru.tsystems.javaschool.mobile_operator.dto;

import ru.tsystems.javaschool.mobile_operator.entity.Contract;
import ru.tsystems.javaschool.mobile_operator.entity.ContractTariff;
import ru.tsystems.javaschool.mobile_operator.entity.Tariff;

import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Date;

public class ContractTariffDTO implements Serializable, AbstractDTO<ContractTariff> {
    private long id;
    private Date startDate;
    private Date endDate;
    @Transient
    private ContractDTO contractDTO;
    @Transient
    private TariffDTO tariffDTO;

    public ContractTariffDTO() {
    }

    public ContractTariffDTO(long id, Date startDate, Date endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ContractTariffDTO(ContractTariff contractTariff) {
        this.id = contractTariff.getId();
        this.startDate = contractTariff.getStartDate();
        this.endDate = contractTariff.getEndDate();
    }

    public void fill(Contract contract, Tariff tariff) {
        contractDTO = new ContractDTO(contract);
        tariffDTO = new TariffDTO(tariff);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ContractDTO getContractDTO() {
        return contractDTO;
    }

    public void setContractDTO(ContractDTO contractDTO) {
        this.contractDTO = contractDTO;
    }

    public TariffDTO getTariffDTO() {
        return tariffDTO;
    }

    public void setTariffDTO(TariffDTO tariffDTO) {
        this.tariffDTO = tariffDTO;
    }

    @Override
    public String toString() {
        return "ContractTariffDTO{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", contractDTO=" + contractDTO +
                ", tariffDTO=" + tariffDTO +
                '}';
    }

    @Override
    public ContractTariff toEntity() {
        return null;
    }
}
