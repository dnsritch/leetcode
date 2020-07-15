import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {

    List<List<Integer>> resList = new LinkedList<>();
    int n, k;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        backTrack(1, new LinkedList<Integer>());
        return resList;
    }

    void backTrack(int first, LinkedList<Integer> temp) {
        if (temp.size() == k) {
            resList.add(new LinkedList<>(temp));
            return;
        }
        for (int i = first; i < n + 1; i++) {
            temp.add(i);
            backTrack(i + 1, temp);
            temp.removeLast();
        }
    }
}