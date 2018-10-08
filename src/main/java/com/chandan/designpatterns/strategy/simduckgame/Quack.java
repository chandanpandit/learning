package com.chandan.designpatterns.strategy.simduckgame;

/**
 * Created by chandan on 2/10/18.
 */
public class Quack implements QuackBehaviour {
   @Override
   public void quack() {
      System.out.println("Quack quack...");
   }
}