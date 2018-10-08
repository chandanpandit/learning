package com.chandan.java8features;

public class FunctionalInterfaceTest2 {
   private String value = "Enclosing class Value";

   public String scopeExperiment() {
      Foo foo = new Foo() {
         String value = "Inner class value";

         @Override
         public String method(String string) {
            return this.value;
         }
      };
      String resultIC = foo.method("");

      Foo fooLambda = param -> {
         String value = "Lambda value";
         return this.value;
      };
      String resultLambda = fooLambda.method("");

      return "Results: resultIC = " + resultIC +
             ", resultLambda = " + resultLambda;
   }

   public static void main(String[] args) {
      FunctionalInterfaceTest2 test2 = new FunctionalInterfaceTest2();
      System.out.println(test2.scopeExperiment());
   }

}