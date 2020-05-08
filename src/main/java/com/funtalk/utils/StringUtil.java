package com.funtalk.utils;

import java.io.*;
import java.security.MessageDigest;

public class StringUtil {

	public static String str;
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	public static boolean isEmpty(String s) {
		return s == null || "".equals(s); // s == null | s.equals("");
											// //位与,逻辑与区别,非空字符串放置在前面,避免空指针
	}

	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}


	public static void saveFile(InputStream is, String fileName) throws IOException {
		BufferedInputStream in=null;
		BufferedOutputStream out=null;
		in=new BufferedInputStream(is);
		out=new BufferedOutputStream(new FileOutputStream(fileName));
		int len=-1;
		byte[] b=new byte[1024];
		while((len=in.read(b))!=-1){
			out.write(b,0,len);
		}
		in.close();
		out.close();
	}


	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 转换字节数组为16进制字串
	 * @param b 字节数组
	 * @return 16进制字串
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}


	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes()));
		} catch (Exception ex) {
		}
		return resultString;
	}




}
