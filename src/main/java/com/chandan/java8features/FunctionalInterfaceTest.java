package com.chandan.java8features;


import java.util.function.Function;

public class FunctionalInterfaceTest {
   public static void main(String[] args) {
      UseFoo useFoo = new UseFoo();
      Function<String, String> function = a -> "Hello " + a;
      String s = useFoo.add("Chandan", a -> "Hello " + a);
      System.out.println(s);

      s = useFoo.doSomething("Pandit", a -> "Hello " + a);
      Foo foo = string -> "Hello " + string;
      s = useFoo.doSomething("Pandit", foo);
      System.out.println(s);
   }
}

@FunctionalInterface
interface Foo {
   String method(String string);
}

class UseFoo {
   String add(String s, Function<String, String> fn) {
      return fn.apply(s);
   }

   String doSomething(String s, Foo foo) {
      return foo.method(s);
   }
}