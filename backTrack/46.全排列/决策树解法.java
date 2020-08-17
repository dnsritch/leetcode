import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>(); // 结果
        Set<Integer> flagSet = new HashSet<>();  //当前路径
        List<Integer> tempList = new ArrayList<>(); //已选择的元素

        decisionTree(nums, flagSet, tempList, resList);

        return resList;
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