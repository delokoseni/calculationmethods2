package org.example.classes;

public class TridiagonalSolver {

    public static float[] solve(float[][] A, float[] d) {
        int n = A.length;

        if (A[0].length != n || d.length != n) {
            throw new IllegalArgumentException("Матрица должна быть квадратной, а размер вектора b совпадать с n");
        }
        float[] a = new float[n]; // поддиагональ
        float[] b = new float[n]; // главная диагональ
        float[] c = new float[n]; // наддиагональ
        // Разбор матрицы A
        for (int i = 0; i < n; i++) {
            b[i] = A[i][i];
            if (i > 0) {
                a[i] = A[i][i - 1];
            }
            if (i < n - 1) {
                c[i] = A[i][i + 1];
            }
        }
        // Массивы для коэффициентов прогонки
        float[] alpha = new float[n];
        float[] beta = new float[n];
        // --- Прямая прогонка ---
        alpha[0] = -c[0] / b[0];
        beta[0] = d[0] / b[0];
        for (int i = 1; i < n; i++) {
            float denom = b[i] + a[i] * alpha[i - 1];
            if (denom == 0) {
                throw new ArithmeticException("Деление на ноль в методе прогонки");
            }
            alpha[i] = (i < n - 1) ? (-c[i] / denom) : 0; // для последнего alpha[n-1] = 0
            beta[i] = (d[i] - a[i] * beta[i - 1]) / denom;
        }
        // --- Обратная прогонка ---
        float[] x = new float[n];
        x[n - 1] = beta[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            x[i] = alpha[i] * x[i + 1] + beta[i];
        }
        return x;
    }
}
