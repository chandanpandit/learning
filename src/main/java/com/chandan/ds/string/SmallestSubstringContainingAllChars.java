package com.chandan.ds.string;

public class SmallestSubstringContainingAllChars {
    public static void main(String[] args) {
        String str = "this is a test string";
        String pat = "tist";
        System.out.println(subString(str,pat));
    }
    static String subString(String str, String pat){
        int TOTAL_CHARS = 256;
        if(str == null || pat == null)
            return null;
        int[] hashPat = new int[TOTAL_CHARS];
        int[] hashStr = new int[TOTAL_CHARS];
        if(pat.length() > str.length()){
            return null;
        }
        for (int i = 0; i < pat.length(); i++) {
            hashPat[pat.charAt(i)]++;
        }

        int start = 0, startIndex = -1, minLen = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            hashStr[str.charAt(i)]++;

            // if this char is matches the char in pattern, increment the count
            if(hashPat[str.charAt(i)] != 0 && hashStr[str.charAt(i)] <= hashPat[str.charAt(i)]){
                count++;
            }

            if(count == pat.length()){
                //remove un-neccessary elements and the elements which have more occurances than required from beginning
                while (hashPat[str.charAt(start)] == 0 ||  hashStr[str.charAt(start)] > hashPat[str.charAt(start)]){
                    if(hashStr[str.charAt(start)] > hashPat[str.charAt(start)])
                        hashStr[str.charAt(start)]--;
                    start++;
                }

                //update the min length & startIndex if required
                int windowLen = i - start + 1;
                if(minLen > windowLen){
                    minLen = windowLen;
                    startIndex = start;
                }
            }
        }

        if(startIndex == -1){
            return null;
        }

        return str.substring(startIndex,startIndex+minLen);
    }
}