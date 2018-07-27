package com.logan.leetcode.intersect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个数组，写一个方法来计算它们的交集。
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 * 注意：
 *    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *    我们可以不考虑输出结果的顺序。
 * 跟进:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？  答：直接从头比较
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？      答：intersect2
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 * 
 * @author Logan
 *
 */
public class IntersectTester {
	
	public static void main(String[] args) {
		
		int[] array1 = { 2, 1 };
		int[] array2 = { 1, 2 };
		int[] result = intersect(array1, array2);
		for (Integer i : result) {
			System.out.println(i);
		}

	}

	/**
	 * Count out number and number size. 
	 * Judge whether the other array contains key.
	 * 
	 * @param nums1
	 * @param nums2
	 * @return result 
	 */
	public static int[] intersect(int[] nums1, int[] nums2) {

		List<Integer> list = new ArrayList<Integer>();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums1.length; i++) {
			Integer v = map.get(nums1[i]);
			map.put(nums1[i], v == null ? 1 : (v + 1));
		}

		for (int j = 0; j < nums2.length; j++) {
			// judge whether contains key
			if (map.containsKey(nums2[j]) && map.get(nums2[j]) != 0) {
				list.add(nums2[j]);
				map.put(nums2[j], map.get(nums2[j]) - 1);
			}
		}

		int[] result = new int[list.size()];

		for (int k = 0; k < list.size(); k++) {
			result[k] = list.get(k);
		}

		return result;
	}

	/**
	 *  Sort array and judge whether equals from 0 to the smaller array's size
	 *  this method is suitable for the large different size between two arrays. 
	 * @param nums1
	 * @param nums2
	 * @return result 
	 */
	public static int[] intersect2(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<Integer>();

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0;
		int j = 0;

		if (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				j++;
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			}
		}

		int[] result = new int[list.size()];

		for (int k = 0; k < list.size(); k++) {
			result[k] = list.get(k);
		}

		return result;
	}

}
