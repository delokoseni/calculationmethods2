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
}
