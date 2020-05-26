
class Solution {
    public String intToRoman(int num) {
        int[] key = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] value = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XL", "L", "XC", "C", "CD", "D",
                "CM", "M" };
        String temp = "";
        for (int i = 17; i >= 0; i--) {
            if (num / key[i] > 0) {
                for (int j = 0; j < num / key[i]; j++)
                    temp += value[i];
                num = num % key[i];
            }
        }
        return temp;
    }
}