package com.chandan.cache;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

public class EmployeeCache {
   static JCS empCache;

   static {
      try {
         empCache = JCS.getInstance("empCache");
      } catch (CacheException e) {
         System.out.println("Failed to get Cache Instance");
         e.printStackTrace();
      }
   }

   static JCS getCache() {
      return empCache;
   }

   static void putCache(Employee emp) {
      String id = emp.getId();
      if (empCache.get(id) == null) {
         try {
            empCache.put(id, emp);
         } catch (CacheException ex) {

         }
      }
   }

   static Employee getEmployeeByID(String id) {
      return (Employee) empCache.get(id);
   }

   static void shutDownCache(){
   }

}