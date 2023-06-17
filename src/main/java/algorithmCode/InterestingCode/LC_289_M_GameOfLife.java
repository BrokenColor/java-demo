package algorithmCode.InterestingCode;

import java.util.Arrays;

/**
 *
 */
public class LC_289_M_GameOfLife {

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        LC_289_M_GameOfLife solution = new LC_289_M_GameOfLife();
        solution.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[] neighbors = {0, 1, -1};

        int[][] board_copy = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board_copy[i][j] = board[i][j];
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int neighborsLive = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (neighbors[i] == 0 && neighbors[j] == 0) {
                            continue;
                        }
                        int r = row + neighbors[i];
                        int c = col + neighbors[j];
                        if (r >= 0 && r < rows && c >= 0 && c < cols && board_copy[r][c] == 1) {
                            neighborsLive++;
                        }
                    }
                }

                if (board_copy[row][col] == 1 && (neighborsLive < 2 || neighborsLive > 3)) {
                    board[row][col] = 0;
                } else if (board_copy[row][col] == 0 && neighborsLive == 3) {
                    board[row][col] = 1;
                }

            }
        }
    }
}
