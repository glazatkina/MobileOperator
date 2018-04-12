//package ru.tsystems.javaschool.mobile_operator.entity;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "option_option", schema = "mobile_operator", catalog = "")
//public class OptionOption {
//    private long id;
//    private long optionId1;
//    private long optionId2;
//    private boolean isBinded;
//    private Option optionByOptionId1;
//    private Option optionByOptionId2;
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
//    @Column(name = "option_id_1", nullable = false)
//    public long getOptionId1() {
//        return optionId1;
//    }
//
//    public void setOptionId1(long optionId1) {
//        this.optionId1 = optionId1;
//    }
//
//    @Basic
//    @Column(name = "option_id_2", nullable = false)
//    public long getOptionId2() {
//        return optionId2;
//    }
//
//    public void setOptionId2(long optionId2) {
//        this.optionId2 = optionId2;
//    }
//
//    @Basic
//    @Column(name = "is_binded", nullable = false)
//    public boolean isBinded() {
//        return isBinded;
//    }
//
//    public void setBinded(boolean binded) {
//        isBinded = binded;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OptionOption that = (OptionOption) o;
//        return id == that.id &&
//                optionId1 == that.optionId1 &&
//                optionId2 == that.optionId2 &&
//                isBinded == that.isBinded;
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, optionId1, optionId2, isBinded);
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "option_id_1", referencedColumnName = "id", nullable = false)
//    public Option getOptionByOptionId1() {
//        return optionByOptionId1;
//    }
//
//    public void setOptionByOptionId1(Option optionByOptionId1) {
//        this.optionByOptionId1 = optionByOptionId1;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "option_id_2", referencedColumnName = "id", nullable = false)
//    public Option getOptionByOptionId2() {
//        return optionByOptionId2;
//    }
//
//    public void setOptionByOptionId2(Option optionByOptionId2) {
//        this.optionByOptionId2 = optionByOptionId2;
//    }
//}
