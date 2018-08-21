package com.logan.leetcode.range;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Leetcode num : 228 汇总区间
 *  
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * 
 * 示例 1:
 * 
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 * 
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 * @author Logan
 *
 */
public class RangeArrayTest {
	public static void main(String[] args) {
		// 测试用例
		int[] nums = {0,1,2,4,5,7};
		Solution solution = new Solution();
		List<String> result = solution.summaryRanges(nums);
		// 迭代遍历结果集
		Iterator<String> it = result.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
}
class Solution {
    public List<String> summaryRanges(int[] nums) {
    	// 定义结果集
        List<String> list = new ArrayList<String>();
        int pos = 0; // 初始游标
        while(pos < nums.length){
        	// 定义每部分内容
            StringBuilder sb = new StringBuilder();
            sb.append(nums[pos]);
            int temp = pos; // 指定每一阶段的开始游标
            while(pos + 1 < nums.length && nums[pos + 1] == nums[pos] + 1 )
                pos ++;
            // 添加每项结果
            if(pos != temp){
                sb.append("->").append(nums[pos]);
            }
            list.add(sb.toString());    
            pos ++;
        }
        return list;
    }
}
