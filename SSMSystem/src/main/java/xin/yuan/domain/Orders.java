package xin.yuan.domain;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

//订单

@Getter
@Setter
@ToString
public class Orders {
    private Integer id;
    private String orderNum;
    private String orderTime;

    private int orderStatus;

    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;

    private String orderDesc;



}
