package com.logan.problems;

import com.logan.util.Utils;

/**
 * 
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 * ���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
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
