package com.ts.game.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class StringUtils {
	public static String BufferedReaderToString(BufferedReader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}

		return sb.toString();
	}
}
