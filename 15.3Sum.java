import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();

        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        Object[] numsTemp = set.toArray();

        int length = numsTemp.length;
        int index = -1;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                index = Arrays.binarySearch(numsTemp, i + 1, length, (0 - (int) numsTemp[i] - (int) numsTemp[j]));
                if (index > i && index < length) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();

                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[index]);

                    re.add(temp);
                }
            }
        }
        return re;
    }
}