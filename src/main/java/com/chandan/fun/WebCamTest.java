package com.chandan.fun;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class WebCamTest {
   public static void main(String[] args) {
      for (int i = 0; i < 10; i++) {
         test(i);
      }
   }

   static void test(int i) {
      Webcam webcam = Webcam.getDefault();
      webcam.open();
      try {
         ImageIO.write(webcam.getImage(), "PNG", new File("chandan"+i+".png"));
      }catch (IOException e){
         System.out.println("Failed to capture image");
      }
   }
}