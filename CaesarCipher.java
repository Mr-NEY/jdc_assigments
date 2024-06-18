package com.jdc_assigments;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CaesarCipher {

	static int algo;
	static int select;

	static String encrypt(String input) {

		StringBuilder eWords = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isLetter(ch)) {
				int change = Character.isUpperCase(ch) ? 'A' : 'a';
				ch = (char) (((ch - change + algo) % 26) + change);
			}
			eWords.append(ch);
		}
		return eWords.toString();
	}

	static String decrypt(String input) {

		StringBuilder dWords = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isLetter(ch)) {
				int change = Character.isUpperCase(ch) ? 'Z' : 'z';
				ch = (char) (((ch - change - algo) % 26) + change);
			}
			dWords.append(ch);
		}
		return dWords.toString();
	}

	static void showMessage(String message) {
		String equal = "";
		for (int i = 0; i < message.length(); i++) {
			equal += "=";
		}
		System.out.println("==".concat(equal).concat("=="));
		System.out.println("= ".concat(message).concat(" ="));
		System.out.println("==".concat(equal).concat("=="));
	}

	public static void main(String[] args) {
		showMessage("Welcome Caesar Cipher");

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("\n1. Encrypt\n2. Decrypt");
			System.out.print("Select '1' or '2': ");
			select = sc.nextInt();
			

			while (select != 1 && select != 2) {
				System.err.print("\n#Invalid selection. Please enter 1 or 2.#\n");
				System.out.println("\n1. Encrypt\n2. Decrypt");
				System.out.print("Select '1' or '2': ");
				select = sc.nextInt();
				
			}

			System.out.print("\nEnter Algo Number(1 to 20): ");
			algo = sc.nextInt();
			sc.nextLine();
			

			while (algo < 0 || algo > 20) {
				System.err.print("\nPlease enter correct Algo number.\n");
				System.out.print("Enter Algo Number(1 to 20): ");				
				algo = sc.nextInt();
				sc.nextLine();
			}

			System.out.print("\nEnter input Text: ");
			String input = sc.nextLine();

			if (select == 1) {
				System.out.println("\nEncrypted Words");
				showMessage(encrypt(input));
			} else {
				System.out.println("\nDecrypted Words");
				showMessage(decrypt(input));
			}

		}catch(InputMismatchException e) {
			System.out.println("Oops!!! You typed wrong Command. Please START Again");
		}
	}

}
