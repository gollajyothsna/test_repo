
package com.zensar.assignment;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
/*
 *1. Find out the day exactly after 15 days from today’s date.
 * 2. Find out how much time is required from now for 12 PM.
 *3. Find out how many days are required to reach 29-Feb from today’s date.
 *4. Print the current time in different time zones.
 * 5. Print the current date with different locales.
 * 6. Print the current date with different date formats like dd/mm/yyyy, mm/dd/yyyy hh:mm:ss etc
 * 7. Find out how many Sundays the current year has.
 * 8. Find out the months in the given year having 5 Sundays.
*/

public class DateApiTest {
	public static void dateafter() {
// 1
		LocalDate presentDate = LocalDate.now();
		System.out.println("presentDate :" + presentDate);
		LocalDate after15Days = LocalDate.now().plusDays(15);
		System.out.println("after15Days :" + after15Days);
	}

	public static void timerequired() {
// 2
		LocalTime localTime = LocalTime.of(12, 0);
		LocalTime localTime2 = LocalTime.now();
		Duration duration = Duration.between(localTime, localTime2);
		System.out.println("Time duration for 12 pm : " + duration);
	}

	public static void daysrequired() {
// 3
		long noOfDaysDifference = LocalDate.now().until(LocalDate.of(2024, 2, 29), ChronoUnit.DAYS);
		System.out.println("Total No. of Days from today : " + noOfDaysDifference);
	}

	public static void currentTimeInDiffZones() {
// 4
		ZoneId zoneId = ZoneId.of("Australia/Melbourne");
		LocalTime localTime = LocalTime.now(zoneId);
		System.out.println("Australia time: " + localTime);
		ZoneId zoneId1 = ZoneId.of("Europe/Guernsey");
		LocalTime localTime1 = LocalTime.now(zoneId1);
		System.out.println("Europe time: " + localTime1);
		ZoneId zoneId2 = ZoneId.of("Mexico/BajaNorte");
		LocalTime localTime2 = LocalTime.now(zoneId2);
		System.out.println("Mexico time: " + localTime2);
		ZoneId zoneId3 = ZoneId.of("US/Central");
		LocalTime localTime3 = LocalTime.now(zoneId3);
		System.out.println("US time: " + localTime3);
	}

	public static void currentdateInDifflocals() {
// 5
		DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
		LocalDate date3 = LocalDate.of(2014, 3, 18);
		String formattedDate_2 = date3.format(italianFormatter); // 18. marzo2014
		System.out.println(formattedDate_2);
		DateTimeFormatter frenchFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.FRENCH);
		LocalDate date5 = LocalDate.of(2014, 3, 18);
		String formattedDate_3 = date5.format(frenchFormatter); // 18. mars 2014
		System.out.println(formattedDate_3);
		DateTimeFormatter CANADAFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.CANADA);
		LocalDate date6 = LocalDate.now();
		String formattedDate_4 = date6.format(CANADAFormatter);
		System.out.println(formattedDate_4);
		DateTimeFormatter JAPANESEFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.JAPAN);
		LocalDate date7 = LocalDate.now();
		String formattedDate_5 = date7.format(JAPANESEFormatter);
		System.out.println(formattedDate_5);
		DateTimeFormatter GERMANFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.GERMAN);
		LocalDate date8 = LocalDate.now();
		String formattedDate_6 = date8.format(GERMANFormatter);
		System.out.println(formattedDate_6);
	}

	public static void dateFormatter() {
// 6
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.of(2022, 3, 24);
		String formattedDate = date1.format(formatter);
		System.out.println(formattedDate);
		LocalDate date2 = LocalDate.parse("20220324", DateTimeFormatter.BASIC_ISO_DATE); // 2014-03-18
		System.out.println(date2);
// LocalDate date3 = LocalDate.parse("2014318", DateTimeFormatter.ISO_LOCAL_TIME);
// System.out.println(date3);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date3 = LocalDate.of(2022, 03, 27);
		String formattedDate1 = date3.format(formatter1);
		System.out.println(formattedDate1);
// LocalDate date5 = LocalDate.parse("20220324", DateTimeFormatter.ISO_DATE); //2014-03-18
// System.out.println(date5);
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime myDate = LocalDateTime.now();
		String formattedDate2 = myDate.format(myFormat);
		System.out.println("dd-MM-yyyy HH:mm:ss format: " + formattedDate2);
	}

	public static void sundaysCount() {
//7
		int year = LocalDate.now().getYear();
		LocalDate now = LocalDate.of(year, Month.JANUARY, 1);
		LocalDate sunday = now.with((DayOfWeek.SUNDAY));
		do {
			System.out.println(sunday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
			sunday = sunday.plus(Period.ofDays(7));
		} while (sunday.getYear() == year);
	}

	public static void FivesundaysCount() {
		int year = LocalDate.now().getYear();
		LocalDate now = LocalDate.of(year, Month.JANUARY, 1);
		LocalDate sunday = now.with((DayOfWeek.SUNDAY));
		long count = 0;
		do {
		System.out.println(sunday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		sunday = sunday.plus(Period.ofDays(7));
		count++;
		} while (sunday.getYear() == year);
		System.out.println("total sundays = " + count);
		}

	public static void main(String[] args) {
		dateafter();
		timerequired();
		daysrequired();
		currentTimeInDiffZones();
		currentdateInDifflocals();
		dateFormatter();
// sundaysCount();
		FivesundaysCount();
	}
}
