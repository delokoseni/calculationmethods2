package org.example;

import org.example.classes.DataInput;
import org.example.classes.LU;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        float[][] matrixLU = new float[0][];
        float[] columnLU = new float[0];
        float[][] matrixRunThrough = new float[0][];
        float[] columnRunThrough = new float[0];
        try {
            matrixLU = DataInput.inputMatrix("src/matrixLU.txt");
            columnLU = DataInput.inputColumn("src/columnLU.txt");
            matrixRunThrough = DataInput.inputMatrix("src/matrixRunThrough.txt");
            columnRunThrough = DataInput.inputColumn("src/columnRunThrough.txt");
        }
        catch(IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        System.out.println("Входные данные для LU-разложения:\nМатрица A:");
        for (float[] floats : matrixLU) {
            for (float aFloat : floats) {
                System.out.printf("%.2f\t", aFloat);
            }
            System.out.println();
        }
        System.out.println("\nСтолбец b:");
        for (float aFloat : columnLU) {
            System.out.printf("%.2f\n", aFloat);
        }
        float[][] matrixL = new float[matrixLU.length][matrixLU.length];
        float[][] matrixU = new float[matrixLU.length][matrixLU.length];
        LU.findLU(matrixLU, matrixL, matrixU);

        System.out.println("\nВходные данные для метода прогонки:\nМатрица A:");
        for (float[] floats : matrixRunThrough) {
            for (float aFloat : floats) {
                System.out.printf("%.2f\t", aFloat);
            }
            System.out.println();
        }
        System.out.println("\nСтолбец b:");
        for (float aFloat : columnRunThrough) {
            System.out.printf("%.2f\n", aFloat);
        }

    }
}