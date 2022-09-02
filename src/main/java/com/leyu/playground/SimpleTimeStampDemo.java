package com.leyu.playground;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class SimpleTimeStampDemo {


  public static void convertStringToTimestamp() {
    String in = "Wed, 20 Jul 2022 23:57:16 GMT";
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
      Date parsedDate = dateFormat.parse(in);
      long timeStampIn = parsedDate.getTime();
      System.out.println("timeStampIn: " + timeStampIn);

      final Date currentTime = new Date();
      System.out.println("timeStampNow: " + currentTime.getTime());

    } catch(Exception e) { //this generic but you can control another types of exception
      System.out.println(e);
    }

  }
}