package com.chandan.java8features;


import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceTest {
   public static void main(String[] args) {
      List<String> stringList = Arrays.asList("a","","c","d","","e");
      MyStringUtils stringUtils = new MyStringUtils();
      //List<String> spaces = stringList.stream().filter(MyStringUtils::getPropId).collect(Collectors.toList());
      List<User> users = new ArrayList<>();
      stringList.stream().forEach(name -> users.add(new User(name)));
      boolean result = users.stream().anyMatch(u -> User.isRealUser(u));
      System.out.println(result);
   }
}


class MyStringUtils{
   public static boolean isEmpty(String s){
      return StringUtils.isEmpty(s);
   }

   public boolean isBlank(String s){
      return StringUtils.isEmpty(s);
   }

   public String getPropId() {
      return "Chandan";
   }
}

class User{
   private String name;

   public User(String name) {
      this.name = name;
   }

   public static boolean isRealUser(User u){
      return StringUtils.isEmpty(u.name);
   }
}