package com.chandan.cache;

public class LRUCahceTest {
   public static void main(String[] args) {
      ILRUCache<String,Car> cache = new LRUCache<>(3);
      cache.put("chandan",new Car("Chandan"));
      cache.put("aman",new Car("Aman"));
      cache.put("dinesh",new Car("Dinesh"));
      System.out.println(cache.get("chandan"));
      cache.put("ravi",new Car("Ravi"));
      System.out.println(cache.get("chandan"));
      System.out.println(cache.get("aman"));
   }
}
class Car{
   private String name;

   public Car(String name) {
      this.name = name;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (!(o instanceof Car)) {
         return false;
      }

      Car car = (Car) o;

      return name.equals(car.name);

   }

   @Override
   public int hashCode() {
      return name.hashCode();
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "Car{" +
             "name='" + name + '\'' +
             '}';
   }
}