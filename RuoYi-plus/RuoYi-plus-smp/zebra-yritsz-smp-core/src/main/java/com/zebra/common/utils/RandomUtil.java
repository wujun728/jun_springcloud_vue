package com.zebra.common.utils;

public class RandomUtil {

	/**
	 * 产生n位随机数
	 * 
	 * @return
	 */
	public static long generateRandomNumber(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("随机数位数必须大于0");
		}
		return (long) (Math.random() * 9 * Math.pow(10, n - 1)) + (long) Math.pow(10, n - 1);
	}

}
