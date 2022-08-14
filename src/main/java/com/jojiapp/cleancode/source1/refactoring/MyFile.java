package com.jojiapp.cleancode.source1.refactoring;

import lombok.*;

import java.util.*;

public class MyFile implements Comparable<MyFile> {
	private static final String DOT = "\\.";
	private final String name;
	private final String ext;
	private final Boolean isContainExt;

	@Builder
	private MyFile(final String filename, final List<String> extList) {
		this.name = getName(filename);
		this.ext = getExt(filename);
		this.isContainExt = extList.contains(this.ext);
	}

	private static String getName(final String filename) {
		return split(filename)[0];
	}

	private static String getExt(final String filename) {
		return split(filename)[1];
	}

	private static String[] split(final String filename) {
		return filename.split(DOT);
	}

	@Override
	public int compareTo(final MyFile myFile) {
		if (!this.name.equals(myFile.name))
			return this.name.compareTo(myFile.name);
		if (!this.isContainExt.equals(myFile.isContainExt)) {
			return -this.isContainExt.compareTo(myFile.isContainExt);
		}
		return this.ext.compareTo(myFile.ext);
	}

	@Override
	public String toString() {
		return "%s.%s".formatted(this.name, this.ext);
	}

}
