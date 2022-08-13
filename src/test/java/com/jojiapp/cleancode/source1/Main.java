package com.jojiapp.cleancode.source1;

import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

	private static final String WHITE_SPACE = " ";

	@Test
	@DisplayName("클린코드 1 ~ 3 자체 예제 리팩토링")
	void test() throws Exception{
		final BufferedReader bf = getBufferedReader();
		final int[] lineNumbers = getLineNumbers(bf);
		final int filenameLineCount = lineNumbers[0];
		final int extLineCount = lineNumbers[1];

		final MyFiles myFiles = MyFiles.builder()
				.filenameList(readLines(bf, filenameLineCount))
				.extList(readLines(bf, extLineCount))
				.build();
		System.out.println(myFiles);
	}

	private static BufferedReader getBufferedReader() {
		return new BufferedReader(new InputStreamReader(System.in));
	}

	private static int[] getLineNumbers(BufferedReader bf) throws IOException {
		return Arrays.stream(bf.readLine().split(WHITE_SPACE))
				.mapToInt(Integer::valueOf)
				.toArray();
	}

	private static List<String> readLines(BufferedReader bf, int lineNumber) {
		return IntStream.of(lineNumber)
				.mapToObj(__ -> readLine(bf))
				.toList();
	}

	private static String readLine(BufferedReader bf) {
		try {
			return bf.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
