package com.cg.hms.presentation;

import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) {

		String name = "Pav";

		System.out.println(Pattern.matches("[A-Z]{1}[A-Za-z\\s]{4,19}$", name));

	}

}
