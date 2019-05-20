package xin.yuan.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author熊源新
 * @create2018/12/28
 * @since 1.0.0
 *
 * 客户实体类
 */
public class Customer implements Serializable {
    private Long custId;
    private String custName;
    private String custSource;
    private String custLevel;
    private String custIndustry;
    private String custAddress;
    private String custPhone;

//两个实体之间的关系，此为主表，则添加从表实体集合
    private Set<LinkMan> linkMans = new HashSet<>(0);


    public Customer() {
    }
//这个含参构造子是用来投影查询的
    public Customer(Long custId, String custName) {
        this.custId = custId;
        this.custName = custName;
    }

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


    public Set<LinkMan> getLinkMans() {
        return linkMans;
    }

    public void setLinkMans(Set<LinkMan> linkMans) {
        this.linkMans = linkMans;
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
               // ", custPhone='" + custPhone + '\'' +
                '}';
    }




}
