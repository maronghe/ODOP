package com.logan.problems;

import com.logan.util.Utils;

/**
 * 
 * ����һ���������飬����Ҫ�ڡ�ԭ�ء�ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬������ڡ�ԭ�ء��޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
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
