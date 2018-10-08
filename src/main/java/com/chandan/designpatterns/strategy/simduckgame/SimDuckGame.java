package com.chandan.designpatterns.strategy.simduckgame;

/**
 * The Strategy Pattern defines a family of algorithms,
 * encapsulates each one, and makes them interchangeable.
 * Strategy lets the algorithm vary independently from
 * clients that use it..
 */
public class SimDuckGame {
   public static void main(String[] args) {
      Duck duck = new MallardDuck();
      duck.setFlyBehaviour(new FlyWithWings());
      duck.setQuackBehaviour(new Quack());
      duck.quack();
      duck.fly();

      // create wooden duck
      duck = new WoodenDuck();
      duck.setQuackBehaviour(new MuteQuack());
      duck.setFlyBehaviour(new FlyNoWay());
      duck.quack();
      duck.fly();

      // create a new model duck
      duck = new ModelDuck();
      duck.setQuackBehaviour(new Squeak());
      duck.setFlyBehaviour(new FlyNoWay());
      duck.quack();
      duck.fly();
      duck.setFlyBehaviour(new FlyWithRocket()); // model duck can change it's fly behaviour even at runtime
      duck.fly();

   }
}