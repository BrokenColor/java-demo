package basetest;

public class Ｂitwise {
    public static void main(String[] args) {
        int i = 12;
//        int i = -12;

        //将一个数的各二进制位全部右移N位，移到右边的低位被舍弃，对于无符号数高位补0，负数高位补1.
        int a = i >> 0;
        int a1 = i >> 1;
        int a2 = i >> 2;
        int a3 = i >> 3;
        //将一个数的各二进制位全部左移N位，右补0
        int b = i << 0;
        int b1 = i << 1;
        int b2 = i << 2;
        int b3 = i << 3;

        //>>表示带符号移动
        System.out.println("a: " + a);
        System.out.println("a1:" + a1);
        System.out.println("a2:" + a2);
        System.out.println("a3:" + a3);
        System.out.println("b: " + b);
        System.out.println("b1:" + b1);
        System.out.println("b2:" + b2);
        System.out.println("b3:" + b3);

        //>>>表示不带符号向右移动二进制数，移动后前面统统补0
        int c = i >>> 0;
        int c1 = i >>> 1;
        int c2 = i >>> 2;
        int c3 = i >>> 3;
        //没有<<<这种运算符，因为左移都是补零，没有正负数的区别
//        int d = i <<< 0;
//        int d1 = i <<< 1;
//        int d2 = i <<< 2;
//        int d3 = i <<< 3;

        System.out.println("c: " + c);
        System.out.println("c1:" + c1);
        System.out.println("c2:" + c2);
        System.out.println("c3:" + c3);
//        System.out.println("d: " + d);
//        System.out.println("d1:" + d1);
//        System.out.println("d2:" + d2);
//        System.out.println("d3:" + d3);

    }
}
