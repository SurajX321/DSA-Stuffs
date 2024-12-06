package TCSCodeVIta;

import java.util.*;

public class SevenSegmentSumOptimized {

    private static final int NUM_SEGMENTS = 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read 3x9 matrix for digits 0 to 9
        char[][] digitsMatrix = new char[3][9];
        for (int i = 0; i < 3; i++) {
            digitsMatrix[i] = sc.nextLine().toCharArray();
        }

        // Map each digit to its 3x3 representation
        Map<String, Integer> digitMap = new HashMap<>();
        String[] patterns = new String[10];
        for (int d = 0; d < 10; d++) {
            StringBuilder digitPattern = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                digitPattern.append(digitsMatrix[i], d * 3, 3);
            }
            String pattern = digitPattern.toString();
            digitMap.put(pattern, d);
            patterns[d] = pattern;
        }

        // Precompute valid neighbors for each digit pattern
        Map<String, List<String>> neighborsMap = precomputeNeighbors(patterns);

        // Read the 3xN matrix for the provided number
        List<String> inputNumberPatterns = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char[] line = sc.nextLine().toCharArray();
            for (int j = 0; j < line.length / 3; j++) {
                if (inputNumberPatterns.size() <= j) {
                    inputNumberPatterns.add("");
                }
                inputNumberPatterns.set(j, inputNumberPatterns.get(j) + new String(line, j * 3, 3));
            }
        }

        // Validate and process input digits
        long totalSum = 0;
        List<Integer> digits = new ArrayList<>();
        for (String pattern : inputNumberPatterns) {
            if (!digitMap.containsKey(pattern)) {
                // Try toggling one light to form a valid digit
                if (!neighborsMap.containsKey(pattern)) {
                    System.out.println("Invalid");
                    return;
                }
                digits.add(digitMap.get(neighborsMap.get(pattern).get(0)));
            } else {
                digits.add(digitMap.get(pattern));
            }
        }

        // Generate numbers by toggling one light for each digit
        totalSum += generateAllNumbersSum(digits, neighborsMap, inputNumberPatterns, digitMap);

        // Print the total sum
        System.out.println(totalSum);
    }

    // Precompute neighbors for all digit patterns
    private static Map<String, List<String>> precomputeNeighbors(String[] patterns) {
        Map<String, List<String>> neighborsMap = new HashMap<>();
        for (String pattern : patterns) {
            List<String> neighbors = new ArrayList<>();
            for (int i = 0; i < NUM_SEGMENTS; i++) {
                char[] toggledPattern = pattern.toCharArray();
                toggledPattern[i] = (toggledPattern[i] == '1') ? '0' : '1';
                String toggledString = new String(toggledPattern);
                if (Arrays.asList(patterns).contains(toggledString)) {
                    neighbors.add(toggledString);
                }
            }
            neighborsMap.put(pattern, neighbors);
        }
        return neighborsMap;
    }

    // Generate sum of all numbers by toggling one light for each digit
    private static long generateAllNumbersSum(
            List<Integer> digits,
            Map<String, List<String>> neighborsMap,
            List<String> inputPatterns,
            Map<String, Integer> digitMap) {
        long totalSum = 0;

        for (int i = 0; i < digits.size(); i++) {
            String originalPattern = inputPatterns.get(i);
            int originalDigit = digits.get(i);

            // Add original number
            totalSum += toNumber(digits);

            // Generate all numbers by toggling one light
            for (String neighbor : neighborsMap.getOrDefault(originalPattern, Collections.emptyList())) {
                int neighborDigit = digitMap.get(neighbor);
                List<Integer> newDigits = new ArrayList<>(digits);
                newDigits.set(i, neighborDigit);
                totalSum += toNumber(newDigits);
            }
        }

        return totalSum;
    }

    // Convert a list of digits into a number
    private static long toNumber(List<Integer> digits) {
        long num = 0;
        for (int digit : digits) {
            num = num * 10 + digit;
        }
        return num;
    }
}
