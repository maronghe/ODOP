package com.logan.problems;

/**
 * This class is used for testing whether there have duplicated number.
 * @author RongHeMaRongHe
 *
 */
public class JudgeDuplicates {

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] {1,2,3,1}));
		System.out.println(containsDuplicate(new int[] {1,2,3,4}));
		System.out.println(containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
	}

	/**
	 * judge duplicate method 
	 * @param nums
	 * @return boolean
	 */
	public static boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length == 0){
			return false;
		}
		for(int i = 0; i < nums.length ; i ++){
			int indexNum = nums[i];
			for(int j = i + 1; j < nums.length - i  ; j++){
				int targetNum = nums[j];
				if(indexNum == targetNum){
					return true;
				}
			}
		}
		return false;
	}
}
