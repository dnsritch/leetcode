import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> leftmap = new HashMap<>();
        Map<Integer, Integer> rightmap = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (!count.containsKey(val))
                leftmap.put(val, i);
            int temp = count.getOrDefault(val, 0) + 1;
            count.put(val, temp);
            rightmap.put(val, i);

            if (temp > maxCount) {
                maxCount = temp;
                list.clear();
                list.add(val);
            }
            if (temp == maxCount) {
                list.add(val);
            }
        }

        int res = nums.length;
        for (Integer val : list) {
            res = Math.min(rightmap.get(val) - leftmap.get(val) + 1, res);
        }

        return res;
    }
}