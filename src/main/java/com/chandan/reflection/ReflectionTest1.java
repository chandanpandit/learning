package com.chandan.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by chandan on 18/4/18.
 */
// getClass returns actual fully qualified class name for a given class
public class ReflectionTest1 {
   public static void main(String[] args) throws NoSuchMethodException {
      Car car = new Car();
      Class c = car.getClass();
      Method myMethod = null;
      for (Method m : c.getMethods()){
         if(m.getParameterCount() == 2){
            myMethod = m;
         }
      }
      if(myMethod != null){
         try {
            myMethod.invoke(1,2);
         } catch (IllegalAccessException e) {
            e.printStackTrace();
         } catch (InvocationTargetException e) {
            e.printStackTrace();
         }
      }
   }
}

class Car extends Vehicle implements ICar{
   enum Make {TATA, BMW, HONDA}

   private int id;
   private String name;
   private float capacity;
   private Make make;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public float getCapacity() {
      return capacity;
   }

   public void setCapacity(float capacity) {
      this.capacity = capacity;
   }

   public Make getMake() {
      return make;
   }

   public void setMake(Make make) {
      this.make = make;
   }

   @MyTestAnnotation
   public int myTestMethod(int x,int y){
      return 5;
   }
}
interface ICar{

}
class Vehicle{

}

@Target({ ElementType.METHOD })
@interface MyTestAnnotation{

}
