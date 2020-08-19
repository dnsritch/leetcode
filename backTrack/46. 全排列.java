import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();//当前路径

        for (int item : nums)
            tempList.add(item);

        backTrack(0, tempList, resList);


        // 决策树解法s
        // Set<Integer> flagSet = new HashSet<>();  // 当前已选择元素
        // decisionTree(nums, flagSet, tempList, resList);

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

    
    // 决策树解法
    public void decisionTree(int[] nums,Set<Integer> flagSet, List<Integer>tempList, List<List<Integer>> resList ){
        if (tempList.size() == nums.length){
            resList.add(new ArrayList<>(tempList));
            return;
        }
            
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (!flagSet.contains(temp)) {
                tempList.add(temp);
                flagSet.add(temp);
                decisionTree(nums, flagSet, tempList, resList);
                tempList.remove(tempList.size()-1);
                flagSet.remove(temp);
            }
        }
    }
}