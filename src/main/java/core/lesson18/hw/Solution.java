package core.lesson18.hw;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String test = null;
        System.out.println(Arrays.toString(findNumbers(test)));
    }

    public static int[] findNumbers(String text) {
        if (text == null || text.isEmpty()) return new int[0];
        String[] words = text.trim().split(" ");
        int index = 0;
        for (String word : words) {
            if (checkSymbols(word))
                index++;
        }
        int[] numbersFromText = new int[index];
        index = 0;
        for (String word : words) {
            if (checkSymbols(word)) {
                numbersFromText[index] = Integer.valueOf(word);
                index++;
            } else System.out.println("not a number");
        }
        return numbersFromText;
    }

    public static int[] findNumbers2(String text) {
        if (text == null || text.isEmpty()) return new int[0];
        String[] words = text.trim().split(" ");
        int index = 0;
        for (String word : words) {
            if (checkSymbols(word))
                index++;
        }
        int[] numbersFromText = new int[index];
        index = 0;
        for (String word : words) {
            try {
                numbersFromText[index] = Integer.valueOf(word);
                index++;
            } catch (NumberFormatException e) {
                System.err.println("not a number");
            }

        }
        return numbersFromText;
    }

    private static boolean checkSymbols(String word) {
        char[] symbols = word.toCharArray();
        for (char symbol : symbols) {
            if (!Character.isDigit(symbol))
                return false;
        }
        return true;
    }
}
