package com.boeing.demo.customreport.lib;

/**
 * @author manhnt
 */
public class StringUtil {

	public static String concat(String separator, String... str) {

		StringBuilder output = new StringBuilder();

		for (String s : str) {
			if (s == null || s.trim().length() == 0) continue;
			output.append(s.trim()).append(separator);
		}
		if (output.length() == 0) return "";
		else return output.substring(0, output.length() - separator.length());
	}
}
