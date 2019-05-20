package xin.yuan.domain;
//旅客

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Traveller {
    private Integer id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;

    private String credentialsNum;
    private Integer travellerType;




}
