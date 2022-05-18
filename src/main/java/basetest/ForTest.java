package basetest;

/**
 * @author bc
 * @date 2022/5/17 17:09
 */
public class ForTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {10, 20, 30, 40, 50};
        for (int i : arr) {
            if (i == 3) continue;
            System.out.println(i);
            for (int i1 : arr2) {
                //只会结束最里层的loop
                if (i1 == 30) break;
                System.out.print(i1 + " ");
            }
            System.out.println();
        }
        System.out.println("=======");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 3) continue;
            System.out.println(arr[i]);
            for (int i1 = 0; i1 < arr2.length; i1++) {
                //只会结束最里层的loop
                if (arr2[i1] == 30) break;
                System.out.print(arr2[i1] + " ");
            }
            System.out.println();
        }

    }
}
