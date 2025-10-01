package to200.to140;

import java.util.HashMap;

class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length / 2 + 1);
        for(Integer num : nums) {
            if (map.get(num) != null) {
                map.remove(num);
            } else {
                map.put(num, 0);
            }
        }
        return (int)map.keySet().toArray()[0];
    }
}
