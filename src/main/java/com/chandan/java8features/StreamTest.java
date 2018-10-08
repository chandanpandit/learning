package com.chandan.java8features;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
   public static void main(String[] args) {
      // intermediate & terminal operations
      ArrayList<Home> list = new ArrayList<>();
      list.add(new Home());
      list.add(new Home());
      List<String> names = list.stream().flatMap(home -> home.getPersons().stream()).collect(Collectors.toList());
   }
}
class Home{
   private List<String> persons;

   public Home() {
      persons = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
         persons.add("Person : "+i);
      }
   }

   public List<String> getPersons() {
      return persons;
   }

   public void setPersons(List<String> persons) {
      this.persons = persons;
   }
}

class MyCollector{

}