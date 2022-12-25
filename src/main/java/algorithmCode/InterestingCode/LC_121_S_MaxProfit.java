package algorithmCode.InterestingCode;

/**
 * 121.买卖股票的最佳时机
 *
 * @author bc
 * @date 2022/12/25 20:50
 */
public class LC_121_S_MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        LC_121_S_MaxProfit solution = new LC_121_S_MaxProfit();
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int sell = 0, buy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //卖出的利润=  max（不操作的利润，卖出股票的利润）
            sell = Math.max(sell, buy + prices[i]);
            //买入的利润=  max（不操作的利润，买入股票的利润）
            buy = Math.max(buy, -prices[i]);
        }
        return sell;
    }
}
