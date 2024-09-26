package toolUtil.carparkEncrypt;

import lombok.Getter;
import lombok.Setter;

/**
 * 加解密辅助工具bean
 *
 * @author michael
 * @version 1.0.0
 * @date 2020-01-03
 */
@Getter
@Setter
public class EncryptAndSignReqBean {
    /**
     * 聚合商户3des秘钥
     */
    private String tripleDESKey;

    /**
     * 聚合商户md5盐
     */
    private String md5SaltKey;

    /**
     * 聚合明文数据:必须为json格式
     */
    private String plain;

    @Override
    public String toString() {
        return "EncryptAndSignReqBean [tripleDESKey=" + tripleDESKey + ", md5SaltKey=" + md5SaltKey + ", plain=" + plain
                + "]";
    }
}