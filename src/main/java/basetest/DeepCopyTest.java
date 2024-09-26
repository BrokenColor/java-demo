package basetest;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: gwl
 * @date: 2024/8/6 11:18
 */
public class DeepCopyTest {
    public static void main(String[] args) {

        DeepCopyTest deepCopyTest = new DeepCopyTest();
        TestA a = new TestA();
        a.setA(1);
        a.setStrb("a");
        List<TestB> list = new ArrayList<>();
        list.add(new TestB(1, "b1"));
        list.add(new TestB(2, "b2"));
        list.add(new TestB(3, "b3"));
        a.setList(list);
        deepCopyTest.test1(a);
        deepCopyTest.test2(a);
    }

    public void test1(TestA a) {
        System.out.println("test1====");
        for (TestB testB : a.getList()) {
            System.out.println("test1:"+JSONObject.toJSONString(testB));
            testB.setStrb("c" + testB.getA());
        }
    }

    public void test2(TestA a) {
        System.out.println("test2====");
        for (TestB testB : a.getList()) {
            System.out.println("test2:" + JSONObject.toJSONString(testB));
        }
    }
}

class TestA {
    private Integer a;
    private String Strb;
    private List<TestB> list;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getStrb() {
        return Strb;
    }

    public void setStrb(String strb) {
        Strb = strb;
    }

    public List<TestB> getList() {
        return list;
    }

    public void setList(List<TestB> list) {
        this.list = list;
    }
}

class TestB {
    private Integer a;
    private String Strb;

    public TestB(Integer a, String strb) {
        this.a = a;
        Strb = strb;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getStrb() {
        return Strb;
    }

    public void setStrb(String strb) {
        Strb = strb;
    }
}
