class Solution {
    public int romanToInt(String s) {
        int[] key = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] value = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XL", "L", "XC", "C", "CD", "D",
                "CM", "M" };
        int temp = 0, index = 0;
        for (int i = 17; i >= 0; i--) {
            if (s.startsWith(value[i], index)) {
                temp += key[i];
                index += value[i].length();
                i++;
            }
        }
        return temp;
    }
}