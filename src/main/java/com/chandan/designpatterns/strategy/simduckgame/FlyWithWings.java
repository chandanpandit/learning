package com.chandan.designpatterns.strategy.simduckgame;

/**
 * Created by chandan on 2/10/18.
 */
public class FlyWithWings implements FlyBehaviour {
   @Override
   public void fly() {
      System.out.println("Flying with wings!");
   }
}