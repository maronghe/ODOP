package com.logan.leetcode.validSudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 示例 1:

 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * 
 * @author Logan
 *
 */
public class ValidSudokuTester {

	public static void main(String[] args) {
		char[][] c = { 
				{ '.', '.', '.', '.', '5', '.', '.', '1', '.' },
				{ '.', '4', '.', '3', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '3', '.', '.', '1' },
				{ '8', '.', '.', '.', '.', '.', '.', '2', '.' },
				{ '.', '.', '2', '.', '7', '.', '.', '.', '.' },
				{ '.', '1', '5', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '2', '.', '.', '.' }, 
				{ '.', '2', '.', '9', '.', '.', '.', '.', '.' },
				{ '.', '.', '4', '.', '.', '.', '.', '.', '.' }

		};

		System.out.println(isValidSudoku(c));
	}

	/**
	 *  Judge validSudoku
	 *  
	 * @param board
	 * @return
	 */
	public static boolean isValidSudoku(char[][] board) {

		// all landscape
		Set<Character> landscapeSet = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c == '.') {
					continue;
				}
				if (landscapeSet.contains(c)) {
					return false;
				}
				landscapeSet.add(c);
			}
			landscapeSet.clear();
		}

		// all portrait
		Set<Character> portraitMap = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[j][i];
				if (c == '.') {
					continue;
				}
				if (portraitMap.contains(c)) {
					return false;
				}
				portraitMap.add(c);
			}
			portraitMap.clear();
		}

		//  all 3*3
		Set<Character> threeSet = new HashSet<Character>();
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						int x = k * 3 + i;
						int y = l * 3 + j;
						//System.out.println("(" + x + "," + y + ")");
						char c = board[x][y];
						if (c == '.') {
							continue;
						}
						if (threeSet.contains(c)) {
							return false;
						}
						threeSet.add(c);
					}
				}
				//System.out.println("Clear");
				threeSet.clear();
			}
		}

		return true;
	}
}
