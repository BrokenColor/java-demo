package basetest;

import com.sun.source.tree.AssertTree;
import com.sun.tools.javac.util.Assert;

/**
 * @Author: bc
 * @DateTime: 2020/9/2 下午5:36
 * @Description: 枚举 测试
 */
public class EnumTest {
    private PizzaStatus status;

    public static void main(String[] args) {
        System.out.println(PizzaStatus.ORDERED.name());//ORDERED
        System.out.println(PizzaStatus.ORDERED);//ORDERED
        System.out.println(PizzaStatus.ORDERED.name().getClass());//class java.lang.String
        System.out.println(PizzaStatus.ORDERED.getClass());//class shuang.kou.enumdemo.enumtest.PizzaStatus

        EnumTest enumTest = new EnumTest();
        enumTest.isDeliverable();

        //“ ==”运算符用于比较状态，并且如果两个值均为null 都不会引发 NullPointerException。
        // 相反，如果使用equals方法，将抛出 NullPointerException：
        if(enumTest.getStatus().equals(PizzaStatus.DELIVERED));//抛出 NullPointerException：
        if(enumTest.getStatus() == PizzaStatus.DELIVERED);


        givenPizaOrder_whenReady_thenDeliverable();

        //实际的例子展示
        System.out.println(PinType.FORGET_PASSWORD.getCode());
        System.out.println(PinType.FORGET_PASSWORD.getMessage());
        System.out.println(PinType.FORGET_PASSWORD.toString());

    }

    public static void givenPizaOrder_whenReady_thenDeliverable() {
        EnumTest testPz = new EnumTest();
        testPz.setStatus(EnumTest.PizzaStatus.READY);
        Assert.check(testPz.isDeliverable());
    }

    public boolean isDeliverable() {
        if (getStatus() == PizzaStatus.READY) {
            return true;
        }
        return false;
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    //在 switch 语句中使用枚举类型
    public int getDeliveryTimeInDays() {
        switch (status) {
            case ORDERED: return 5;
            case READY: return 2;
            case DELIVERED: return 0;
        }
        return 0;
    }

    //基础版枚举
    enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }

    /**
     * 你可以通过在枚举类型中定义属性,方法和构造函数让它变得更加强大。
     */
    enum PizzaStatus_2 {
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }

        },
        READY (2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus_2 (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

}

enum PinType {
    REGISTER(100000, "注册使用"),
    FORGET_PASSWORD(100001, "忘记密码使用"),
    UPDATE_PHONE_NUMBER(100002, "更新手机号码使用");

    private final int code;
    private final String message;

    PinType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "PinType{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}

