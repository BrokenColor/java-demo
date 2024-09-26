package toolUtil;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: gwl
 * @date: 2024/9/18 17:47
 */
public class CarParkEncryptTest {

    private static String desKey = "Ezjsc1gf8V7yy4/Qrgdz/mc9/THIa6IH";
    private static String saltKey = "R!joJJV6P!#N%SQN";
    public static void main(String[] args) throws Exception {
        //        DesKey：1234567890oiuytrewqasdfghjklmn0
        //        Md5Key：1234567890oiuytrewqasdfghjklmn1
        //        ParkCode：1234567890oiuytrewqasdfghjklmn2
        //        车牌号：京ALF8331   京AL67643
        //        desKey = "1234567890oiuytrewqasdfghjklmn00";
        saltKey = "1234567890oiuytr";
        desKey = "newma0YvKqJS0Kg9eq0vwqeGTz0Oug6K";
        //        saltKey = "Gus@i*kL*d7CF9M3";
        System.out.println(desKey.length());
        System.out.println(saltKey.length());
        String[] carLicenses ={"津BBBBBB","京ABBBBB"};
        for (String carLicense : carLicenses) {
            JSONObject parkingRequest = getParkingRequest("111", carLicense, 1);
            System.out.println(parkingRequest.toJSONString());

            Map<String, String> request = new HashMap<>();
            request.put("cipherJson",parkingRequest.getString("cipherJson"));
            request.put("sign",parkingRequest.getString("sign"));
            System.out.println(decryptPEK(request, desKey, saltKey));
        }
        System.out.println(genDesKey());

    }

    public static String genDesKey() throws Exception {
        // 返回生成指定算法的秘密密钥的 KeyGenerator 对象
        KeyGenerator kg = KeyGenerator.getInstance("DESede");
        // 初始化此密钥生成器，使其具有确定的密钥大小
        kg.init(168);
        // 生成一个密钥
        SecretKey secretKey = kg.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    private static JSONObject getParkingRequest(String airportStationCode, String carLicense, Integer acceptOrder) {
        ParkingOrderRequestBean parkingOrderRequestBean = new ParkingOrderRequestBean();
        parkingOrderRequestBean.setCarLicense(carLicense);
        parkingOrderRequestBean.setAcceptOrder(acceptOrder);

        String json = JSONObject.toJSONString(parkingOrderRequestBean, SerializerFeature.SortField);

        // ****签名
        EncryptAndSignReqBean en = new EncryptAndSignReqBean();
        en.setTripleDESKey(desKey);
        en.setPlain(json);
        en.setMd5SaltKey(saltKey);
        EncryptAndSignResBean ret = SecurityUtils.encryptAndSignAndURLEncoder(en);

        // ****请求参数类
        JSONObject parkingRequest = new JSONObject();
        // ****AppId
        parkingRequest.put("appId", "uuuu115534");
        // ****停车场编码
        parkingRequest.put("parkCode", airportStationCode);
        // ****置加密的业务数据
        parkingRequest.put("cipherJson", ret.getEncrypt());
        // ****设置签名
        parkingRequest.put("sign", ret.getSign());
        return parkingRequest;
    }

    private static DecryptAndVerifyResBean decryptPEK(Map<String, String> request, String desKey, String saltMd5Key) {
        DecryptAndVerifyReqBean decryptAndVerifyReqBean = new DecryptAndVerifyReqBean();
        decryptAndVerifyReqBean.setEncrypt(request.get("cipherJson"));
        decryptAndVerifyReqBean.setTripleDESKey(desKey);
        decryptAndVerifyReqBean.setMd5SaltKey(saltMd5Key);
        decryptAndVerifyReqBean.setSign(request.get("sign"));
        return SecurityUtils.decryptAndVerifyAndURLDecoder(decryptAndVerifyReqBean);
    }
}
