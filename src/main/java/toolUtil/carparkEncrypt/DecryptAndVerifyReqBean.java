package toolUtil.carparkEncrypt;

import lombok.Getter;
import lombok.Setter;

/**
 * 解密请求bean
 *
 * @author michael
 * @version 1.0.0
 * @date 2020-01-03
 */
@Getter
@Setter
public class DecryptAndVerifyReqBean {
    /**
     * 聚合商户3des秘钥
     */
    private String tripleDESKey;
    /**
     * 聚合商户md5盐
     */
    private String md5SaltKey;
    /**
     * 加密数据
     */
    private String encrypt;
    /**
     * 签名数据
     */
    private String sign;

    @Override
    public String toString() {
        return "DecryptAndVerifyReqBean [tripleDESKey=" + tripleDESKey + ", md5SaltKey=" + md5SaltKey + ", encrypt="
                + encrypt + ", sign=" + sign + "]";
    }
}