package basetest;

/**
 *  字符串str放入到宽度为n的盒子，
 *  ABCDEFG
 *  ｜A｜F｜G｜
 *  ｜B｜E｜
 *  ｜C｜D｜
 *
 * 输入ABCDEFG
 * 输出 AFG BE CD
 *
 * @Author bc
 * @Date 2023/4/6 16:07
 * @Description: TODO
 */
public class StringBox {
    public static void main(String[] args) {
        handleStr("ABCDEFG", 3);
    }

    private static void handleStr(String str, int n) {
        int strLength = str.length();
        int length = (strLength / 3) + 1;
        char[][] arrs = new char[n][length];
        int rol = 0, col = 0;
        int[][] colmns = {{1, 0}, {0, 1}, {-1, 0}, {0, 1}};
        int colmnIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            arrs[rol][col] = str.charAt(i);
            int tempRol = rol + colmns[colmnIndex][0];
            if (tempRol >= n || tempRol < 0 || colmns[colmnIndex][1] == 1) {
                colmnIndex = (colmnIndex+1) % 4;
            }
            rol += colmns[colmnIndex][0];
            col += colmns[colmnIndex][1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < length; j++) {
                Character c = arrs[i][j];
                if (c != 0) {
                    System.out.print(c);
                }
            }
            System.out.print(" ");
        }
    }

}
