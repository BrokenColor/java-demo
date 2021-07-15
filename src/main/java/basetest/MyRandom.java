package basetest;

/**
 * Description:
 * <p>
 * Author: GWL
 * Date: Create in 20:10 2021/7/14
 */
public class MyRandom {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.print(myRandom(1,10) + ",");
        }

    }
    public static int myRandom(int n, int m){
        double random = Math.random();
        return (int) ((m-n)*random + n);
    }
}
