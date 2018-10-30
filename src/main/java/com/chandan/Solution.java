package com.chandan;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chandan on 24/10/18.
 */
public class Solution {
   public static void main(String[] args) {
      String[] titles = getMovieTitle("spiderman");
      for (String title : titles) {
         System.out.println(title);
      }
   }

   static String[] getMovieTitle(String substr) {
      List<String> titles = new ArrayList<>();
      String url = "https://jsonmock.hackerrank.com/api/movies/search?Title=" + substr + "&page=2";
      try {
         URL requestUrl = new URL(url);
         URLConnection connection = requestUrl.openConnection();
         connection.setDoOutput(true);
         Scanner scanner = new Scanner(requestUrl.openStream());
         String response = scanner.useDelimiter("\\Z").next();
         if (response != null || response != "") {
            List<String> strings = parseTitles(response);
            titles.addAll(strings);
         }
         scanner.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

      Collections.sort(titles);

      String[] result = new String[titles.size()];

      return titles.toArray(result);
   }

   static List<String> parseTitles(String response) {
      List<String> result = new ArrayList<>();
      Pattern p = Pattern.compile("\"Title.*?\",");
      Matcher m = p.matcher(response);
      // if we find a match, get the group
      while (m.find()) {
         // we're only looking for one group, so get it
         String theGroup = m.group();
         theGroup = theGroup.replace("\"Title\":\"", "");
         theGroup = theGroup.replace("\",", "");
         // print the group out for verification
         result.add(theGroup);
      }

      return result;
   }
}