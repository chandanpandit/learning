package com.chandan.cache;

import java.io.Serializable;

/**
 * Created by chandan on 19/4/18.
 */
public class Employee implements Serializable{
   private String firstName;
   private String lastName;
   private String id;

   Employee(String firstName, String lastName, String id) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getId() {
      return id;
   }

   public String getLastName() {
      return lastName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setId(String id) {
      this.id = id;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
}