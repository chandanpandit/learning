package com.chandan.designpatterns.strategy.simduckgame;

/**
 * Created by chandan on 2/10/18.
 */
public abstract class Duck {
   private FlyBehaviour flyBehaviour;
   private QuackBehaviour quackBehaviour;

   public abstract void display();

   public void fly() {
      flyBehaviour.fly();
   }

   public void quack() {
      quackBehaviour.quack();
   }

   public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
      this.flyBehaviour = flyBehaviour;
   }

   public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
      this.quackBehaviour = quackBehaviour;
   }

}