package com.jdc_assigments;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Scanner;
import java.time.DayOfWeek;

public class CalenderApp {

	public static void main(String[] args) {

		// initialization of  year, month, and day
		int year = 1;
		int month = 1;
		int day = 1;
		String[] months = { "", "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE",
				"JULY", "AUGUST", "SEPTEMBER","OCTOBER", "NOVEMBER", "DECEMBER" };
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter Year and Month : ");
			year = sc.nextInt();
			String monthInput = sc.next().toUpperCase();
			
			month = Arrays.asList(months).indexOf(monthInput);
		}catch(Exception e) {
			 year = LocalDate.now().getYear();
			 month = LocalDate.now().getMonthValue();
			 day = LocalDate.now().getDayOfMonth();
			 System.err.println("\nYou Type MISSED!");
			 System.out.println("Current Month Calendar is ...");
		}
		LocalDate specificDate = LocalDate.of(year, month, day);
		LocalDate firstDayOfMonth = specificDate.with(TemporalAdjusters.firstDayOfMonth());
		DayOfWeek dayOfWeek = firstDayOfMonth.getDayOfWeek();

		// Get the day of the week as an integer (1 = Monday, 7 = Sunday)
		int dayOfWeekInt = dayOfWeek.getValue() + 1; // +1 To change Sunday to first day of week
		
		// get the max days of the month
		int daysInMonth = specificDate.lengthOfMonth();
		
		// month format header
		DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MMMM yyyy");
		
		// month header
		System.out.println("\n    " + specificDate.format(monthFormat));

		// Print out day names header
		System.out.println("Su Mo Tu We Th Fr Sa");
		
		// optimize printing initial spaces
		if (dayOfWeekInt >= 8)
			dayOfWeekInt = 1;
		
		// Printing initial spaces
		for (int i = 1; i < dayOfWeekInt; i++) {
			System.out.print("   ");
		}

		// Printing days of the month
		for (int i = 1; i <= daysInMonth; i++) {
			System.out.printf("%2d ", i);
			if (((i + dayOfWeekInt - 1) % 7 == 0) || (i == daysInMonth)) {
				System.out.println();
			}
		}
	}
}
