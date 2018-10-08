package com.chandan.test;

import java.util.*;
import java.util.stream.Collectors;

class MyTest{
   public static void main(String[] args) {
      Item one = new Item("1","1");
      Item two = new Item("2","2");
      Item three = new Item("1","3");
      Item four = new Item("3","4");
      Item five = new Item("2","5");
      Item six = new Item("1","5");
      List<Item> items = new ArrayList<Item>();
      items.add(one);
      items.add(two);
      items.add(three);
      items.add(four);
      items.add(five);
      items.add(six);
      Map<String,Set<String>> result = items.stream().collect(Collectors.groupingBy(Item::getListingId,Collectors.mapping(Item::getFloorPlanId,Collectors.toSet())));
      System.out.println(result);
   }
}

class Item {
   String listingId;
   String floorPlanId;

   public Item(String listingId, String floorPlanId) {
      this.listingId = listingId;
      this.floorPlanId = floorPlanId;
   }

   public String getListingId() {
      return listingId;
   }

   public void setListingId(String listingId) {
      this.listingId = listingId;
   }

   public String getFloorPlanId() {
      return floorPlanId;
   }

   public void setFloorPlanId(String floorPlanId) {
      this.floorPlanId = floorPlanId;
   }
}



