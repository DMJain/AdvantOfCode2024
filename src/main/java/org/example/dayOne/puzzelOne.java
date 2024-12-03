package org.example.dayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class puzzelOne {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Replace "input.txt" with the actual path to your text file
        try (Scanner scanner = new Scanner(new File("D:\\Development\\AdventOfCode\\AdventOfCode2024\\src\\main\\java\\org\\example\\dayOne\\input1.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");
                // Split by whitespace
                if (parts.length
 == 2) {
                    try {
                        list1.add(Integer.parseInt(parts[0]));
                        list2.add(Integer.parseInt(parts[1]));
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

        int totalDistance = calculateTotalDistance(list1, list2);
        System.out.println("Total distance between the lists: " + totalDistance);
    }

    public static int calculateTotalDistance(List<Integer> list1, List<Integer> list2) {
        // 1. Sort the lists
        Collections.sort(list1);
        Collections.sort(list2);

        int totalDistance = 0;
        // 2. Pair the numbers and 3. Calculate distances
        for (int i = 0; i < list1.size(); i++) {
            totalDistance += Math.abs(list1.get(i) - list2.get(i));
        }

        // 4. Return the sum of the distances
        return totalDistance;
    }
}
