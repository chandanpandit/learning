package com.chandan.test;

import java.util.Calendar;

/**
 * Created by chandan on 24/4/18.
 */
public class Test {
   private Calendar calendar;

   public Test() {
      this.calendar = Calendar.getInstance();
   }

   public static void main(String[] args) {
      Test t = new Test();
      System.out.println(t.getMilliSecondsToEOD());
      System.out.println(t.getMilliSecondsToEOD());
      System.out.println(t.getMilliSecondsToEOD());
      System.out.println(t.getMilliSecondsToEOD());
      System.out.println(t.getMilliSecondsToEOD());
      System.out.println(t.getMilliSecondsToEOD());
      System.out.println(t.getMilliSecondsToEOD());
      System.out.println(Integer.MAX_VALUE);
   }
   private long getMilliSecondsToEOD() {
      Calendar calendar =  Calendar.getInstance();
      calendar.add(Calendar.DAY_OF_MONTH, 1);
      calendar.set(Calendar.HOUR_OF_DAY, 0);
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.SECOND, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      return (calendar.getTimeInMillis() - System.currentTimeMillis());
   }
}