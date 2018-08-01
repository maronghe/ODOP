package com.logan.leetcode.transfer;

/**
 * 
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 
 * 说明：
 * 
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 
 * 示例 1:
 * 
 * 给定 matrix = 
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * 
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 * 
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ], 
 * 
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * 
 * @author RongHeMaRongHe
 *
 */
public class TransferTester {
	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		// int[][] arr2 = {
		// {1,2,3},
		// {4,5,6},
		// {7,8,9}
		// };
		System.out.println("====原始数组====");
		print(arr);
		System.out.println("===顺时针旋转====");
		clockwiseTransfer(arr);
		print(arr);
		System.out.println("==逆时针旋转==");
		anticlockwiseTransfer(arr);
		print(arr);
		System.out.println("==第一次上下翻转==");
		topBottomTransfer(arr);
		print(arr);
		System.out.println("==第二次上下翻转==");
		topBottomTransfer(arr);
		print(arr);
		System.out.println("=第一次左右翻转==");
		leftRightTransfer(arr);
		print(arr);
		System.out.println("=第二次左右翻转==");
		leftRightTransfer(arr);
		print(arr);
	}

	/**
	 * 顺时针旋转
	 * 
	 * @param arr
	 * @return
	 */
	public static int[][] clockwiseTransfer(int[][] arr) {
		int length = arr.length;
		// 奇数移动 (int)(length / 2)次；偶数移动 (length / 2)次
		for (int i = 0; i < length / 2; i++) {
			// 每层移动边长减1次
			for (int j = i; j < length - i - 1; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[length - j - 1][i];
				arr[length - j - 1][i] = arr[length - i - 1][length - j - 1];
				arr[length - i - 1][length - j - 1] = arr[j][length - i - 1];
				arr[j][length - i - 1] = temp;
			}
		}
		return arr;
	}

	/**
	 * 逆时针旋转
	 * 
	 * @param arr
	 * @return
	 */
	public static int[][] anticlockwiseTransfer(int[][] arr) {
		int length = arr.length;
		// 奇数移动 (int)(length / 2)次；偶数移动 (length / 2)次
		for (int i = 0; i < length / 2; i++) {
			// 每层移动边长减1次
			for (int j = i; j < length - i - 1; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][length - i - 1];
				arr[j][length - i - 1] = arr[length - i - 1][length - j - 1];
				arr[length - i - 1][length - j - 1] = arr[length - j - 1][i];
				arr[length - j - 1][i] = temp;
			}
		}
		return arr;
	}

	/**
	 * 上下翻转
	 * 
	 * @param arr
	 * @return
	 */
	public static int[][] topBottomTransfer(int[][] arr) {
		int length = arr.length;
		for (int i = 0; i < length / 2; i++) {
			for (int j = 0; j < length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[length - i - 1][j];
				arr[length - i - 1][j] = temp;
			}
		}
		return arr;
	}

	/**
	 * 左右翻转
	 * 
	 * @param arr
	 * @return
	 */
	public static int[][] leftRightTransfer(int[][] arr) {
		int length = arr.length;
		for (int i = 0; i < length / 2; i++) {
			for (int j = 0; j < length; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[j][length - i - 1];
				arr[j][length - i - 1] = temp;
			}
		}
		return arr;
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
