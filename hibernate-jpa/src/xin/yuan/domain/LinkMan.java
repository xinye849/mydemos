package xin.yuan.domain;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author熊源新
 * @create2018/12/30
 * @since 1.0.0
 * jpa注解实现实体类与数据库表的映射
 */

@Entity
@Table(name = "link_linkman")
public class LinkMan implements Serializable {
    @Id()
    @Column(name="lkm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//strategy:策略
    private Long lkmId;
    @Column(name = "lkm_name")
    private  String lkmName;
    @Column(name = "lkm_gender")
    private  String lkmGender;
    @Column(name = "lkm_phone")
    private String lkmPhone;
    @Column(name = "lkm_monil")
    private String lkmMobil;
    @Column(name = "lkm_email")
    private String lkmEmail;
    @Column(name = "lkm_position")
    private String lkmPosition;
    @Column(name = "lkm_mimo")
    private String lkmMemo;



//多对一关系映射

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "lkm_cut_id",referencedColumnName = "cust_id")//加外键，外键对应（referencedColumnName)主表中的主键
    private Customer customer = new Customer();





    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmMobil() {
        return lkmMobil;
    }

    public void setLkmMobil(String lkmMobil) {
        this.lkmMobil = lkmMobil;
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail;
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "lkmId=" + lkmId +
                ", lkmName='" + lkmName + '\'' +
                ", lkmGender='" + lkmGender + '\'' +
                ", lkmPhone='" + lkmPhone + '\'' +
                ", lkmMobil='" + lkmMobil + '\'' +
                ", lkmEmail='" + lkmEmail + '\'' +
                ", lkmPosition='" + lkmPosition + '\'' +
                ", lkmMemo='" + lkmMemo + '\'' +
                '}';
    }
}
