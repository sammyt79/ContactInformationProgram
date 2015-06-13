
/**
 * Contact Information Program Samuel Tollefson PRG/421 February 9, 2015 Roland
 * Morales
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.io.*;

/**
 * Part2 reads the data from the text file created by user input from the Part1
 * program and displays it in a table.
 */
public class Part2 extends JFrame {

    // The following variables will reference the
    // buttons.
    private JButton save;
    private JButton exit;

    // The following variable will reference the
    // table model.
    private DefaultTableModel tableModel;

    // Variable to increment donor count,
    int donarCount = 0;

    // Scanner reference variable.
    private Scanner input;

    /**
     * Constructor
     */
    public Part2() {

        // Display a title.
        super("Contact Info Read");

        // Specify an action for the close button.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Disable resizing.
        setResizable(false);

        // Create a panel for the buttons.
        JPanel buttonPanel = new JPanel();

        // Create the table.
        JTable saveTable = new JTable();

        // Create the save and exit buttons.
        save = new JButton("Display Contact Info");
        exit = new JButton("Exit");

        // Register the action listeners.
        save.addActionListener(new SaveButtonListener());
        exit.addActionListener(new ExitButtonListener());

        // Add buttons to panel.
        buttonPanel.add(save);
        buttonPanel.add(exit);

        // Returns the contentPane object for this frame.
        Container tableButtonContainer = getContentPane();

        // Set layouts.
        tableButtonContainer.setLayout(new BorderLayout());
        tableButtonContainer.setLayout(new BoxLayout(tableButtonContainer,
                BoxLayout.Y_AXIS));

        // Constructs a DefaultTableModel with rowCount and columnCount.
        tableModel = new DefaultTableModel(0, 5);

        // Create column identifiers.
        String col[] = {"Contact Name", "Age", "Email", "Cell Number"};
        tableModel.setColumnIdentifiers(col);
        saveTable.setModel(tableModel);

        // Create and set a scroll pane.
        JScrollPane tableScroller = new JScrollPane(saveTable,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        tableScroller.setViewportView(saveTable);
        tableButtonContainer.add(saveTable, BorderLayout.CENTER);

        tableButtonContainer.add(buttonPanel, BorderLayout.SOUTH);
        tableButtonContainer.add(tableScroller);
        tableScroller.setViewportView(saveTable);

        // Pack the contents of the window and display it.
        pack();
        setVisible(true);

    }

    /**
     * Private inner class that handles the event when the user clicks the
     * Display Contact Info button.
     */
    private class SaveButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Test for exceptions.
            try {
                
                // Create file scanner.
                input = new Scanner(new File("../../ContactData.txt"));

                // Display all available data.
                while (input.hasNext()) {
                    tableModel.setRowCount(donarCount + 1);
                    tableModel.setValueAt(input.nextLine(), donarCount, 0);
                    tableModel.setValueAt(input.nextLine(), donarCount, 1);
                    tableModel.setValueAt(input.nextLine(), donarCount, 2);
                    tableModel.setValueAt(input.nextLine(), donarCount, 3);

                    // Increment donorCount variable
                    donarCount++;
                }
                
            // Catch missing file exception.
            } catch (FileNotFoundException ex) {
                
                // Display error message.
                JOptionPane.showMessageDialog(null,
                        "File not found",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                
                // Exit the application.
                System.exit(0);
            } finally {
                
                // Close the file. 
                input.close();
            }
        }
    }

    /**
     * Private inner class that handles the event when the user clicks the Exit
     * button.
     */
    private class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Exit the application.
            System.exit(0);
        }
    }

    //main class
    public static void main(String args[]) {
        Part2 part2 = new Part2();
    }
}
