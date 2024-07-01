import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
    private String[][] words;

    public TextFileReader(String filePath) {
        this.words = readTextFile(filePath);
    }

    private String[][] readTextFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String[] lines = sb.toString().split("\n");
        String[][] result = new String[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            result[i] = lines[i].split("   ");
        }
        return result;
    }

    public String[][] getWords() {
        return words;
    }

    public static void main(String[] args) {
        // Replace "permanent.txt" with the actual path to your text file
        TextFileReader reader = new TextFileReader("C:/Users/JUBY SABU/OneDrive/Desktop/JAVA_SWING/SWING/DATA_IMPORT/Permanenet.txt");
        String[][] wordsArray = reader.getWords();
        
        // Print the contents of the 2D array
        for (int i = 0; i < wordsArray.length; i++) {
            for (int j = 0; j < wordsArray[i].length; j++) {
                System.out.print(wordsArray[i][j] + " ");
            }
            System.out.println();
    
        }
        System.out.print(wordsArray[0][2] + " ");
    }
}


