import java.util.HashSet;

class Solution {
    HashSet<Integer> mainAxios = new HashSet<>(); // row + col = const
    HashSet<Integer> secondaryAxios = new HashSet<>(); // row - col = const
    HashSet<Integer> columns = new HashSet<>(); // 已使用 column

    int length;
    int sum = 0;

    public int totalNQueens(int n) {
        length = n;
        backTrack(0);
        return sum;
    }

    public void backTrack(int row) {
        if (row == length) {
            sum++;
            return;
        }
        for (int col = 0; col < length; col++) {
            if (checkValid(row, col)) {
                setQueen(row, col);
                backTrack(row + 1);
                removeQueen(row, col);
            }
        }
    }

    void setQueen(int row, int col) {
        columns.add(col);
        mainAxios.add(row + col);
        secondaryAxios.add(row - col + length - 1);
    }

    void removeQueen(int row, int col) {
        columns.remove(col);
        mainAxios.remove(row + col);
        secondaryAxios.remove(row - col + length - 1);
    }

    boolean checkValid(int row, int col) {
        boolean exist = !columns.contains(col) && !mainAxios.contains(row + col)
                && !secondaryAxios.contains(row - col + length - 1);
        return exist;
    }
}