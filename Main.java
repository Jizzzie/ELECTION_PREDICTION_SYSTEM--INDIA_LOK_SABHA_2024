import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Define the candidatesData array
        String[][] candidatesData = {
                {"BJP", "VARANASI", "Narendra Modi", "46.05"},
                {"INC", "VARANASI", "Shreya Ghosh", "50.09"},
                {"CPM", "MALAPURAM", "Mohammed", "23.97"},
                {"INC", "MALAPURAM", "Ashil", "40.97"},
                {"CPM", "BALURGHAT", "Swarnashish", "45.90"},
                {"BJP", "BALURGHAT", "Asmita", "20.99"},
                {"BJP", "COIMBATORE", "Bharanikarthick", "40.33"},
                {"INC", "COIMBATORE", "Dhileep", "34.67"},
                {"INC", "RAEBARELI", "Priyanka Gandhi", "50.08"},
                {"BJP", "RAEBARELI", "Aryan Gupta", "17.56"},
                {"BJP", "VARANASI", "Raghuram Ranjan", "40.09"}
        };
        List<String[]> nda = new ArrayList<>();
        for (String[] row : candidatesData) {
            if ("BJP".equals(row[0])) { 
                nda.add(row);
            }
        }
        List<String[]> india = new ArrayList<>();
        for (String[] row : candidatesData) {
            if ("INC".equals(row[0]) || "CPM".equals(row[0]) || "DMK".equals(row[0])) { 
                india.add(row);
            }
        }
        for (String[] row : india) {
            for (String data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
        String[] firstRow = india.get(0);

        // Access the first element of the first array
        String firstElement = firstRow[2];

        // Print the first element
        System.out.println("First element: " + firstElement);

    }
}
