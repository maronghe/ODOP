package com.logan.leetcode.sum;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * @author Logan
 *
 */
public class TwoNumberSumTester {

	public static void main(String[] args) {
		 for(int num : twoSum(new int[] {1,4,2}, 6)) {
			 System.out.println(num);
		 }
	}

	/**
	 * Getting the index for the meet the target
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length <= 1) {
			return new int[] {};
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int n1 = nums[i];
				int n2 = nums[j];
				if (n1 + n2 == target) {
					return new int[] { i, j };
				}
			}
		}

		return new int[] {};
	}

	
}
