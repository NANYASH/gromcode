package core.lesson34.hw;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

import static core.lesson34.hw.Processing.*;


public class Solution {
    public static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        Validator.validateAdd(fileFromPath, fileToPath);
        StringBuffer textFileFrom = Processing.readFromFile(fileFromPath);
        StringBuffer textFileTo = Processing.readFromFile(fileToPath);
        try {
            writeToFile(fileToPath, Processing.readFromFile(fileFromPath), true);
        } catch (Exception e) {
            revertTransfer(fileToPath, textFileTo);
            throw new Exception("File is not transferred" + new File(fileFromPath));
        }
        try {
            delete(fileFromPath);
        } catch (Exception e) {
            revertTransfer(fileToPath, textFileTo);
            revertTransfer(fileFromPath, textFileFrom);
            throw new Exception("File is not transferred" + new File(fileFromPath));
        }

    }

    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        Validator.validateAdd(fileFromPath, fileToPath);
        StringBuffer textFileFrom = readFromFile(fileFromPath);
        StringBuffer textFileTo = readFromFile(fileToPath);
        List<String> sentences = splitForSentences(fileFromPath);
        try {
            writeToFile(fileToPath, getSentencesToWrite(sentences, word), true);
        } catch (Exception e) {
            revertTransfer(fileToPath, textFileTo);
            throw new Exception("File is not transferred" + new File(fileFromPath));
        }
        try {
            deleteSentencesByWord(fileFromPath, sentences, word);
            System.out.println(sentences);
        } catch (Exception e) {
            revertTransfer(fileToPath, textFileTo);
            revertTransfer(fileFromPath, textFileFrom);
            throw new Exception("File is not transferred" + new File(fileFromPath));
        }
    }

    public static void copyFileContent(String fileFromPath, String fileToPath) throws IOException {
        Files.copy(new File(fileFromPath).toPath(), new File(fileToPath).toPath());
    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws IOException {
        FileUtils.copyFile(new File(fileFromPath), new File(fileToPath));

    }
}
