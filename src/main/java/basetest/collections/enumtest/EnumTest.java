package basetest.collections.enumtest;

/**
 * @author guwanli
 * @date 2021/10/13 11:21 上午
 */
public class EnumTest {

    public static void main(String[] args) {
        demoEnum jack = demoEnum.valueOf("jack");
        demoEnum mary = demoEnum.valueOf("MARY");
        System.out.println(jack.equals(demoEnum.JACK));
        System.out.println(mary.equals(demoEnum.MARY));
    }
}

enum demoEnum {
    JACK("jack", 18),
    MARY("mary", 17),
    ;

    demoEnum(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;
}
