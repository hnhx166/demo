package com.chnghx.web.wechat.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


import net.sf.json.JSONObject;

public class ReadFile {
	public static final String WECHAT_MENU="wechatMenu.txt";
	public static final String WECHAT_BUSINESS="wechatBusiness.txt";
	public static final String WECHAT_MATERIAL="\\js\\h5\\";
	/**
	 * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
	 * 
	 * @param fileName
	 *            文件的名
	 */
	public static String readFileByBytes(String fileName) {
		StringBuffer stringBuffer=new StringBuffer();
		try {
			String encoding = "UTF-8";
			File file = new File(fileName);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					stringBuffer.append(lineTxt);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
				return null;
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return String.valueOf(stringBuffer);
	}

	public static void main(String[] args) {
		ReadFile file = new ReadFile();
		String fileStr=file.readFileByBytes("D:/wechatMenu.txt");
		JSONObject json=JSONObject.fromObject(fileStr);
		System.out.println(json.toString());
	}
}