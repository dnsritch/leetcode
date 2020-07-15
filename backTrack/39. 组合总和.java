import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    int target;
    int[] array;
    List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.array = candidates;

        backTrack(0, 0, new ArrayList<>());

        return resList;
    }

    void backTrack(int first, int sum, ArrayList<Integer> list) {
        if (sum == this.target) {
            resList.add(new ArrayList<>(list));
            return;
        }
        if (sum > this.target)
            return;

        for (int i = first; i < this.array.length; i++) {
            list.add(this.array[i]);
            backTrack(i, sum + this.array[i], list);
            list.remove(list.size() - 1);
        }

    }
}