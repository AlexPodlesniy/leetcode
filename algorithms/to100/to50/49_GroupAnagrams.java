package to100.to50;

import java.util.*;

class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sortedArr = str.toCharArray();
            Arrays.sort(sortedArr);
            String sorted = String.valueOf(sortedArr);

            if (map.get(sorted) == null) {
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                map.put(sorted, newList);
            } else {
                map.get(sorted).add(str);
            }
        } return new ArrayList(map.values());
    }
}
