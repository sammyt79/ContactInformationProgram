
/**
 * Contact Information Program Samuel Tollefson PRG/421 February 9, 2015 Roland
 * Morales
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * Part1 creates a GUI that prompts the user for contact name, age,
 * email, and cell.
 */
public class Part1 extends JFrame {

    // The following variables will reference the
    // labels.
    private static JLabel messageLabelFirst; // Text field for first name.
    private static JLabel messageLabelLast; // Text field for last name.
    private static JLabel messageLabelAge; // Text field for first name.
    private static JLabel messageLabelEmail; // Text field for last name.
    private static JLabel messageLabelCell; // Text field for first name.

    // The following variables will reference the
    // text fields.
    private static JTextField firstTextField; // Text field for first name.
    private static JTextField lastTextField; // Text field for last name.
    private static JTextField ageTextField; // Text field for first name.
    private static JTextField emailTextField; // Text field for last name.
    private static JTextField cellTextField; // Text field for first name.

    // The following variables will reference objects
    // needed to add the Enter and Exit buttons.
    private static JButton enterButton; // To calculate total compensation
    private static JButton exitButton; // To exit the application

    // The following variable will reference an object
    // needed to open a file.
    PrintWriter outputFile;

    /**
     * Constructor
     */
    public Part1() throws FileNotFoundException {

        // Display a title.
        super("Contact Information Program");

        // Creates a text file named ContactData.
        this.outputFile = new PrintWriter("../../ContactData.txt");

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager for
        // the content pane.
        setLayout(new GridLayout(6, 1));

        // Call the buildButtonPanel method to
        // create the button panel.
        buildPanel();

        // Pack the contents of the window and display it.
        pack();
        setVisible(true);
    }

    private void buildPanel() {

        // Create labels for first and last name, age, email, and cell.
        messageLabelFirst = new JLabel("First Name");
        messageLabelLast = new JLabel("Last Name");
        messageLabelAge = new JLabel("Age");
        messageLabelEmail = new JLabel("Email");
        messageLabelCell = new JLabel("Cell Phone");

        // Create text fields for first and last name, age, email, and cell.
        firstTextField = new JTextField(10);
        lastTextField = new JTextField(10);
        ageTextField = new JTextField(10);
        emailTextField = new JTextField(10);
        cellTextField = new JTextField(10);

        enterButton = new JButton("Enter Data"); // To enter data to text file.
        exitButton = new JButton("Exit"); // Exits the application.

        // Create panels for first and last name, age, email, and cell.
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        // Position the panels.
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Add the labels to the panels.
        panel1.add(messageLabelFirst);
        panel2.add(messageLabelLast);
        panel3.add(messageLabelAge);
        panel4.add(messageLabelEmail);
        panel5.add(messageLabelCell);

        // Add the text fields to the panels.
        panel1.add(firstTextField);
        panel2.add(lastTextField);
        panel3.add(ageTextField);
        panel4.add(emailTextField);
        panel5.add(cellTextField);

        // Create and position the button panel.
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Add buttons to the button panel.
        buttonPanel.add(enterButton);
        buttonPanel.add(exitButton);

        // Register the action listeners.
        enterButton.addActionListener(new EnterButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        // Add the panels.
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(buttonPanel);
    }

    /**
     * Private inner class that handles the event when the user clicks the Enter
     * button.
     */
    private class EnterButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Write data to the ContactData file.
            outputFile.println(firstTextField.getText()
                    + " "
                    + lastTextField.getText());
            outputFile.println(ageTextField.getText());
            outputFile.println(emailTextField.getText());
            outputFile.println(cellTextField.getText());

            // Reset the text fields.
            firstTextField.setText(null);
            lastTextField.setText(null);
            ageTextField.setText(null);
            emailTextField.setText(null);
            cellTextField.setText(null);
        }
    }

    /**
     * Private inner class that handles the event when the user clicks the Exit
     * button.
     */
    private class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Close the ContactData file.
            outputFile.close();

            // Exit the application.
            System.exit(0);
        }
    }

    // Main class runs the program.
    public static void main(String[] args) throws IOException {

        Part1 part1 = new Part1();
    }
}
