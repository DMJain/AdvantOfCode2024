package org.example.dayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class puzelTwo {
    public static void main(String[] args) {
        Map<Integer, Integer> list1Freq = new HashMap<>();
        Map<Integer, Integer> list2Freq = new HashMap<>();

        // Replace "input.txt" with the actual path to your text file
        try (Scanner scanner = new Scanner(new File("D:\\Development\\AdventOfCode\\AdventOfCode2024\\src\\main\\java\\org\\example\\dayOne\\input1.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+"); // Split by whitespace
                if (parts.length == 2) {
                    try {
                        int list1Val = Integer.parseInt(parts[0]);
                        list1Freq.put(list1Val, list1Freq.getOrDefault(list1Val, 0) + 1);
                        int list2Val = Integer.parseInt(parts[1]);
                        list2Freq.put(list2Val, list2Freq.getOrDefault(list2Val, 0) + 1);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input: " + line);
                    }
                } else {
                    System.err.println("Invalid input: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            e.printStackTrace();
        }

        int similarityScore = calculateSimilarityScore(list1Freq, list2Freq);
        System.out.println("Similarity score between the lists: " + similarityScore);
    }
    public static int calculateSimilarityScore(Map<Integer, Integer> list1Freq,Map<Integer, Integer> list2Freq){
        int similarityScore = 0;
        for (Map.Entry<Integer, Integer> entry : list1Freq.entrySet()) {
            int num = entry.getKey();
            int countInList1 = entry.getValue();
            int countInList2 = list2Freq.getOrDefault(num, 0);
            similarityScore += num * countInList1 * countInList2;
        }
        return similarityScore;
    }
}
