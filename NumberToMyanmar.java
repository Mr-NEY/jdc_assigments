package com.jdc_assigments;

import java.util.Scanner;

public class NumberToMyanmar {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter ‌amount = ");
			int num = sc.nextInt();
			int num1 = num;

			String[] prefixs = { "", "တစ်", "နှစ်", "သုံး", "လေး", "ငါး", "‌ခြောက်", "ခုနစ်", "ရှစ်", "ကိုး" };
			String[] suffixs = { "", "ဆယ်", "ရာ", "ထောင်", "သောင်း", "သိန်း", "သန်း" };

			int than = 0, thein = 0, thaung = 0, htaung = 0, yar = 0, sal = 0, khu = 0;
			int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;

			if (num > 9999999) {
				System.out.println("Sorry! Enter amount below 10000000.");
			} else if (num == 0) {
				System.out.println("0 = သုညကျပ်");
			} else {

				if (num > 999999)
					f = 6;
				while (num > 999999) {
					num -= 1000000;
					than++;
				}

				if (num > 99999)
					e = 5;
				while (num > 99999) {
					num -= 100000;
					thein++;
				}

				if (num > 9999)
					d = 4;
				while (num > 9999) {
					num -= 10000;
					thaung++;
				}

				if (num > 999)
					c = 3;
				while (num > 999) {
					num -= 1000;
					htaung++;
				}

				if (num > 99)
					b = 2;
				while (num > 99) {
					num -= 100;
					yar++;
				}

				if (num > 9)
					a = 1;
				while (num > 9) {
					num -= 10;
					sal++;
				}

				khu = num;

				System.out.println(num1 + " = " + prefixs[than] + suffixs[f] + prefixs[thein] + suffixs[e] + prefixs[thaung]
						+ suffixs[d] + prefixs[htaung] + suffixs[c] + prefixs[yar] + suffixs[b] + prefixs[sal] + suffixs[a]
						+ prefixs[khu] + "ကျပ်");
			}
		}
	}

}
