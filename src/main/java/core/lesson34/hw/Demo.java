package core.lesson34.hw;


public class Demo {
    public static void main(String[] args) throws Exception {
        String word = "test";
        //System.out.println(Processing.getNumberOfLines("/Users/nanya/Desktop/fileFrom.txt"));
        //Solution.transferFileContent("/Users/nanya/Desktop/fileFrom.txt","/Users/nanya/Desktop/fileTo.txt");
        Solution.transferSentences("/Users/nanya/Desktop/fileFrom.txt", "/Users/nanya/Desktop/fileTo.txt", word);
        //Solution.copyFileContentApacheIO("/Users/nanya/Desktop/fileFrom.txt","/Users/nanya/Desktop/fileTo.txt");
        //Solution.copyFileContent("/Users/nanya/Desktop/fileFrom.txt","/Users/nanya/Desktop/fileTo1.txt");


    }
}
