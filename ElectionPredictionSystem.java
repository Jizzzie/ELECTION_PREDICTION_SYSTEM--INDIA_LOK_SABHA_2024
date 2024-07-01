import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class ElectionPredictionSystem extends JFrame {
    private String[][] candidatesData;
    private String[][] dropdownValues;
    private String[] constituencies; // Declare constituencies as a class-level variable
    private JPanel mainPanel;
    public ElectionPredictionSystem(String filePath) {


        setTitle("Election Prediction System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TextFileReader reader = new TextFileReader(filePath);
        candidatesData = reader.getWords();
        List<String[]> nda = new ArrayList<>();
        for (String[] row : candidatesData) {
            if ("BJP".equals(row[0])) { 
                nda.add(row);
            }
        }
        List<String[]> india = new ArrayList<>();
        for (String[] row : candidatesData) {
            if ("INC".equals(row[0]) || "DMK".equals(row[0])) { 
                india.add(row);
            }
        }
        List<String[]> cpm= new ArrayList<>();
        for (String[] row : candidatesData) {
            if ("CPM".equals(row[0])) { 
                cpm.add(row);
            }
        }
        List<String[]> INDEP= new ArrayList<>();
        for (String[] row : candidatesData) {
            if (!"INC".equals(row[0])&&!"BJP".equals(row[0])) { 
                INDEP.add(row);
            }
        }
        String[] firstRow = india.get(0);

        // Access the first element of the first array
        System.out.println(firstRow[0]);
        // Create a JPanel to hold all the content
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(55, 58, 59));
        headerPanel.setLayout(new BorderLayout());

        // Logo
        ImageIcon logoIcon = new ImageIcon("Designer-removebg-preview.png");
        JLabel logoLabel = new JLabel(logoIcon);
        headerPanel.add(logoLabel, BorderLayout.WEST);

        // Header Content Panel
        JPanel headerContentPanel = new JPanel();
        headerContentPanel.setBackground(new Color(55, 58, 59));
        headerContentPanel.setLayout(new BoxLayout(headerContentPanel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("<html><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='#FF9933'>ELECTION</font> <font color='white'>PREDICTION</font> <font color='#008000'>SYSTEM</font></html>");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 38));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerContentPanel.add(titleLabel);

        // Tagline Label
        JLabel taglineLabel = new JLabel("Making Informed Predictions");
        taglineLabel.setForeground(new Color(102, 102, 102));
        taglineLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        taglineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerContentPanel.add(taglineLabel);

        // Paragraph Label
        JLabel paragraphLabel = new JLabel("<html><br><br><br><br>India as we know has diverse features; be it religion, caste, sex, literacy rate, development rate, etc,. Considering all  <br> "+
        "such parameters this app intends to predict the Gen Election Results on a Constituency level and hence find the next PM. <br>The result doesnt guarantee the winning/losing " +
        "of a candidate as the model can't be trusted 100% and hence, results are <br> subjected to vary accordingly.<br> <br>CREDITS: Shreya Josh, Jizz Sabu<br>CONTACT: 272towin@eps.com<br>ADDRESS: 69 Downing Street, Dharavi, Bombay</html>");
      
        paragraphLabel.setForeground(Color.WHITE);
        paragraphLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerContentPanel.add(paragraphLabel);

        // Add Header Content Panel to Header Panel
        headerPanel.add(headerContentPanel, BorderLayout.CENTER);
        contentPanel.add(headerPanel, BorderLayout.NORTH);

        // Main Panel
        mainPanel = new JPanel(new GridLayout(1, 3));

        this.constituencies = new String[]{"VARANASI", "BALURGHAT", "MALAPURAM", "BENGALURU CENTRAL", "KOTTAYAM"};
        for (int i = 0; i < constituencies.length; i++) {
            JPanel constituencyPanel = new JPanel();
            // constituencyPanel.setForeground(Color.WHITE);
            constituencyPanel.setBackground(new Color(55, 58, 59));
            constituencyPanel.setLayout(new BoxLayout(constituencyPanel, BoxLayout.Y_AXIS));
            constituencyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border
        
            JLabel constituencyLabel = new JLabel(constituencies[i]);
            constituencyLabel.setForeground(Color.WHITE);
            constituencyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            constituencyPanel.add(constituencyLabel);
     
            JComboBox<String> bjpDropdown = new JComboBox<>();
            bjpDropdown.addItem("BJP - NONE");
            for (String[] row : nda) {
                if (row[1].equals(constituencies[i])) {
                    bjpDropdown.addItem("BJP - "+row[2]);
                }

            }
            constituencyPanel.add(bjpDropdown);
        
            // Create dropdown menu for INC
            JComboBox<String> incDropdown = new JComboBox<>();
            incDropdown.addItem("INC - NONE");
            for (String[] row : india) {
                if (row[1].equals(constituencies[i])) {
                    incDropdown.addItem("INC - "+row[2]);
                }
            }
            constituencyPanel.add(incDropdown);
        
            // Create dropdown menu for Other/Independent
            for (int j = 0; j < 2; j++) {
                JComboBox<String> otherDropdown = new JComboBox<>();
                otherDropdown.addItem("OTHER - NONE");
                for (String[] row : INDEP) {
                    if (row[1].equals(constituencies[i])) {
                        otherDropdown.addItem("OTHER - "+row[2]);
                    }
                }
                constituencyPanel.add(otherDropdown);
            }
    
        
            mainPanel.add(constituencyPanel);
        }
        dropdownValues = new String[constituencies.length][4]; 
        
        // Add Main Panel to Content Panel
        contentPanel.add(mainPanel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(55, 58, 59));
        JButton addButton = new JButton("   ADD CANDIDATE  ");
        addButton.setBackground(new Color(255, 64, 129));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a new dialog to get input from the user
                JFrame addCandidateFrame = new JFrame("Add Candidate");
                addCandidateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addCandidateFrame.setSize(400, 300);

                JPanel inputPanel = new JPanel(new GridLayout(9, 2));
                JTextField nameField = new JTextField();
                JComboBox<String> constituencyComboBox = new JComboBox<>(new String[]{"VARANASI", "BALURGHAT", "MALAPURAM", "BENGALURU CENTRAL", "KOTTAYAM"});
                JTextField partyField = new JTextField();
                JComboBox<String> casteComboBox = new JComboBox<>(new String[]{"GENERAL", "OBC", "SC", "ST"});
                JComboBox<String> religionComboBox = new JComboBox<>(new String[]{"HINDU", "MUSLIM", "CHRISTIAN", "OTHERS"});
                JComboBox<String> sexComboBox = new JComboBox<>(new String[]{"MALE", "FEMALE"});
                JTextField voterTurnoutField = new JTextField();
                JCheckBox sittingPartyCheckBox = new JCheckBox("Sitting Party");
                JCheckBox sittingCandidateCheckBox = new JCheckBox("Sitting Candidate");

                inputPanel.add(new JLabel("Name:"));
                inputPanel.add(nameField);
                inputPanel.add(new JLabel(""));
                inputPanel.add(new JLabel("Constituency:"));
                inputPanel.add(constituencyComboBox);
                inputPanel.add(new JLabel(""));
                inputPanel.add(new JLabel("Party:"));
                inputPanel.add(partyField);
                inputPanel.add(new JLabel(""));
                inputPanel.add(new JLabel("Caste:"));
                inputPanel.add(casteComboBox);
                inputPanel.add(new JLabel(""));
                inputPanel.add(new JLabel("Religion:"));
                inputPanel.add(religionComboBox);
                inputPanel.add(new JLabel(""));
                inputPanel.add(new JLabel("Sex:"));
                inputPanel.add(sexComboBox);
                inputPanel.add(new JLabel(""));
                inputPanel.add(new JLabel("Expected Voter Turnout:"));
                inputPanel.add(voterTurnoutField);
                inputPanel.add(new JLabel(""));
                inputPanel.add(sittingPartyCheckBox);
                inputPanel.add(new JLabel(""));
                inputPanel.add(new JLabel(""));
                inputPanel.add(sittingCandidateCheckBox);
                inputPanel.add(new JLabel(""));
                inputPanel.add(new JLabel(""));

                JButton addButton = new JButton("Update");
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get input values
                        String name = nameField.getText();
                        String constituency = (String) constituencyComboBox.getSelectedItem();
                        String party = partyField.getText();
                        String voterTurnout = voterTurnoutField.getText();
                        boolean isSittingParty = sittingPartyCheckBox.isSelected();
                        boolean isSittingCandidate = sittingCandidateCheckBox.isSelected();
                        String caste = (String) casteComboBox.getSelectedItem();
                        String religion = (String) religionComboBox.getSelectedItem();
                        String sex = (String) sexComboBox.getSelectedItem();

                        // Convert boolean values to integers
                        String sittingPartyValue = isSittingParty ? "1" : "0";
                        String sittingCandidateValue = isSittingCandidate ? "1" : "0";
                        data.main(new String[]{name, constituency, party, voterTurnout, sittingPartyValue, sittingCandidateValue, caste, religion, sex});
                        addCandidateFrame.dispose();
                    }
                });

                addCandidateFrame.add(inputPanel, BorderLayout.CENTER);
                addCandidateFrame.add(addButton, BorderLayout.SOUTH);
                addCandidateFrame.setVisible(true);
            }
        });

        JButton predictButton = new JButton("PREDICT THE FUTURE");
        predictButton.setBackground(new Color(76, 175, 80));
        predictButton.setForeground(Color.WHITE);
        predictButton.setFocusPainted(false);
        predictButton.setFont(new Font("Arial", Font.PLAIN, 16));
        predictButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                performPrediction();
            }
        });
        buttonPanel.add(addButton);
        buttonPanel.add(predictButton);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Create a JScrollPane 
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        add(scrollPane);
        pack();
        setLocationRelativeTo(null);
    }

    private void performPrediction() {

        if (mainPanel == null) {
            mainPanel = (JPanel) ((JScrollPane) getContentPane().getComponent(0)).getViewport().getComponent(0);
        }

        for (int i = 0; i < constituencies.length; i++) {
            // Get the selected values from the dropdowns
            String bjpSelected = (String) ((JComboBox) ((JPanel) mainPanel.getComponent(i)).getComponent(1)).getSelectedItem();
            String incSelected = (String) ((JComboBox) ((JPanel) mainPanel.getComponent(i)).getComponent(2)).getSelectedItem();
            String otherSelected1 = (String) ((JComboBox) ((JPanel) mainPanel.getComponent(i)).getComponent(3)).getSelectedItem();
            String otherSelected2 = (String) ((JComboBox) ((JPanel) mainPanel.getComponent(i)).getComponent(4)).getSelectedItem();

            dropdownValues[i][0] = bjpSelected;
            dropdownValues[i][1] = incSelected;
            dropdownValues[i][2] = otherSelected1;
            dropdownValues[i][3] = otherSelected2;
        }
        // for (int i = 0; i < dropdownValues.length; i++) {
        //     for (int j = 0; j < dropdownValues[i].length; j++) {
        //         System.out.print(dropdownValues[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("\nWe are done here\n");


        List<String[]> matchingCandidates = new ArrayList<>();
        String word;
        for (String[] row : candidatesData) {
            String party = row[0];
            // String constituency = row[1];
            String candidate = row[2];
            // String voteShare = row[3];
            for (String[] selectedValues : dropdownValues) {
                for(int j=0;j<4;++j){
                    if(!(party.equals("INC")||party.equals("BJP"))){
                        party="OTHER";
                    }
                    word = party + " - " + candidate;
                    if (word.equals(selectedValues[j])) {
                        matchingCandidates.add(row);
                        break; 
                    }
                }
            }
        }
        // for (String[] candidateData : matchingCandidates) {
        //     for (String value : candidateData) {
        //         System.out.print(value + " ");
        //     }
        //     System.out.println(); 
        // }
        
        ArrayList<Double> intList = new ArrayList<>();
        int[] t = new int[5];
        int iter=0;
        String[][] candidateArray = matchingCandidates.toArray(new String[matchingCandidates.size()][]);
        // for (int i = 0; i < candidateArray.length; i++) {
        //     for (int j = 0; j < candidateArray[i].length; j++) {
        //         System.out.print(candidateArray[i][j] + " ");
        //     }
        //     System.out.println();
        // }
//checkpoint
        String[] incl={"VARANASI","BALURGHAT","MALAPURAM","BENGALURU CENTRAL","KOTTAYAM"};
        String[] newcandidateArray = new String[candidateArray.length];
        for(String b: incl){
            for(int j = 0;j<candidateArray.length;++j){
                if(candidateArray[j][1].equals(b)){
                    intList.add(Double.parseDouble(candidateArray[j][3]));
                }
            }
            
            // System.out.print(b+"\n");
            // for (Double value : intList) {
            //     System.out.println(value+"\n");
            // }
            Double sum = 0.0;
            for (Double num : intList) {
                // System.out.println("\nDone-------\n");
                sum += num;
            }
            
            // System.out.print(sum);
            if(sum==0.0){
                t[iter]=1;
                // System.out.print("no sum");
            }
            else{
                Double x= 100/sum;
                // System.out.print("sum");
                for(int j = 0;j<candidateArray.length;++j){
                    if(candidateArray[j][1].equals(b)){
                        Double z=Double.parseDouble(candidateArray[j][3])*x;
                        DecimalFormat df = new DecimalFormat("#.##");
                        z = Double.valueOf(df.format(z));
                        newcandidateArray[j]=String.valueOf(z);
                    }
                }
            }
            intList.clear();
            iter++;
        }
//checkpoint

        int nda=0;
        int india=0;
        iter=0;
        StringBuilder message = new StringBuilder("RESULTS\n\n");
        
        for(String b: incl){
            message.append(b).append("\n");
            Double max=0.0;
            if(t[iter]==0){
                // message.append("hey you");

                for(int j = 0;j<candidateArray.length;++j){
                    if(candidateArray[j][1].equals(b)){
                        message.append(candidateArray[j][0]).append(" (").append(candidateArray[j][2]).append(") secured ").append(newcandidateArray[j]).append("% votes\n");
                        if(Double.parseDouble(newcandidateArray[j])>max){
                            max=Double.parseDouble(newcandidateArray[j]);
                        }
                    }
                // message.append("\n");
                }
                // System.out.print(max);
                for(int j = 0;j<candidateArray.length;++j){
                    if(String.valueOf(max).equals(newcandidateArray[j]) && b.equals(candidateArray[j][1])){
                        message.append("Winner :").append(candidateArray[j][0]).append("\n");
                        if(candidateArray[j][0].equals("BJP")||candidateArray[j][0].equals("SP")){
                            nda=nda+1;
                        }
                        else
                            india=india+1;
                        // max=0.0;
                    }
                }
                //         System.out.print(iter);
                //         System.out.print("\t");
                //         System.out.print(t[iter]);
                //         System.out.print("\n");
            }
            else{
                message.append("No Input\n");
                // message.append("hey me");

            }
            iter++;
        }
        String winner;
        if(nda<india)
            winner="INDIA";
        else if(nda>india)
            winner = "NDA";
        else 
            winner = "No Clear Winner";
        message.append("\nOVERALL WINNER: ").append(winner);
        JOptionPane.showMessageDialog(this, message.toString(), "Election Prediction System", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ElectionPredictionSystem("C:/Users/jissr/Desktop/PROJECTS/JAVA_SWING/SWING/DATA_IMPORT/Permanenet.txt").setVisible(true);
            }
        });
    }
}