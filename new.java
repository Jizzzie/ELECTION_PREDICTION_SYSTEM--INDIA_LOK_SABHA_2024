import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ElectionPredictionSystem extends JFrame {
    private String[][] candidatesData;

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
        JLabel paragraphLabel = new JLabel("<html><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;India as we know has diverse features; be it religion, caste, sex, literacy rate, development rate, etc,. Considering all  <br> "+
        "such parameters this app intends to predict the Gen Election Results on a Constituency level and hence find the next PM. <br>The result doesnt guarantee the winning/losing " +
        "of a candidate as the model can't be trusted 100% and hence, results are subjected<br>to vary accordingly.<br> <br>CREDITS: Shreya Ghosh, Jiss Sabu Varghese<br>CONTACT: 272towin.eps.com<br>ADDRESS: 456 Street, Dharavi, Bombay</html>");
      
        paragraphLabel.setForeground(Color.WHITE);
        paragraphLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerContentPanel.add(paragraphLabel);

        // Add Header Content Panel to Header Panel
        headerPanel.add(headerContentPanel, BorderLayout.CENTER);
        contentPanel.add(headerPanel, BorderLayout.NORTH);

        // Main Panel
        JPanel mainPanel = new JPanel(new GridLayout(1, 3));

        // Constituencies and Candidates
        String[] constituencies = {"VARANASI", "BALURGHAT", "MALAPURAM", "BENGALURU CENTRAL", "KOTTAYAM"};
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
                        // Process the collected values (You can write them to file, print to console, etc.)
                        System.out.println("Name: " + name);
                        System.out.println("Constituency: " + constituency);
                        System.out.println("Party: " + party);
                        System.out.println("Expected Voter Turnout: " + voterTurnout);
                        System.out.println("Is Sitting Party: " + sittingPartyValue);
                        System.out.println("Is Sitting Candidate: " + sittingCandidateValue);
                        System.out.println("Caste: " + caste);
                        System.out.println("Religion: " + religion);
                        System.out.println("Sex: " + sex);

                        // Close the add candidate frame
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
                
                performPrediction(candidatesData);
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(predictButton);


        // Add button panel to content panel
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Create a JScrollPane and add the content panel to it
        JScrollPane scrollPane = new JScrollPane(contentPanel);

        // Add JScrollPane to the frame
        add(scrollPane);

        pack();
        setLocationRelativeTo(null);
    }
    private void performPrediction(String[][] candidatesData) {
        // Create a StringBuilder to store the prediction results
        StringBuilder predictionResult = new StringBuilder();
    
        // Iterate through constituencies
        String[] constituencies = {"VARANASI", "BALURGHAT", "MALAPURAM", "BENGALURU CENTRAL", "KOTTAYAM"};
        for (String constituency : constituencies) {
            // Initialize variables to store vote shares for each party
            double bjpShare = 0.0;
            double incShare = 0.0;
            double otherShare = 0.0;
    
            // Iterate through candidatesData to get vote shares for each party in the current constituency
            for (String[] candidate : candidatesData) {
                if (constituency.equals(candidate[1])) {
                    if ("BJP".equals(candidate[0])) {
                        bjpShare = Double.parseDouble(candidate[3]);
                    } else if ("INC".equals(candidate[0]) || "DMK".equals(candidate[0])) {
                        incShare = Double.parseDouble(candidate[3]);
                    } else {
                        otherShare = Double.parseDouble(candidate[3]);
                    }
                }
            }
    
            // Determine the winning party based on the highest vote share
            String winner;
            if (bjpShare > incShare && bjpShare > otherShare) {
                winner = "BJP";
            } else if (incShare > bjpShare && incShare > otherShare) {
                winner = "INC";
            } else {
                winner = "Other";
            }
    
            // Append the prediction result for the current constituency to the StringBuilder
            predictionResult.append("Constituency: ").append(constituency).append("\n");
            predictionResult.append("Winner: ").append(winner).append("\n\n");
        }
    
        // Display the prediction result in a pop-up box
        JOptionPane.showMessageDialog(this, predictionResult.toString(), "Election Prediction Result", JOptionPane.INFORMATION_MESSAGE);
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ElectionPredictionSystem("C:/Users/JUBY SABU/OneDrive/Desktop/JAVA_SWING/SWING/DATA_IMPORT/Permanenet.txt").setVisible(true);
            }
        });
    }
}

