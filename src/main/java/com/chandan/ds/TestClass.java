package com.chandan.ds;

import java.util.Scanner;

/**
 * Created by chandan on 8/8/18.
 */
public class TestClass {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      for (int i = 0; i < t; i++) {
         int n = s.nextInt();
         s.nextLine();
         String str = s.nextLine();
         Point p = getLocation(str);
         System.out.println(getSolution(p));
      }
   }

   static class Point {
      int x, y;

      public Point(int x, int y) {
         this.x = x;
         this.y = y;
      }

      int getQuad() {
         if (x >= 0 && y >= 0) {
            return 1;
         } else if (x <= 0 && y >= 0) {
            return 2;
         } else if (x <= 0 && y <= 0) {
            return 3;
         } else{
            return 4;
         }
      }

      @Override
      public String toString() {
         return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
      }
   }

   static Point getLocation(String path){
      int x = 0,y =0;
      int dir = 0;
      /*
      * 0 -> N, 1 -> E ,2 -> S, 3-> W
      * R -> -1, L -> +1
      */
      for (int i = 0; i < path.length(); i++) {
         switch (path.charAt(i)){
            case 'L':
               dir = (4 + dir-1) % 4;
               break;
            case 'R':
               dir = (4 + dir+1) % 4;
               break;
            case 'M':
                  if(dir == 0){
                     y++;
                  }else if(dir == 1){
                     x++;
                  }else if (dir == 2){
                     y--;
                  }else if (dir == 3){
                     x--;
                  }

               break;
         }
      }
      return new Point(x,y);
   }

   static String getSolution(Point p) {
      int x = Math.abs(p.x);
      int y = Math.abs(p.y);
      int smaller = Math.abs(p.x) < Math.abs(p.y) ?  Math.abs(p.x) : Math.abs(p.y);
      int diff = Math.abs(Math.abs(p.x) - Math.abs(p.y));
      String solution = "";
      for (int i = 0; i < smaller; i++) {
         if(p.getQuad() == 1) {
            solution += "1";
         }else if(p.getQuad() == 2) {
            solution += "4";
         }else if(p.getQuad() == 3) {
            solution += "3";
         }else if(p.getQuad() == 4) {
            solution += "2";
         }
      }

      for (int i = 0; i < diff; i++) {
         if(p.getQuad() == 1) {
            if(x > y)
               solution += "6";
            else
               solution += "5";
         }else if(p.getQuad() == 2) {
            if(x > y)
               solution += "8";
            else
               solution += "5";
         }else if(p.getQuad() == 3) {
            if(x > y)
               solution += "8";
            else
               solution += "7";
         }else if(p.getQuad() == 4) {
            if(x > y)
               solution += "6";
            else
               solution += "7";
         }
      }

      return solution+"0";

   }

}