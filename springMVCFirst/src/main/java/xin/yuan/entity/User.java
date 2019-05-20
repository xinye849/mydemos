package xin.yuan.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @authorknightx
 * @create2019/4/13
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
public class User implements Serializable {
    private String name;
    private String age;
    private String gender;
    private String account;
    private GirlFriend girlFriend;
    private List<GirlFriend> girlFriendList;
    private Map<String,GirlFriend> girlFriendMap;
}
