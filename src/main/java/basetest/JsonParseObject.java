package basetest;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.List;

public class JsonParseObject {
    public static void main(String[] args) {
        String userIdentify = "[{\"code\":\"creditGuarantee\",\"ext\":{\"isFirstOrder\":\"true\",\"isQualifiedV4\":\"true\",\"admitMode\":\"CREDIT_SCORE\"}},{\"code\":\"memberInfoR4\"},{\"code\":\"mk_memberR4\"},{\"code\":\"mk_train\"},{\"code\":\"hotelBargainUser\"},{\"code\":\"dongChengNewUser\"},{\"code\":\"trainUser\"},{\"code\":\"flightMember\"},{\"code\":\"tripUser\"},{\"code\":\"loginUser\"}]";
        String userIdentify1 = "[{\"code\":\"creditCheck\",\"ext\":\"{\\\"admitMode\\\":\\\"CREDIT_SCORE\\\",\\\"zhiMaMiscDebt\\\":false,\\\"isQualifiedV4\\\":false,\\\"isFirstOrder\\\":true,\\\"availMoney\\\":\\\"10000.00\\\",\\\"reasonCode\\\":0}\"},{\"code\":\"creditGuarantee\"},{\"code\":\"newUser\"},{\"code\":\"hStarFirst\"},{\"code\":\"mk_newUser\"},{\"code\":\"mk_hStarFirst\"},{\"code\":\"huaZhuNewUser\"},{\"code\":\"ruJiaNewUser\"},{\"code\":\"dongChengNewUser\"},{\"code\":\"yaDuoNewUser\"},{\"code\":\"loginUser\"}]";
        String tmp = StringEscapeUtils.unescapeJavaScript(userIdentify);
        String tmp1 = StringEscapeUtils.unescapeJavaScript(userIdentify1);
        List<UserIdentify> userIdentifies = JSONArray.parseArray(userIdentify, UserIdentify.class);
        List<UserIdentify> userIdentifies1 = JSONArray.parseArray(userIdentify1, UserIdentify.class);
        List<UserIdentify> tmps = JSONArray.parseArray(tmp, UserIdentify.class);
        List<UserIdentify> tmp1s = JSONArray.parseArray(tmp1, UserIdentify.class);
        System.out.println(userIdentify);
    }

    static class UserIdentify {
        /**
         * 身份编码
         */
        String code;

        /**
         * 扩展信息
         */
        String ext;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            code = code;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }
    }

}
