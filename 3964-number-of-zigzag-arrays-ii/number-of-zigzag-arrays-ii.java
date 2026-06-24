class Solution {
    static final int MOD = 1_000_000_007;
    private long[][] multiplyMatrices(long[][] matrixA, long[][] matrixB) {
        int size = matrixA.length;
        long[][] result = new long[size][size];
        for (int row = 0; row < size; row++) {
            for (int mid = 0; mid < size; mid++) {
                if (matrixA[row][mid] == 0) continue;
                for (int col = 0; col < size; col++) {
                    result[row][col] = (
                        result[row][col] + matrixA[row][mid] * matrixB[mid][col]
                    ) % MOD;
                }
            }
        }
        return result;
    }
    private long[][] matrixPower(long[][] matrix, int power) {
        int size = matrix.length;
        long[][] result = new long[size][size];
        for (int row = 0; row < size; row++) {
            result[row][row] = 1;
        }
        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiplyMatrices(result, matrix);
            }
            matrix = multiplyMatrices(matrix, matrix);
            power >>= 1;
        }
        return result;
    }
    public int zigZagArrays(int n, int l, int r) {
        int valueCount = r - l + 1;
        long[] initialDp = new long[valueCount];
        for (int i = 0; i < valueCount; i++) {
            initialDp[i] = i;
        }
        long[][] transitionMatrix = new long[valueCount][valueCount];
        for (int row = 1; row < valueCount; row++) {
            for (int col = valueCount - row; col < valueCount; col++) {
                transitionMatrix[row][col] = 1;
            }
        }
        long[][] poweredTransition = matrixPower(transitionMatrix, n - 2);
        long answer = 0;
        for (int row = 0; row < valueCount; row++) {
            for (int col = 0; col < valueCount; col++) {
                answer = (answer + poweredTransition[row][col] * initialDp[col]) % MOD;
            }

        }
        return (int)(answer * 2 % MOD);
    }
}