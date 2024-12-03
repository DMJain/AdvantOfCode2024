package org.example.dayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class puzelTwo {
    public static void main(String[] args) {
        int safeReportCount = 0;

        // Replace "input.txt" with the actual path to your text file
        try (Scanner scanner = new Scanner(new File("D:\\Development\\AdventOfCode\\AdventOfCode2024\\src\\main\\java\\org\\example\\dayTwo\\input.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (isSafeReport(line)) {
                    safeReportCount++;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        System.out.println("Number of safe reports (with Problem Dampener): " + safeReportCount);
    }

    public static boolean isSafeReport(String report) {
        String[] levelsStr = report.split("\\s+");
        int[] levels = new int[levelsStr.length];

        for (int i = 0; i < levelsStr.length; i++) {
            levels[i] = Integer.parseInt(levelsStr[i]);
        }

        if (levels.length < 2) {
            return true;
        }
        int balance = 0;

        boolean isIncreasing = levels[1] > levels[0];

        for (int i = 1; i < levels.length; i++) {
            int diff = levels[i] - levels[i - 1];
            if ((Math.abs(diff) < 1 || Math.abs(diff) > 3) || (isIncreasing && diff < 0) || (!isIncreasing && diff > 0)) {
                balance++;
                if(balance > 1) {
                    return false;
                }
            }
        }

        return true; // All checks passed
    }
}
