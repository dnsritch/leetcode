import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {

    HashMap<Integer, Integer> rowMap = new HashMap<>();
    HashMap<Integer, Integer> columnMap = new HashMap<>();
    HashMap<Integer, Integer> mainAxiosMap = new HashMap<>(); // row + col = const
    HashMap<Integer, Integer> secondaryAxiosMap = new HashMap<>(); // row - col = const

    HashSet<Integer> lampSet = new HashSet<>();

    int[] res;
    int length;

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        length = N;
        res = new int[queries.length];

        for (int[] array : lamps) {
            int row = array[0];
            int col = array[1];

            mapPut(rowMap, row, 1);
            mapPut(columnMap, col, 1);
            mapPut(mainAxiosMap, row + col, 1);
            mapPut(secondaryAxiosMap, row - col + length - 1, 1);

            lampSet.add(row * length + col);
        }

        for (int i = 0; i < queries.length; i++) {
            int[] array = queries[i];
            int row = array[0];
            int col = array[1];

            res[i] = isExist(row, col) ? 1 : 0;

            // 关灯
            int[][] temp = { { row, col }, { row - 1, col - 1 }, { row - 1, col }, { row - 1, col + 1 },
                    { row, col - 1 }, { row, col + 1 }, { row + 1, col - 1 }, { row + 1, col }, { row + 1, col + 1 } };
            for (int[] lamp : temp) {
                int tempRow = lamp[0];
                int tempCol = lamp[1];
                int code = tempRow * length + tempCol;
                if (lampSet.contains(code)) {
                    removeLamp(tempRow, tempCol);
                    lampSet.remove(code);
                }
            }
        }

        return res;
    }

    // 是否点亮
    boolean isExist(int row, int col) {
        boolean exist = rowMap.getOrDefault(row, 0) > 0 || columnMap.getOrDefault(col, 0) > 0
                || mainAxiosMap.getOrDefault(row + col, 0) > 0
                || secondaryAxiosMap.getOrDefault(row - col + length - 1, 0) > 0;

        return exist;
    }

    // 简化 map 键值 修改
    void mapPut(HashMap<Integer, Integer> map, int key, int value) {
        int val = map.getOrDefault(key, 0);
        map.put(key, val + value);
    }

    // 移除电灯
    void removeLamp(int row, int col) {
        mapPut(rowMap, row, -1);
        mapPut(columnMap, col, -1);
        mapPut(mainAxiosMap, row + col, -1);
        mapPut(secondaryAxiosMap, row - col + length - 1, -1);
    }
}