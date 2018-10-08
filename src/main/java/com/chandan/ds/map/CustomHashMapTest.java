package com.chandan.ds.map;

/**
 * Created by chandan on 5/10/18.
 */
public class CustomHashMapTest {
   public static void main(String[] args) {
      /*ICustomHashMap<Integer, Integer> hashMapCustom = new CustomHashMap<>();
      hashMapCustom.put(21, 12);
      hashMapCustom.put(25, 121);
      hashMapCustom.put(30, 151);
      hashMapCustom.put(33, 15);
      hashMapCustom.put(35, 89);
      System.out.println("value corresponding to key 21="
                         + hashMapCustom.get(21));
      System.out.println("value corresponding to key 51="
                         + hashMapCustom.get(51));

      System.out.print("Displaying : ");
      hashMapCustom.display();

      System.out.println("\n\nvalue corresponding to key 21 removed: "
                         + hashMapCustom.remove(21));
      System.out.println("value corresponding to key 51 removed: "
                         + hashMapCustom.remove(51));

      System.out.print("Displaying : ");
      hashMapCustom.display();*/

      ICustomHashMap<String, String> map = new CustomHashMap<>();
      map.put("name1", "Chandan");
      map.put("age", "21");
      map.put("dob1", "01/01/1990");
      map.put("gender1","male");
      map.put("city","Noida");
      map.display();
      System.out.println("Value of dob1 : "+map.get("dob1"));
      System.out.println("Removing city :"+map.remove("city"));
      System.out.println("Removing car :"+map.remove("car"));
      map.display();
   }
}