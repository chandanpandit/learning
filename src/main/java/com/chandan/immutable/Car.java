package com.chandan.immutable;

public class Car {
   private Tyre tyre;

   public Tyre getTyre() {
      return tyre;
   }

   public Car(Tyre tyre) {
      this.tyre = tyre;
   }
}