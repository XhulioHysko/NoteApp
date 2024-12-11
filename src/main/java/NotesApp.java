import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class NotesApp  extends JFrame implements ActionListener {

    private final JTextArea noteText;
    private final JTextArea studentText;
    private final JButton addStudent;
    private final JButton registerTheEmployees;
    private final JButton saveBtn;
    private final JButton viewAllBtn;
    private final JFrame frame;

    //constructor
    public NotesApp() {
        frame = new JFrame();
        frame.setBounds(100, 100, 630, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout()); // Use BorderLayout

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 1)); // Use GridLayout for the input panels
        inputPanel.setPreferredSize(new Dimension(400, 150)); // Set preferred size for inputPanel

        JLabel noteLabel = new JLabel("Note:");
        noteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(noteLabel);

        noteText = new JTextArea();
        inputPanel.add(noteText);

        studentText = new JTextArea();
        inputPanel.add(studentText);

        frame.getContentPane().add(inputPanel, BorderLayout.CENTER); // Add inputPanel to the CENTER

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Use FlowLayout for buttons.

        saveBtn = new JButton("Save");
        saveBtn.addActionListener(this);
        buttonPanel.add(saveBtn);

        addStudent = new JButton("Register the Students ");
        addStudent.addActionListener(this);
        buttonPanel.add(addStudent);

        registerTheEmployees = new JButton("Register The Employees");
        registerTheEmployees.addActionListener(this);
        buttonPanel.add(registerTheEmployees);

        viewAllBtn = new JButton("View All");
        viewAllBtn.addActionListener(this);
        buttonPanel.add(viewAllBtn);

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH); // Add buttonPanel to the SOUTH

        frame.setResizable(false);
        frame.setTitle("Add new note");
        frame.getContentPane().setBackground(new Color(0, 153, 204));
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        TestApp testApp = new TestApp();

        String newNote = noteText.getText();

        /*
         * Save button
         */
        if (event.getSource() == saveBtn) {
            if (newNote.isBlank()) {
                JOptionPane.showMessageDialog(new JFrame(), "You can't save an empty note!",
                        "Warning", JOptionPane.ERROR_MESSAGE);
                noteText.setText("");
                return;
            }
            newNote = newNote.replaceAll("'", "''");  //use of regex
            String insertQuery = "insert into notes (name) values(' " + newNote + " ')";  //text manipulation
            try {
                testApp.executeQuery(insertQuery, "insert");
                noteText.setText("");
                JOptionPane.showMessageDialog(frame, "Note saved.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        String newStudent = newNote;

        // Reminder button
        if (event.getSource() == addStudent) {
            if (newStudent.isBlank()) {
                JOptionPane.showMessageDialog(new JFrame(), "you can't save an empty Student!",
                        "Warning", JOptionPane.ERROR_MESSAGE);
                noteText.setText("");
                return;
            }
            newStudent = newStudent.replaceAll("'", "''"); // Use of regex
            String insertReminderQuery = "INSERT INTO sda_notes (name) VALUES ('" + newStudent + "')"; // Text manipulation
            try {
                testApp.executeQuery(insertReminderQuery, "insert");
                noteText.setText("");
                JOptionPane.showMessageDialog(frame, " Student saved.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        String newEmployee = newNote;

        // Register button
        if (event.getSource() == registerTheEmployees) {
            if (newEmployee.isBlank()) {
                JOptionPane.showMessageDialog(new JFrame(), "You can't save without any employee!",
                        "Warning", JOptionPane.ERROR_MESSAGE);
                noteText.setText("");
                return;
            }
            newEmployee = newEmployee.replaceAll("'", "''"); // Use of regex
            String insertRegisterQuery = "INSERT INTO laconics_notes (name) VALUES ('" + newEmployee + "')";
            try {
                testApp.executeQuery(insertRegisterQuery, "insert");
                noteText.setText("");
                JOptionPane.showMessageDialog(frame, "Employee saved.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        /*
         * View all
         */
        if (event.getSource() == viewAllBtn) {
            new MobileAppGUI();
        }
    }
}