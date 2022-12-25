package algorithmCode.InterestingCode;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author bc
 * @date 2021/12/17 10:24
 */
public class LC_122_M_MaxProfit {
    public static void main(String[] args) {
        LC_122_M_MaxProfit solution = new LC_122_M_MaxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }
}
