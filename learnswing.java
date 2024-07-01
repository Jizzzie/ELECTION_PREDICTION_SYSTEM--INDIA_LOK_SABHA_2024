import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class learnswing extends JFrame {
    private String selectedValue; // Variable to store the selected value

    public learnswing() {
        setTitle("Dropdown Menu Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create a label
        JLabel label = new JLabel("Select an option:");
        panel.add(label);

        // Create a dropdown menu (JComboBox)
        String[] options = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        panel.add(dropdown);

        // Add an ActionListener to the dropdown menu
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected value from the dropdown menu
                selectedValue = (String) dropdown.getSelectedItem();
                // Print the selected value (for demonstration purposes)
                System.out.println("Selected value: " + selectedValue);
            }
        });

        // Add the panel to the frame
        add(panel);

        // Set the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new learnswing();
            }
        });
    }
}
