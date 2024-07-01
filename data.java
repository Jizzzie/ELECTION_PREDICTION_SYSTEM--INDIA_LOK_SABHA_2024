import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class data {


    public static void main(String[] args) {
        if (args.length != 9) {
            System.err.println("Invalid number of arguments. Expected 9, received " + args.length);
            return;
        }

        String name = args[0];
        String constituency = args[1];
        String party = args[2];
        int voterTurnout = Integer.parseInt(args[3]);
        int sittingPartyValue = Integer.parseInt(args[4]);
        int sittingCandidateValue = Integer.parseInt(args[5]);
        String caste = args[6];
        String religion = args[7];
        String sex = args[8];

        int Partyvalue;
        switch (party.toUpperCase()) {
            case "BJP":
                Partyvalue = 2;
                break;
            case "INC":
                Partyvalue = 5;
                break;
            case "CPM":
                Partyvalue = 4;
                break;
            case "IUML":
                Partyvalue = 6;
                break;
            case "NOTA":
                Partyvalue = 8;
                break;
            case "BSP":
                Partyvalue = 3;
                break;
            case "AD":
                Partyvalue = 1;
                break;
            case "SP":
                Partyvalue = 9;
                break;
            case "AAP":
                Partyvalue = 0;
                break;
            case "TMC":
                Partyvalue = 10;
                break;
            case "JD":
                Partyvalue = 7;
                break;
            default:
                Partyvalue =1000; // Default value if party is not found
                break;
        }

        int valueCaste;
        switch (caste.toUpperCase()) {
            case "OBC":
                valueCaste = 1;
                break;
            case "GENERAL":
                valueCaste = 0;
                break;
            case "SC":
                valueCaste = 2;
                break;
            case "ST":
                valueCaste = 3;
                break;
            default:
                valueCaste = -1; // Default value if caste is not found
                break;
        }

        int valueReligion;
        switch (religion.toUpperCase()) {
            case "CHRISTIAN":
                valueReligion = 0;
                break;
            case "HINDU":
                valueReligion = 1;
                break;
            case "MUSLIM":
                valueReligion = 2;
                break;
            case "OTHERS":
                valueReligion = 3;
                break;
            default:
                valueReligion = -1; // Default value if religion is not found
                break;
        }

        int valueSex;
        switch (sex.toUpperCase()) {
            case "MALE":
                valueSex = 1;
                break;
            case "FEMALE":
                valueSex = 0;
                break;
            default:
                valueSex = -1; // Default value if sex is not found
                break;
        }

        int constituencyValue,bc,obc,gen,hindu,muslim,christian,other,lit;
        switch (constituency) {
            case "VARANASI":
                constituencyValue = 4;
                bc=14;
                obc=50;
                gen=36;
                hindu=80;
                christian=0;
                muslim=19;
                other=1;
                lit=75;
                break;
            case "BALURGHAT":
                constituencyValue = 0;
                bc=56;
                obc=14;
                gen=30;
                hindu=98;
                christian=0;
                muslim=1;
                other=1;
                lit=73;
                break;
            case "MALAPURAM":
                constituencyValue= 3;
                bc=9;
                obc=34;
                gen=57;
                hindu=30;
                christian=2;
                muslim=67;
                other=0;
                lit=88;
                break;
            case "KOTTAYAM":
                constituencyValue = 2;
                bc=7;
                obc=15;
                gen=78;
                hindu=49;
                christian=44;
                muslim=6;
                other=1;
                lit=98;
                break;
            case "BENGALURU CENTRAL":
                constituencyValue = 1;
                bc=14;
                obc=20;
                gen=66;
                hindu=78;
                christian=6;
                muslim=13;
                other=3;
                lit=87;
                break;
            default:
                constituencyValue = 100;
                bc=14;
                obc=50;
                gen=36;
                hindu=80;
                christian=0;
                muslim=19;
                other=1;
                lit=75;
                break;
        }

        ArrayList<Integer> dataset = new ArrayList<>();
        dataset.add(2024);
        dataset.add(constituencyValue);
        dataset.add(bc);
        dataset.add(obc);
        dataset.add(gen);
        dataset.add(hindu);
        dataset.add(muslim);
        dataset.add(christian);
        dataset.add(other);
        dataset.add(voterTurnout);
        dataset.add(lit);
        dataset.add(sittingPartyValue);
        dataset.add(sittingCandidateValue);
        dataset.add(Partyvalue);
        dataset.add(valueCaste);
        dataset.add(valueReligion);
        dataset.add(valueSex);
        ArrayList<String> dataset2 = new ArrayList<>();
        dataset2.add(party);
        dataset2.add(constituency);
        dataset2.add(name);
        // // File path where you want to save the dataset
        String filePath = "C:\\Users\\JUBY SABU\\OneDrive\\Desktop\\JAVA_SWING\\SWING\\DATA_EXPORT\\ToModel.xlsx";
        String filePath2 = "C:\\Users\\JUBY SABU\\OneDrive\\Desktop\\JAVA_SWING\\SWING\\DATA_EXPORT\\ToModel2.xlsx";
        try {
            FileWriter writer = new FileWriter(filePath);
            for (final Integer data : dataset) {
                writer.write(data + "\n");
            }
            writer.close();
            System.out.println("Dataset saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving dataset: " + e.getMessage());
        }
        try {
            FileWriter writer = new FileWriter(filePath2);
            for (final String data : dataset2) {
                writer.write(data + "\n");
            }
            writer.close();
            System.out.println("Dataset2 saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving dataset2: " + e.getMessage());
        }
    }
}