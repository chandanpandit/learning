package com.chandan.ds.mixed;

import java.util.Date;

public class ImmutableClass {
   public static void main(String[] args) {
      Car car = new Car(100,"Honda",new Date());
      System.out.println(car.getName()+"|"+car.getWeight()+"|"+car.getDate());
      car.getDate().setTime(1544572800);
      System.out.println(car.getName()+"|"+car.getWeight()+"|"+car.getDate());
   }
}

final class Car {
   private final int weight;
   private final String name;
   private final Date date;

   public Car(int weight, String name, Date date) {
      this.weight = weight;
      this.name = name;
      this.date = new Date(date.getTime());
   }

   public int getWeight() {
      return weight;
   }

   public String getName() {
      return name;
   }

   public Date getDate() {
      return new Date(date.getTime());
   }
}