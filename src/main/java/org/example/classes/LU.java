package org.example.classes;

public class LU {
    public static void findLU(float [][] matrixA, float [][] matrixL, float [][] matrixU) {
        int n = matrixA.length;
        for (int i = 0; i < n; i++) {
            matrixL[i][i] = 1;
            for (int j = i; j < n; j++) {
                float sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += matrixL[i][k] * matrixU[k][j];
                }
                matrixU[i][j] = matrixA[i][j] - sum;
            }
            for (int j = i + 1; j < n; j++) {
                float sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += matrixL[j][k] * matrixU[k][i];
                }
                matrixL[j][i] = (matrixA[j][i] - sum) / matrixU[i][i];
            }
        }
    }

    public static float[][] multiplyMatrices(float[][] A, float[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;
        if (colsA != rowsB) {
            throw new IllegalArgumentException(
                    "Нельзя перемножить матрицы: A имеет " + colsA +
                            " столбцов, а B " + rowsB + " строк."
            );
        }
        float[][] result = new float[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                float sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static float calculateDet(float [][] matrixL, float [][] matrixU) {
        float detL = 1;
        float detU = 1;
        if (matrixL.length != matrixL[0].length ||
                matrixU.length != matrixU[0].length ||
                matrixL.length != matrixU.length) {
            throw new IllegalArgumentException("Матрицы L и U должны быть квадратными и одинакового размера");
        }
        for(int i = 0; i < matrixL.length; i++) {
            detL *= matrixL[i][i];
            detU *= matrixU[i][i];
        }
        return detL * detU;
    }

    public static float[] solveSystem(float[][] matrixL, float[][] matrixU, float[] column) {
        int n = matrixL.length;
        float[] y = new float[n];
        float[] x = new float[n];
        for (int i = 0; i < n; i++) {
            float sum = 0;
            for (int k = 0; k < i; k++) {
                sum += matrixL[i][k] * y[k];
            }
            y[i] = (column[i] - sum) / matrixL[i][i];
        }
        for (int i = n - 1; i >= 0; i--) {
            float sum = 0;
            for (int k = i + 1; k < n; k++) {
                sum += matrixU[i][k] * x[k];
            }
            x[i] = (y[i] - sum) / matrixU[i][i];
        }

        return x;
    }
}
