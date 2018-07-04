package com.logan.problems;

import com.logan.util.Utils;

/**
 * 
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author RongHeMaRongHe
 *
 */
public class MaxProfit {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		Utils.Print(maxProfit(prices));
		Utils.Print("------------");
		Utils.Print(maxProfit(new int[] { 1, 2, 3, 4, 5 }));
		Utils.Print("------------");
		Utils.Print(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	/**
	 * to ensure the following data is bigger than the price which I bought just
	 * now, And the following item will have the smaller one and ...
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		boolean isHave = false;
		int profit = 0;
		int currentValue = 0;
		int currentProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			// buy
			if (!isHave && prices[i] < prices[i + 1]) {
				currentValue = prices[i];
				isHave = true;
			} else if (prices[i] > prices[i + 1]) {
				if (isHave) {
					if (prices[i] - currentValue > 0) {
						// sell
						currentProfit = prices[i] - currentValue;
						profit += currentProfit;
						isHave = false;
					}
				}
			}
		}
		// sell last one
		if (isHave) {
			currentProfit = prices[prices.length - 1] - currentValue;
			profit += currentProfit;
			isHave = false;
		}
		return profit;
	}
}
