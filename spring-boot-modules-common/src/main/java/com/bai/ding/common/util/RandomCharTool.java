package com.bai.ding.common.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author BaiDing
 * @date 2020/3/9 23:58
 */
public class RandomCharTool {
	private static final char[] radix64 = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z', '-', '_' };

	/**
	 * 任意字符串转化成64进制字符串，包含大小写字母、数字、-、_。以utf8编码转化参数
	 * 
	 * @param src
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String toRadix64(String src) throws UnsupportedEncodingException {
		BigInteger md5 = new BigInteger(src.getBytes("utf8"));
		BigInteger radix = new BigInteger("64");
		StringBuilder result = new StringBuilder(0);
		while (!md5.equals(BigInteger.ZERO)) {
			BigInteger tmp = md5.divide(radix);
			result.append(radix64[md5.mod(radix).intValue()]);
			md5 = tmp;
		}
		return result.toString();
	}

	/**
	 * 获取随机字母数字组合
	 * 
	 * @param length
	 *            字符串长度
	 * @return
	 */
	public static String getRandomCharAndNumr(Integer length) {
		StringBuilder str = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			boolean b = random.nextBoolean();
			if (b) { // 字符串
				// int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母
				str.append((char) (65 + random.nextInt(26)));// 取得大写字母
			} else { // 数字
				str.append(String.valueOf(random.nextInt(10)));
			}
		}
		return str.toString();
	}

	/**
	 * 验证随机字母数字组合是否纯数字与纯字母
	 * 
	 * @param str
	 * @return true 是 ， false 否
	 */
	public static boolean isRandomUsable(String str) {
		String regExp = "^([0-9]+)|([A-Za-z]+)$";
		Pattern pat = Pattern.compile(regExp);
		Matcher mat = pat.matcher(str);
		return mat.matches();
	}

	public static void main(String[] args) {
//		System.out.println("8位随机码：" + getRandomCharAndNumr(8));
//		String str = getRandomCharAndNumr(8);
//		System.out.println("["+str+"]是否为纯数字或纯字母："+isRandomUsable(str));
	}
}
