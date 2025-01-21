package dsa;

import java.util.HashMap;

// https://leetcode.com/problems/first-completely-painted-row-or-column
public class L2661 {
    class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[] { i, j });
            }
        }

        int paintedRow[] = new int[m];
        int paintedCol[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int paintedRowIndex = (map.get(arr[i]))[0];
                int paintedColIndex = (map.get(arr[i]))[1];
                paintedRow[paintedRowIndex]++;
                paintedCol[paintedColIndex]++;

                System.out.println(paintedRowIndex + "--" + paintedColIndex + "--" + paintedRow[paintedRowIndex] + "--"
                        + paintedCol[paintedColIndex]);
                if (paintedRow[paintedRowIndex] == m || paintedCol[paintedColIndex] == n)
                    return i;
            }
        }
        return -1;
    }
}

public static void main(String[] args) {

}
}


