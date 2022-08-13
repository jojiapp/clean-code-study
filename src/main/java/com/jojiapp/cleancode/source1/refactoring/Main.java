package com.jojiapp.cleancode.source1.refactoring;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

	private static final String WHITE_SPACE = " ";

	public static void main(String[] args) throws IOException {
		final BufferedReader bf = getBufferedReader();
		final int[] lineNumbers = getLineNumbers(bf);

		final MyFiles myFiles = MyFiles.builder()
				.filenameList(readLines(bf, getFilenameLineCount(lineNumbers)))
				.extList(readLines(bf, getExtLineCount(lineNumbers)))
				.build();
		System.out.println(myFiles);
	}

	private static int getExtLineCount(int[] lineNumbers) {
		return lineNumbers[1];
	}

	private static int getFilenameLineCount(int[] lineNumbers) {
		return lineNumbers[0];
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
