package xin.yuan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**产品信息
 * @authorknightx
 * @create2019/5/3
 * @since 1.0.0
 */

@ToString
@Setter
@Getter
public class Product implements Serializable {

    private Integer id;

    private String productNum;

    private String productName;

    private String cityName;

    private String depatureTime;

    private Double productPrice;

    private String productDesc;

    private Integer productStatus;


}
