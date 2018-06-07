package core.lesson17.hw;


public class Solution {
    public static void main(String[] args) {
        String test = "There 1 is something new l12elelellelele or Test jot or lililillilili sdf sdf sdf Test";
        String test2 = "vest test test test test vest mess1 vest vest vest";
        String test3 = "  ";
        String test4 = "www.online2pdf";
        //System.out.println(countWords(test));
        //System.out.println(maxWord(test2));
        //System.out.println(minWord(test2));
        //System.out.println(mostCountedWord(test2));
        System.out.println(validate(test3));


    }

    public static int countWords(String input) {

        int numberOfWords = 0;
        String[] words = splitTrimString(input);

        for (String word : words) {
            if (checkWord(word) == true)
                numberOfWords++;
        }

        return numberOfWords;
    }

    private static boolean checkWord(String word) {
        char[] charsArray = word.toCharArray();

        if (word.isEmpty()) return false;

        for (char charSymbol : charsArray) {
            if (!Character.isLetter(charSymbol) && !Character.isWhitespace(charSymbol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkAddress(String address) {
        address = address.replaceAll("www.", "");
        char[] charsArray = address.toCharArray();

        if (address.isEmpty() || address == null) return false;

        for (char charSymbol : charsArray) {

            if (!Character.isLetter(charSymbol) && !Character.isDigit(charSymbol)) {
                return false;
            }
        }

        return true;
    }

    private static String[] splitTrimString(String string) {
        String[] words = string.split(" ");
        for (String word : words) {
            word = word.trim();
        }
        return words;
    }


    public static String maxWord(String input) {

        String[] words = splitTrimString(input);

        String maxWord = null;
        int index = 0;

        for (String word : words) {
            if (checkWord(word)) {
                maxWord = word;
                break;
            }
            index++;
        }
        for (int i = index + 1; i < words.length; i++) {
            if (checkWord(words[i]) && words[i].length() > words[index].length()) {
                maxWord = words[i];
                index = i;
            }
        }
        return maxWord;

    }


    public static String minWord(String input) {

        String[] words = splitTrimString(input);

        String minWord = null;
        int index = 0;

        for (String word : words) {
            if (checkWord(word)) {
                minWord = word;
                break;
            }
            index++;
        }
        for (int i = index + 1; i < words.length; i++) {
            if (checkWord(words[i]) && words[i].length() < words[index].length()) {
                minWord = words[i];
                index = i;
            }
        }
        return minWord;
    }

    public static String mostCountedWord(String input) {

        String[] words = splitTrimString(input);
        String mostCountedWord = null;

        for (String word : words) {
            if (checkWord(word)) {
                mostCountedWord = word;
                break;
            }
        }
        int oldIndex = 0;
        int newIndex = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (checkWord(words[i]) && words[i].equals(words[j])) {
                    newIndex++;
                }
            }
            if (checkWord(words[i]) && newIndex > oldIndex) {
                oldIndex = newIndex;
                mostCountedWord = words[i];
                newIndex = 0;
            }
        }
        return mostCountedWord;


    }

    public static boolean validate(String address) {
        address = address.trim();
        if (address == null || address.isEmpty())
            return false;
        String protocol = "";
        String address1 = "";
        String domen = address.substring(address.length() - 4, address.length());

        if (!address.substring(0, 7).equals("http://"))
            if (!address.substring(0, 8).equals("https://"))
                return false;
            else protocol = address.substring(0, 8);
        else protocol = address.substring(0, 7);

        if (!domen.equals(".com") && !domen.equals(".org") && !domen.equals(".net"))
            return false;

        if (protocol.equals(address.substring(0, 7)))
            address1 = address.substring(7, address.length() - 4);
        if (protocol.equals(address.substring(0, 8)))
            address1 = address.substring(8, address.length() - 4);

        return checkAddress(address1);
    }

    public static void replace(String input, String target, String replacement) {


    }
}
