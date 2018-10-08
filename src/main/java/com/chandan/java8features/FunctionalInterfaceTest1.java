package com.chandan.java8features;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInterfaceTest1 {
   public static void main(String[] args) {
      AdderImpl adderImpl = new AdderImpl();
      String r = adderImpl.add(a -> a + " from lambda");
   }
}

interface Adder {
   String add(Function<String, String> f);

   void add(Consumer<String> c);
}

class AdderImpl implements Adder {

   @Override
   public String add(Function<String, String> f) {
      return f.apply("Hello");
   }

   @Override
   public void add(Consumer<String> c) {

   }
}
