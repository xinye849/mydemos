package xin.yuan.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author熊源新
 * @create2018/12/28
 * @since 1.0.0
 * 用----jpa规范------
 *用jpa规范实现实体类与数据库表的映射
 * 使用的注解都是jpa规范
 * 客户实体类
 */

@Entity
@Table(name = "cust_customer")
public class Customer implements Serializable {




@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "cust_id")
    private Long custId;
@Column(name = "cust_name")
    private String custName;
@Column(name = "cust_source")
    private String custSource;
@Column(name = "cust_level")
    private String custLevel;
@Column(name = "cust_industry")
    private String custIndustry;
@Column(name = "cust_address")
    private String custAddress;
@Column(name = "cust_phone")
    private String custPhone;










    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
       return custPhone;
    }

    public void setCustPhone(String custPhone) {
       this.custPhone = custPhone;
    }




    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custAddress='" + custAddress + '\'' +
               ", custPhone='" + custPhone + '\'' +
                '}';
    }




}
