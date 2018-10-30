import java.util.ArrayList;

/**
 * Created by chandan on 26/10/18.
 */
public class TextSplit {

   static ArrayList<String> splitText(String message, int charLimit) {

      return splitTextAuxUsingSplit(message, charLimit);
   }

   static ArrayList<String> splitTextAuxUsingSplit(String message, int charLimitOriginal) {
      if (message == null || message.length() == 0) {
         return new ArrayList<>();
      } else if (message.length() <= charLimitOriginal) {
         ArrayList<String> result = new ArrayList<String>();
         result.add(message);
         return result;
      }
      //Decrease the char limit to accomodate chunk number at the end i.e. (1/3). For now assuming, the message
      // chunks won't be more than 9
      int charLimit = charLimitOriginal - 5;
      //New arraylist to store message chunks
      ArrayList<String> result = new ArrayList<String>();
      String[] splitted = message.split(" ");
      String temp;

      for (int i = 0; i < splitted.length - 1; i++) {
         temp = splitted[i];
         //while length of temp and the next element combined is less than charLimit, temp = temp + next element
         //Last element to be taken care of after this loop
         while ((temp + 1 + splitted[i + 1]).length() <= charLimit && i + 1 < splitted.length - 1) {  //+1 for space
            temp = temp + " " + splitted[i + 1];
            i++;
         }
         result.add(temp);

      }
      //Take care of the last element
      //Add the last element from splitted to the last element of result if their combined length is less than charLimit
      String lastElement = result.get(result.size() - 1);
      if (lastElement.length() + 1 + splitted[splitted.length - 1].length() < charLimit) {  //+1 for space

         result.set(result.size() - 1, lastElement + " " + splitted[splitted.length - 1]);
      } else {
         result.add(splitted[splitted.length - 1]);
      }

      //append message chunk number for ex (1/3)
      int resultSize = result.size();
      for (int i = 0; i < resultSize; i++) {
         result.set(i, result.get(i) + "(" + (i + 1) + "/" + resultSize + ")");
      }


      return result;
   }

   public static void main(String[] args) {
      String message;
      int charLmit;
      message = "The best lies are always mixed with a little truth";
      message = "There is no creature on earth half so terryfying as a truly just man!!!!!";
      message = "You know nothing, Jon Snow";
      charLmit = 30;
      ArrayList<String> result = splitText(message, charLmit);
      for (String item : result) {
         System.out.println("Length = " + item.length() + " : " + item);
      }
      System.out.println(result.toString());
   }
}