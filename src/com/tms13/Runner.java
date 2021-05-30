package com.tms13;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    private static final String DATE_FORMAT = "dd-MM-yyyy";

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static void main(String[] args) {
        getWeekDayByDate();
        getNextTuesdayDate();
    }

    /**
     * Получить день недели по дате
     */
    private static void getWeekDayByDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;
        DayOfWeek day;

        System.out.print("Enter date (" + DATE_FORMAT + ") to console: ");
        String line = scanner.nextLine();
             try {
                  date = LocalDate.parse(line, formatter);
              } catch (Exception e) {
                  System.err.println("Invalid date value:: " + line);
              }
        scanner.close();

        if (date != null) {
            day = date.getDayOfWeek();
        } else throw new NullPointerException("there is no date value");

        System.out.println(date.format(formatter) + " is " + day.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    }

    /**
     * Дата следующего вторника
     */
    private static void getNextTuesdayDate() {
        System.out.println("Next Tuesday date = " + LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).format(formatter));
    }

}