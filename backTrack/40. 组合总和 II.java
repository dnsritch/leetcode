import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(candidates);

        backTrack(0, target, candidates, new ArrayList<>(), resList);

        return resList;
    }

    void backTrack(int first, int target, int[] array, ArrayList<Integer> list, List<List<Integer>> resList) {
        if (target == 0) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int i = first; i < array.length; i++) {
            int temp = array[i];
            // 大剪枝
            if (temp > target) {
                return;
                // 小剪枝
            } else if (i > first && array[i - 1] == array[i]) {
                continue;
            } else {
                list.add(temp);
                backTrack(i + 1, target - temp, array, list, resList);
                list.remove(list.size() - 1);
            }
        }
    }
}