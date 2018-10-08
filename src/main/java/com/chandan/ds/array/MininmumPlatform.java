package com.chandan.ds.array;

import java.util.Arrays;

/**
 * Created by chandan on 23/3/18.
 */
public class MininmumPlatform {
   static class Event{
      int time;
      int type; // 1-> arrival -1-> dep

      public Event(int time, int type) {
         this.time = time;
         this.type = type;
      }

      @Override
      public String toString() {
         return "Event{" +
                "time=" + time +
                ", type=" + type +
                '}';
      }
   }
   static int findPlatform(int[] arr,int[] dep){
      int n = arr.length;
      Event[] events = new Event[2*n];
      System.out.println(events.length);
      int k = 0;
      for (int i = 0; i < n; i++) {
         events[k++] = new Event(arr[i],1);
         events[k++] = new Event(dep[i],-1);
      }
      Arrays.sort(events,(a,b)->a.time-b.time);
      for (Event e : events){
         System.out.print(e+ " ");
      }
      int maxPlatform = 0;
      int curr = 0;
      for (int i = 0; i < 2 * n; i++) {
         if(events[i].type == 1){
            curr++;
            if(curr > maxPlatform){
               maxPlatform = curr;
            }
         }else{
            curr--;
         }
      }

      return maxPlatform;
   }
   public static void main(String[] args) {
      int arr[] = {900, 940, 950, 1100, 1500, 1800};
      int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
      int n = arr.length;
      System.out.println("Minimum Number of Platforms Required = "
                         + findPlatform(arr, dep));
   }

}