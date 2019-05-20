package xin.yuan.domain;
//会员

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Member {
    private Integer id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;


}
