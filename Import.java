import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Import {
    public static void main(String[] args) {
        String csvFile = "C:/Users/JUBY SABU/OneDrive/Desktop/JAVA_SWING/SWING/DATA_IMPORT/trial.csv"; // Replace with the path to your CSV file
        String outputFile = "C:/Users/JUBY SABU/OneDrive/Desktop/JAVA_SWING/SWING/DATA_IMPORT/Permanenet.txt"; // Replace with the path to your output file
        String line = "";
        String csvSplitBy = ","; // Assuming CSV delimiter is a comma
        String p, c, n,v;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) { // Append mode enabled
            while ((line = br.readLine()) != null) {
                // Split the line into fields using the delimiter
                String[] fields = line.split(csvSplitBy);
                p = fields[0];
                c = fields[1];
                n = fields[2];
                v = fields[3];
                bw.write(p);
                bw.write("   ");
                bw.write(c);
                bw.write("   ");
                bw.write(n);
                bw.write("   ");
                bw.write(v +"\n");
                // System.out.println(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


