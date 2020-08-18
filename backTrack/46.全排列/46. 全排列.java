import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        for (int item : nums)
            tempList.add(item);

        backTrack(0, tempList, resList);

        return resList;
    }

    public void backTrack(int first, List<Integer> tempList, List<List<Integer>> resList) {
        if (first == tempList.size()) {
            resList.add(new ArrayList<>(tempList));
        } else {
            int length = tempList.size();
            for (int i = first; i < length; i++) {
                Collections.swap(tempList, first, i);
                backTrack(first + 1, tempList, resList);
                Collections.swap(tempList, i, first);
            }
        }
    }
}