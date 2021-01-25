package basetest;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class JsonParseObject {
    public static void main(String[] args) {
        String userIdentify = "[{\"code\":\"creditGuarantee\",\"ext\":{\"isFirstOrder\":\"true\",\"isQualifiedV4\":\"true\",\"admitMode\":\"CREDIT_SCORE\"}},{\"code\":\"memberInfoR4\"},{\"code\":\"mk_memberR4\"},{\"code\":\"mk_train\"},{\"code\":\"hotelBargainUser\"},{\"code\":\"dongChengNewUser\"},{\"code\":\"trainUser\"},{\"code\":\"flightMember\"},{\"code\":\"tripUser\"},{\"code\":\"loginUser\"}]";
        List<UserIdentify> userIdentifies = JSONArray.parseArray(userIdentify, UserIdentify.class);
        System.out.println(userIdentify);
    }

    static class UserIdentify {
        /**
         * 身份编码
         */
        String Code;

        /**
         * 扩展信息
         */
        Ext ext;

        public String getCode() {
            return Code;
        }

        public void setCode(String code) {
            Code = code;
        }

        public Ext getExt() {
            return ext;
        }

        public void setExt(Ext ext) {
            this.ext = ext;
        }

        class Ext {
            /**
             * 出于让用户在出错时不会漏看协议或漏激活，设置了这个默认值信用担保和闪住是否首单
             */
            private boolean isFirstOrder;
            /**
             * 只能使用押金闪住
             */
            private boolean isQualifiedV4;
            /**
             * 闪住授信渠道;"CREDIT_SCORE", "信用分";"IOUS", "拿去花"
             */
            private String admitMode;

            /**
             * 可用金额
             */
            private String availMoney;
            /**
             * 错误码
             */
            private int reasonCode;

            public boolean isFirstOrder() {
                return isFirstOrder;
            }

            public void setFirstOrder(boolean firstOrder) {
                isFirstOrder = firstOrder;
            }

            public boolean isQualifiedV4() {
                return isQualifiedV4;
            }

            public void setQualifiedV4(boolean qualifiedV4) {
                isQualifiedV4 = qualifiedV4;
            }

            public String getAdmitMode() {
                return admitMode;
            }

            public void setAdmitMode(String admitMode) {
                this.admitMode = admitMode;
            }

            public String getAvailMoney() {
                return availMoney;
            }

            public void setAvailMoney(String availMoney) {
                this.availMoney = availMoney;
            }

            public int getReasonCode() {
                return reasonCode;
            }

            public void setReasonCode(int reasonCode) {
                this.reasonCode = reasonCode;
            }
        }
    }

}
