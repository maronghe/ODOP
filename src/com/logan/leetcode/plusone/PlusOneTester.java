package com.logan.leetcode.plusone;

/**
 * 
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 	输入: [1,2,3]
 * 	输出: [1,2,4]
 * 	解释: 输入数组表示数字 123。
 * 示例 2:
 * 	输入: [4,3,2,1]
 * 	输出: [4,3,2,2]
 * 	解释: 输入数组表示数字 4321。
 * 
 * @author Logan
 *
 */
public class PlusOneTester {
	
	public static void main(String[] args) {
		
		int [] arr = {9,9,0,9};
		for(int num : plusOne(arr)) {
			System.out.println(num);
		}
	}

	/**
	 * plus one 
	 * @param digits
	 * @return arr
	 */
    public static int[] plusOne(int[] digits) {
    	int size = digits.length;
    	for (int i = size - 1; i >= 0; i --) {
    		//judge the number from the last one to the first  
			if(digits[i] < 9) {
				digits[i] ++ ;
				return digits;
			}
			digits[i] = 0;
		}
    	
    	// all equals 9 and return size + 1 's array
    	int[] arr = new int[size + 1];
    	arr[0] = 1;
    	return arr;
    }
}
