import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        for (int i : nums) {
            tempList.add(i);
        }
        backTrack(0, tempList, resList);
        return resList;
    }

    public void backTrack(int first, List<Integer> tempList, List<List<Integer>> resList) {
        int size = tempList.size();
        if (first == size) {
            resList.add(new ArrayList<>(tempList));
        }
        Set<Integer> usedMap = new HashSet<>();

        for (int i = first; i < size; i++) {
            if (usedMap.contains(tempList.get(i)))
                continue;

            usedMap.add(tempList.get(i));
            Collections.swap(tempList, first, i);
            backTrack(first + 1, tempList, resList);
            Collections.swap(tempList, i, first);
        }
    }
}