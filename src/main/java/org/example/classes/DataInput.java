package org.example.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataInput {

    public static float [][] inputMatrix(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        int rows = lines.size();
        int cols = lines.getFirst().trim().split("\\s+").length;
        float[][] matrix = new float[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] parts = lines.get(i).trim().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Float.parseFloat(parts[j]);
            }
        }
        return matrix;
    }

    public static float[] inputColumn(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        int rows = lines.size();
        float[] column = new float[rows];
        for (int i = 0; i < rows; i++) {
            column[i] = Float.parseFloat(lines.get(i).trim());
        }
        return column;
    }

}