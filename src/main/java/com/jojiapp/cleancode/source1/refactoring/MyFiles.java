package com.jojiapp.cleancode.source1.refactoring;

import lombok.*;

import java.util.*;

import static java.util.stream.Collectors.*;

public class MyFiles {

	private static final String NEXT_LINE = "\n";
	private final List<MyFile> myFileList;

	@Builder
	private MyFiles(final List<String> filenameList, final List<String> extList) {
		this.myFileList = filenameList.stream()
				.map(filename -> MyFile.builder()
						.filename(filename)
						.extList(extList)
						.build()
				)
				.toList();
	}

	@Override
	public String toString() {
		return this.myFileList.stream()
				.sorted()
				.map(MyFile::toString)
				.collect(joining(NEXT_LINE));
	}
}
