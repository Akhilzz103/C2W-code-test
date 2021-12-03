package myjava;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class FindReplace {
    static String getRepWord(String wr) {
        String replace_word = "";
        for (int i = 0; i < wr.length(); i++) {
            replace_word += '#';
        }
        return replace_word;
    }
    static String censor(String text,
            String word) {
        List<String> word_list = Arrays.asList(text.split("\\s+"));
        List<String> inputSplit = Arrays.asList(word.split("\\s+"));
        String result = "";
        do {
            if (word_list.contains(inputSplit.get(0)) && inputSplit.size()==Arrays.asList(word.split("\\s+")).size() ) {
                int startindex = word_list.indexOf(inputSplit.get(0));
                int j = startindex;
                for (int i = 0; i < inputSplit.size(); i++) {
                    word_list.set(j, getRepWord(word_list.get(j)));
                    j++;
                }
            }
            else{
                break;
            }
        } while (word_list.contains(inputSplit.get(0)));
        for (String i : word_list) {
            result += i + ' ';
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        String extract = "";
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the string to search");
        String cen = s.nextLine();
        int ch;
        FileReader fr = null;
        try {
            fr = new FileReader("output.txt");
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
        }
        while ((ch = fr.read()) != -1) {
            extract += (char) ch;
        }
        System.out.println("Before : "+extract);
        fr.close();
        System.out.println("After : "+censor(extract, cen));
    }
}
