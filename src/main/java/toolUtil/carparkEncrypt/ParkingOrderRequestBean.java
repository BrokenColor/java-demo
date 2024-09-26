package toolUtil.carparkEncrypt;

import lombok.Data;

/**
 * 获取停车记录接口接口参数实例
 *
 * @author yzp
 * @version 1.0.0
 * @date 2023年06月29日20:57:12
 */
@Data
public class ParkingOrderRequestBean {

    /**
     * 车牌号
     */
    private String carLicense;

    private Integer acceptOrder = 0;

}
