package com.logan.leetcode.removezero;

/**
 * 
 * 定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 	输入: [0,1,0,3,12]
 * 	输出: [1,3,12,0,0]
 * 说明:
 *	 必须在原数组上操作，不能拷贝额外的数组。
 * 	 尽量减少操作次数。
 * 
 * @author Logan
 *
 */
public class RemoveZeroTester {

	 
	public static void main(String[] args) {
		int[] arr = {0,1,0,3,12};
		for(int num : moveZeroes(arr)) {
			System.out.println(num);
		}
	}
	
	/**
	 * remove zero
	 * 
	 * @param nums
	 * @return
	 */
    public static int[] moveZeroes(int[] nums) {
        
        int index = nums.length -1;
        int lastIndex = index;
        
        while(index >=0){
            if(nums[index] == 0){
                int count = lastIndex - index;
                for(int i = 0 ; i < count ; i++){
                    nums[index + i] = nums[index + i + 1];
                }
                nums[lastIndex] = 0;
                lastIndex --;
            }
            index --;
        }
        return nums;
    }

}
