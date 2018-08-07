package com.healthec.generic.utils;

import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

    public static String throwDateAndTime ()  {

        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String formatDateTime = datetime.format(format);
        System.out.println(formatDateTime);
        return formatDateTime;
    }

    public static void main(String[] args) {

       String dt=  throwDateAndTime();
    }
}
