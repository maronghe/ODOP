package com.logan.util;

/**
 * This is a util class.
 * @author RongHeMaRongHe
 *
 */
public class Utils {
	
	
	/**
	 * print method
	 * @param obj
	 */
	public static void Print(Object obj) {
		System.out.println(obj);
	}

	
	/**
	 * print test 2
	 * @param obj
	 */
	public static void Print2(Object... objs) {
		if(objs.length != 0) {
			for(Object o : objs) {
				System.out.print(o + " ");
			}
		}
		System.out.println();
	}
}
