package xin.yuan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @authorknightx
 * @create2019/4/25
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;
}
