package com.jojiapp.cleancode;

import org.springframework.boot.autoconfigure.*;

import java.util.*;

@SpringBootApplication
public class CleanCodeApplication {

	public static void main(String[] args) {
		ArrayList<Integer> integers = new ArrayList<>();
		int a = 5;
		integers.add(5);
		integers.add(4);
		integers.add(3);
		integers.add(2);
		integers.add(1);
		integers.remove(a);
		System.out.println(integers);
//        SpringApplication.run(CleanCodeApplication.class, args);
	}

}
