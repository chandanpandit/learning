package com.chandan.java8features;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeApis {
   public static void main(String[] args) {
      String sDate1 = "2018-10-23";
      try {
         Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
         System.out.println(checkIfInGracePeriod(date1));
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }

   static private boolean checkIfInGracePeriod(Date expiryDate) {
      final LocalDate expiryDateLocal =  expiryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      final LocalDate today = LocalDate.now();
      int DURATION = 7;
      final LocalDate graceExpiryDate = expiryDateLocal.plusDays(DURATION); // add 7 days to expiry

      if(expiryDateLocal.isBefore(today) && graceExpiryDate.isAfter(today)){ // expired but is in grace period
         return true;
      }else
         return !graceExpiryDate.isBefore(today);
   }
}