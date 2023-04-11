package basetest;

/**
 * @Author bc
 * @Date 2023/3/29 09:37
 * @Description:
 */
public class ConstructTest {
    private static ConstructTest A = new ConstructTest();

    private static int a;
    private static int b = 0;

    static {
        System.out.println("static:"+A.a+" "+A.b);
    }

    {
        System.out.println("no static:"+A.a+" "+A.b);
    }

    public ConstructTest() {
        a++;
        b++;
    }

    public static void main(String[] args) {
        System.out.println("main:"+A.a+" "+A.b);
//        System.out.println(A.a1);
    }
}
