package core.lesson34.hw;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Processing {
    //chars()-returns a stream of ints (IntStream) that represent the character codes
    //mapToObj - converts int stream to the object stream?
    //(char) - casts object stream to char
    //collect() - places objects to collection
    //Collectors.toList() - converts to list collection
        /*for (int i = 0; i < textToSplit.length(); i++) {
            characters.add(textToSplit.charAt(i));
        }*/

    public static List<String> splitForSentences(String fileFromPath) throws Exception {
        StringBuffer textToSplit = Processing.readFromFile(fileFromPath);
        List<Character> characters = textToSplit.chars().mapToObj(ch -> (char) ch).collect(Collectors.toList());
        List<String> sentences = new ArrayList<>();
        String sentence = "";
        for (Character character : characters) {
            sentence += character.charValue();
            if (character == '.' && sentence.length() >= 10) {
                sentences.add(sentence);
                sentence = "";
            }
        }
        return sentences;
    }

    public static List<String> findSentencesByWord(List<String> sentences, String word) {
        List<String> newSentences = new ArrayList<>();
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                newSentences.add(sentence);
            }
        }
        return newSentences;
    }

    public static StringBuffer readFromFile(String fileFromPath) throws Exception {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(fileFromPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append("\n");
                res.append(line);
            }
        } catch (IOException e) {
            throw new Exception("Reading from file " + fileFromPath + " failed");
        }
        return res;
    }

    public static StringBuffer getSentencesToWrite(List<String> sentences, String word) throws Exception {
        StringBuffer finalText = new StringBuffer();
        List<String> sentencesToWrite = findSentencesByWord(sentences, word);
        sentencesToWrite.forEach(string -> finalText.append(string));
        return finalText;
    }


    public static void writeToFile(String fileToPath, StringBuffer contentToWrite, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToPath, append))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            new Exception("File cannot be edited" + fileToPath);
        }
    }

    public static void revertTransfer(String fileToPath, StringBuffer string) throws Exception {
        writeToFile(fileToPath, string, false);
    }

    public static List<String> deleteSentencesByWord(String fileFromPath, List<String> sentences, String word) {
        StringBuffer stringBuffer = new StringBuffer();
        sentences.forEach(sentence -> {
            if (!sentence.contains(word)) stringBuffer.append(sentence);
        });
        writeToFile(fileFromPath, stringBuffer, false);
        return sentences;
    }

    public static void delete(String fileFromPath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileFromPath, false))) {
            bufferedWriter.append("");
        } catch (IOException e) {
            new Exception("File cannot be cleared." + fileFromPath);
        }
    }

}
