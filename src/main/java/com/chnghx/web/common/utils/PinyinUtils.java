package com.chnghx.web.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.log4j.Logger;

public class PinyinUtils {
	private static final Logger logger = Logger.getLogger(PinyinUtils.class);
	final static char[] array = { '~', '!', '@', '#', '$', '%', '^', '&', '&', '*', '(', ')', '_', '+', '-', '=', '[',
			']', '\\', ';', ',', '.', '/', '{', '}', '|', '"', '<', '>', '?' };// 英文字符全

	/**
	 * 将某个字符串的首字母 大写
	 * 
	 * @param str
	 * @return
	 */
	private static HashMap<String, String> convertInitialToUpperCase(String str) {
		HashMap<String, String> srtMap = new HashMap<String, String>();
		if (str == null) {
			return null;
		}
		StringBuffer all_py = new StringBuffer(); // 全拼
		String first_py = "";// 首字母
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (i == 0) {
				all_py.append(String.valueOf(ch).toUpperCase());
				first_py = String.valueOf(ch);
			} else {
				all_py.append(ch);
			}
		}
		srtMap.put("all_py", all_py.toString());
		srtMap.put("first_py", first_py);
		return srtMap;
	}

	/**
	 * 汉字转拼音 最大匹配优先
	 * 
	 * @param chinese
	 * @return
	 */
	public static HashMap<String, String> converterToSpell(String chinese) {
		HashMap<String, String> pinYinMap = new HashMap<String, String>();

		StringBuffer allWord = new StringBuffer();
		StringBuffer firstWord = new StringBuffer();

		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

		char[] arr = chinese.toCharArray();

		for (int i = 0; i < arr.length; i++) {

			char ch = arr[i];

			if (ch > 128) { // 非ASCII码
				try {

					String[] results = PinyinHelper.toHanyuPinyinStringArray(ch, defaultFormat);

					if (results == null) { // 非中文

						// allWord.append(results);
					} else {

						String[] resultArray = duplicateRemoval(results);

						int len = resultArray.length;

						if (len == 1) { // 不是多音字
							String py = resultArray[0];
							if (py.contains("u:")) { // 过滤 u:
								py = py.replace("u:", "v");
								System.out.println("filter u:" + py);
							}
							HashMap<String, String> pyMap = convertInitialToUpperCase(py);
							allWord.append(pyMap.get("all_py"));
							firstWord.append(pyMap.get("first_py"));

						} else { // 多音字

							System.out.println("多音字：" + ch);

							int length = chinese.length();

							boolean flag = false;

							String s = null;

							List<String> keyList = null;

							for (int x = 0; x < len; x++) {

								String py = resultArray[x];

								if (py.contains("u:")) { // 过滤 u:
									py = py.replace("u:", "v");
									System.out.println("filter u:" + py);
								}
								String pinyinString = PinYinPropertiesManager.getString(py);
								try {
									pinyinString = new String(pinyinString.getBytes("UTF-8"));
								} catch (UnsupportedEncodingException e) {
									e.printStackTrace();
									logger.error("汉字转拼音出现异常:" + e.getMessage());
								}

								String[] ps_array = pinyinString.split(" ");
								keyList = Arrays.asList(ps_array);

								// 向后匹配两个汉字
								if (i + 3 <= length) {
									s = chinese.substring(i, i + 3);
									if (keyList != null && (keyList.contains(s))) {

										System.out.println("last 2 > " + py);
										HashMap<String, String> pyMap = convertInitialToUpperCase(py);
										allWord.append(pyMap.get("all_py"));
										firstWord.append(pyMap.get("first_py"));
										flag = true;
										break;
									}
								}
								// 向后匹配一个汉字
								if (i + 2 <= length) {
									s = chinese.substring(i, i + 2);
									if (keyList != null && (keyList.contains(s))) {
										System.out.println("last 1 > " + py);
										HashMap<String, String> pyMap = convertInitialToUpperCase(py);
										allWord.append(pyMap.get("all_py"));
										firstWord.append(pyMap.get("first_py"));
										flag = true;
										break;
									}
								}

								// 向前匹配两个个汉字
								if ((i - 2 >= 0) && (i + 1 <= length)) {
									s = chinese.substring(i - 2, i + 1);
									if (keyList != null && (keyList.contains(s))) {
										System.out.println("before 2 < " + py);
										HashMap<String, String> pyMap = convertInitialToUpperCase(py);
										allWord.append(pyMap.get("all_py"));
										firstWord.append(pyMap.get("first_py"));
										flag = true;
										break;
									}
								}

								// 向前匹配一个汉字
								if ((i - 1 >= 0) && (i + 1 <= length)) {
									s = chinese.substring(i - 1, i + 1);
									if (keyList != null && (keyList.contains(s))) {
										System.out.println("before 1 < " + py);
										HashMap<String, String> pyMap = convertInitialToUpperCase(py);
										allWord.append(pyMap.get("all_py"));
										firstWord.append(pyMap.get("first_py"));
										flag = true;
										break;
									}
								}
								// 向前一个向后一个汉字
								if ((i - 1 >= 0) && (i + 2 <= length)) {
									s = chinese.substring(i - 1, i + 2);
									if (keyList != null && (keyList.contains(s))) {
										System.out.println("before last 1 <> " + py);
										HashMap<String, String> pyMap = convertInitialToUpperCase(py);
										allWord.append(pyMap.get("all_py"));
										firstWord.append(pyMap.get("first_py"));
										flag = true;
										break;
									}
								}
							}

							if (!flag) { // 都没有找到，取第一个
								String py = resultArray[0];
								HashMap<String, String> pyMap = convertInitialToUpperCase(py);
								allWord.append(pyMap.get("all_py"));
								firstWord.append(pyMap.get("first_py"));
							}
						}
					}

				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
					logger.error("汉字转拼音出现异常:" + e.getMessage());
				}
			} else {
				if (arrayContainsKey(arr[i])) {
					allWord.append(arr[i]);
					firstWord.append(arr[i]);
				}

			}
		}

		pinYinMap.put("firstWord", firstWord.toString());
		pinYinMap.put("allWord", allWord.toString());
		return pinYinMap;
	}

	/**
	 * 
	 * 方法描述:除去数组中重复的数据
	 * 
	 * @param a
	 * @return
	 */
	private static String[] duplicateRemoval(String[] a) {
		// array_unique
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < a.length; i++) {
			if (!list.contains(a[i])) {
				list.add(a[i]);
			}
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	/**
	 * 方法描述: 检测是否包含指定字符
	 * 
	 */
	private static boolean arrayContainsKey(char key) {
		for (char c : array) {
			if (key == c) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 方法描述:
	 */
	public static void main(String[] args) {
		System.out.println(converterToSpell("苹果<手机! 5S 32G)").toString());
	}

}