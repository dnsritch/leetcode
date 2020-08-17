import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        for (int item : nums)
            tempList.add(item);

        return resList;
    }

    public void backTrack(List<Integer> tempList, int first, int length, List<List<Integer>> resliList) {
        if (first == length) {
            resliList.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = first; i < tempList.size(); i++) {

        }
    }

    // 决策树解法
    public void decisionTree(int[] tempArray,int ){

    }

}