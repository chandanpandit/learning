package com.chandan.assignments.cache;

public class TestKVStore {
   public static void main(String[] args) throws InterruptedException {

      final KVStore<String, String> kvStore = new KVStoreImpl<>();
      System.out.println("Putting data in kVstore...");
      kvStore.put("name", "Chandan");
      kvStore.put("gender", "Male");
      kvStore.put("city", "Faridabad");
      System.out.println("Size of map =" + kvStore.size());
      System.out.println("Deleting city from kVstore...");
      kvStore.delete("city");
      System.out.println("Size of map =" + kvStore.size());
      System.out.println(("Name="+kvStore.get("name")));
      kvStore.clear();
      System.out.println(("Name after clearing="+kvStore.get("name")));
   }
}
