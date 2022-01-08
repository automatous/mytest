package com.example.demo.interview.alg;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CodingInterviewGuide {

    // /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ =================== bitwise =================== /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\

    public static int oppositeNum(int a) {
        return add(~a, 1);
    }

    public static int addRecursive(int a, int b) {
        return a == 0 ? b : addRecursive((a & b) << 1, a ^ b);
    }

    public static int add(int a, int b) {
        int t;
        while (a != 0) {
            t = (a & b) << 1;
            b = a ^ b;
            a = t;
        }
        return b;
    }

    public static int sub(int a, int b) {
        return add(a, oppositeNum(b));
    }

    @Test
    public void testSum() {
        int[][] matrix = {
                {1, 3},
                {10, 0},
                {-1, 1},
                {0, 0},
                {0, 1},
                {-1, 0},
                {-1, -1}
        };
        for (int[] a : matrix) {
            System.out.print(Arrays.toString(a));
            System.out.print(": \t\t");
            System.out.print(addRecursive(a[0], a[1]));
            System.out.print("\t");
            System.out.print(add(a[0], a[1]));
            System.out.print("\t");
            System.out.print(sub(a[0], a[1]));
            System.out.println();
        }
    }


    /**
     * 1和0转换
     * 输入只能是1或0: 1->0, 0->1
     */
    public static int flip(int n) {
        return n ^ 1;
    }

    /**
     * n >= 0时, 返回1
     * n < 0时, 返回0
     */
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int getMax(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    @Test
    public void testGetMax() {
        int[][] matrix = {
                {1, 3},
                {10, 0},
                {-1, 1},
                {0, 0},
                {0, 1},
                {-1, 0}
        };
        for (int[] a : matrix) {
            System.out.println(getMax(a[0], a[1]));
        }
    }


    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    @Test
    public void testSwap() {
        int[][] matrix = {
                {1, 3},
                {10, 0},
                {-1, 1},
                {0, 0},
                {0, 1},
                {-1, 0}
        };

        for (int[] a : matrix) {
            swap(a, 0, 1);
            System.out.println(Arrays.toString(a));
        }
    }

    // \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ =================== bitwise =================== \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/




    // /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ =================== dp =================== /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\

    public static int leastSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < cols; i++) {
            dp[0][i] = matrix[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = matrix[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public static int leastSumPlus(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int min = Math.min(rows, cols);
        int max = Math.max(rows, cols);
        boolean isRows = rows < cols;

        int[] a = new int[min];
        a[0] = matrix[0][0];
        for (int i = 1; i < min; i++) {
            a[i] = a[i - 1] + (isRows ? matrix[0][i] : matrix[i][0]);
        }

        for (int i = 1; i < max; i++) {
            a[0] = a[0] + (isRows ? matrix[i][0] : matrix[0][i]);
            for (int j = 1; j < min; j++) {
                a[j] = Math.min(a[j], a[j - 1]) + (isRows ? matrix[i][j] : matrix[j][i]);
            }
        }

        return a[min - 1];
    }

    @Test
    public void testLeastSum() {
        int[][] matrix = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };

        System.out.println(leastSum(matrix));
        System.out.println(leastSumPlus(matrix));
    }

    // ===============================================================================================

    public static int walk(int N, int cur, int rest, int p) {
        if (rest == 0) {
            return cur == p ? 1 : 0;
        }

        if (cur == 1) {
            return walk(N, 2, rest - 1, p);
        } else if (cur == N) {
            return walk(N, N - 1, rest - 1, p);
        } else {
            return walk(N, cur + 1, rest - 1, p) + walk(N, cur - 1, rest - 1, p);
        }
    }

    public static int ways1(int N, int cur, int rest, int p) {
        if (N < 2 || cur < 1 || cur > N || rest < 1 || p < 1 || p > N) {
            return 0;
        }
        return walk(N, cur, rest, p);
    }

    public static int ways2(int N, int M, int K, int P) {
        if (N < 2 || M < 1 || M > N || K < 1 || P < 1 || P > N) {
            return 0;
        }

        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][N - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }

        return dp[K][M];
    }

    public static int ways3(int N, int M, int K, int P) {
        if (N < 2 || M < 1 || M > N || K < 1 || P < 1 || P > N) {
            return 0;
        }

        int[] dp = new int[N + 1];
        dp[P] = 1;
        for (int i = 1; i <= K; i++) {
            int leftUp = dp[1];
            for (int j = 1; j <= N; j++) {
                int tmp = dp[j];
                if (j == 1) {
                    dp[j] = dp[2];
                } else if (j == N) {
                    dp[j] = leftUp;
                } else {
                    dp[j] = leftUp + dp[j + 1];
                }
                leftUp = tmp;
            }
        }
        return dp[M];
    }


    @Test
    public void testWays() {
        int[][] aa = {
                {5, 2, 3, 3},   // 3
                {3, 1, 3, 3}    // 0
        };

        for (int[] a : aa) {
//            int cnt = ways1(a[0], a[1], a[2], a[3]);
//            int cnt = ways2(a[0], a[1], a[2], a[3]);
            int cnt = ways3(a[0], a[1], a[2], a[3]);
            System.out.println(cnt);
        }
    }

    // \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ =================== dp =================== \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/


    // /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ =================== dfs/bfs =================== /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\ /\

    // \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ =================== dfs/bfs =================== \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/
}
