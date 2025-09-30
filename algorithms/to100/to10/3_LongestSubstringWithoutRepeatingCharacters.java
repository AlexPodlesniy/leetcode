package to100.to10;

import java.util.LinkedList;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int wStart = 0;
        int wEnd = 0;

        int maxUniqueLength = 0;
        int currentUniqueLength = 0;
        LinkedList<Character> uniqueChars = new LinkedList<>();

        while(wEnd < arr.length) {
            if (!uniqueChars.contains(arr[wEnd])) {
                uniqueChars.add(arr[wEnd]);
                currentUniqueLength++;
                if (currentUniqueLength > maxUniqueLength) {
                    maxUniqueLength = currentUniqueLength;
                }
            } else {
                Character removedChar = null;
                do {
                    removedChar = uniqueChars.poll();
                    currentUniqueLength--;
                } while(!removedChar.equals(arr[wEnd]));
                uniqueChars.add(arr[wEnd]);
                currentUniqueLength++;
            }
            wEnd++;
        }
        return maxUniqueLength;
    }
}
