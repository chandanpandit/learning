package com.chandan.cache;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

/**
 * Created by chandan on 19/4/18.
 */
public class JCSCacheTest {
   public static void main(String[] args) {
      JCS cache = EmployeeCache.getCache();
      Employee emp1 = new Employee("Joel", "Chinna", "E341267");
      Employee emp2 = new Employee("Hari", "Krishna", "E529532");
      Employee emp3 = new Employee("Rithwik", "Bhushan", "E123445");

      try {
         cache.put(emp1.getId(), emp1);
         cache.put(emp2.getId(), emp2);
         cache.put(emp3.getId(), emp3);
      } catch (CacheException e) {
         e.printStackTrace();
      }

      Employee cachedEmp = EmployeeCache.getEmployeeByID("E341267");
      System.out.println(cachedEmp.getId() + " " +cachedEmp.getFirstName() +" " + cachedEmp.getLastName());

      cachedEmp = EmployeeCache.getEmployeeByID("E529532");
      System.out.println(cachedEmp.getId() + " " +cachedEmp.getFirstName() +" " + cachedEmp.getLastName());

      cachedEmp = EmployeeCache.getEmployeeByID("E123445");
      System.out.println(cachedEmp.getId() + " " +cachedEmp.getFirstName() +" " + cachedEmp.getLastName());
   }
}