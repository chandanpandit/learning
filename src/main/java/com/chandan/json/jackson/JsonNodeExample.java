package com.chandan.json.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Jackson has a built-in tree model which can be used to represent a JSON object. Jackson's tree model is useful if
 * you don't know how the JSON you will receive looks, or if you for some reason cannot (or just don't want to)
 * create a class to represent it.
 */
public class JsonNodeExample {
   public static void main(String[] args) {
      String jsonString = "{\"Kitchen\":{\"1\":{\"imgs\":[74474564]}},\"Hall\":{\"1\":{\"imgs\":[74474566," +
                          "74474568]}},\"Entrance\":{\"1\":{\"imgs\":[74474570]}}," +
                          "\"Bedroom\":{\"2\":{\"imgs\":[74474572,74474574],\"Bathroom\":{\"1\":[74474586]}}," +
                          "\"1\":{\"imgs\":[74474576,74474582],\"Bathroom\":{\"1\":[74474584]}}," +
                          "\"3\":{\"imgs\":[74474578,74474580]}},\"Masterplan\":{\"99\":{\"imgs\":[74519036]}}}";

      Map<Long, String> captions = getPidCaptionMap(jsonString);
      System.out.println(captions);
   }

   static Map<Long, String> getPidCaptionMap(String jsonString) {
      ObjectMapper mapper = new ObjectMapper();
      final Map<Long, String> captions = new HashMap<>();
      try {
         final Map<String, Integer> countMap = new HashMap<>();
         JsonNode node = mapper.readValue(jsonString, JsonNode.class);
         final Iterator<Map.Entry<String, JsonNode>> nodeIterator = node.fields();
         while (nodeIterator.hasNext()) {
            final Map.Entry<String, JsonNode> nodeEntry = nodeIterator.next();
            final String key = nodeEntry.getKey();
            final JsonNode value = nodeEntry.getValue();
            if (!countMap.containsKey(key)) {
               countMap.put(key, 0);
            }

            final Iterator<Map.Entry<String, JsonNode>> valueIterator = value.fields();
            while (valueIterator.hasNext()) {
               final Map.Entry<String, JsonNode> valueEntry = valueIterator.next();
               final String val = valueEntry.getKey();
               final JsonNode map = valueEntry.getValue();
               countMap.put(key, countMap.get(key) + 1);

               if (map != null && map.size() > 0) {
                  final Iterator<Map.Entry<String, JsonNode>> mapIterator = map.fields();
                  while (mapIterator.hasNext()) {
                     Map.Entry<String, JsonNode> mapEntry = mapIterator.next();
                     final String mpIndex = mapEntry.getKey();
                     final JsonNode mpValue = mapEntry.getValue();
                     if ("imgs".equals(mpIndex)) {
                        Iterator<JsonNode> pidIterator = mpValue.elements();
                        int i = 1;
                        while (pidIterator.hasNext()) {
                           long pid = pidIterator.next().asLong();
                           final String caption = "99".equals(val)
                              ? StringUtils.capitalize(key) + " - View " + i
                              : StringUtils.capitalize(key) + "-" + countMap.get(key) + " View " + i;
                           captions.put(pid, caption);
                           i++;
                        }
                     } else {
                        if (!countMap.containsKey(mpIndex)) {
                           countMap.put(mpIndex, 0);
                        }
                        Iterator<JsonNode> pidIterator = mpValue.elements();
                        while (pidIterator.hasNext()) {
                           countMap.put(mpIndex, countMap.get(mpIndex) + 1);
                           JsonNode pids = pidIterator.next();
                           for (int i = 0; i < pids.size(); i++) {
                              long pid = pids.get(i).asLong();
                              final String caption = StringUtils.capitalize(mpIndex) + "-" + countMap.get(mpIndex) +
                                                     " Attached with " + StringUtils.capitalize(
                                 mpIndex) + "-" + countMap.get(key) + "- View " + (i + 1);
                              captions.put(pid, caption);
                           }
                        }
                     }
                  }
               }
            }
         }
      } catch (IOException e) {
         e.printStackTrace();
      }

      return captions;
   }
}