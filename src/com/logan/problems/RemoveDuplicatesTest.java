package com.logan.problems;

import com.logan.util.Utils;

/**
 * 
 * 给定一个排序数组，你需要在《原地》删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在《原地》修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @author RongHeMaRongHe
 *
 */
public class RemoveDuplicatesTest {
	public static void main(String[] args) {
		
		int[] nums = {0,0,0,1,2,3,3,3,4,5,5,7,10,10};
		
		int num = removeDuplicates(nums);
		
		for(int i = 0 ; i < num ; i ++) {
			Utils.Print(nums[i]);
		}
		Utils.Print(1);
		Utils.Print(null);
		
//		Utils.Print2(new int[]{1,2,3,4,5},new int[]{1,2,3,4,5,2});
	}

	/**
	 *  remove duplicates item method
	 * @param nums
	 * @return count
	 */
	public static int removeDuplicates(int[] nums) {
		// if null and length equals 0, return 0
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int slowCur = 0;
		int count = 1; // basically there will have one at least
		for(int fastCur = 0 ; fastCur < nums.length ; fastCur ++){
			if(nums[slowCur] != nums[fastCur]){
				slowCur ++;
				nums[slowCur] = nums[fastCur]; // replace 
				count ++;
			}
		}
		return count;
	}
}
