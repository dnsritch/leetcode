// longest increased substring

public class LIS {

    public static void main(String[] args) {
        int[] list = new int[] { 1, 5, 3, 4, 6, 9, 7, 8 };
        int[] res = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i])
                    res[i] = Math.max(res[i], res[j] + 1);
            }
            System.out.printf("f[%d]=%d\n", i, res[i]);
        }
    }

}