import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class MobileAppGUI extends JFrame {
    TestApp testApp = new TestApp();
    String getNotesQuery = "select * from notes";
    String getSdaQuery = "select * from sda_notes";
    String getLaconicQuery = "select * from laconics_notes";
    String getUsersQuery = "select * from users_data";
    List<String> allNotes = null; //generic collection
    List<String> allSda = null; //generic collection
    List<String> allLaconics = null; //generic collection
    List<String> allUsersData = null; //generic collection
    final Object[][] rowData = {};
    final Object[] columnNotes = {"Notes"};
    final Object[] columnSda = {"Sda_otes"};
    final Object[] columnLaconics = {"Laconics_notes"};

    //constructor

    public MobileAppGUI() {



        try {
            allNotes = testApp.executeQuery(getNotesQuery, "select").get("notes");
            allSda = testApp.executeQuery(getSdaQuery, "select").get("sda_notes");
            allLaconics = testApp.executeQuery(getLaconicQuery, "select").get("laconics_notes");
            allUsersData = testApp.executeQuery(getUsersQuery, "select").get("users_data");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNotes);
        allNotes.forEach(note -> tableModel.addRow(new Object[]{note})); //lambda expression & generic method

        DefaultTableModel tableModel2 = new DefaultTableModel(rowData, columnSda);
        allSda.forEach(sda -> tableModel2.addRow(new Object[]{sda}));

        DefaultTableModel tableModel3 = new DefaultTableModel(rowData, columnLaconics);
        allLaconics.forEach(laconic -> tableModel3.addRow(new Object[]{laconic}));

        // Frame initialization
        JFrame frame = new JFrame("All Notes, Students, and Laconics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Initializing the JTable for notes:
        JTable table = new JTable(tableModel);
        table.setBounds(30, 40, 200, 300);
        JScrollPane scrollPane = new JScrollPane(table); // adding it to JScrollPane
        frame.add(scrollPane);

        // Frame Size
        frame.setSize(1000, 1000);

        // Frame Visible = true
        frame.setVisible(true);

        // Initializing the JTable for Student:
        JTable table1 = new JTable(tableModel2);
        table1.setBounds(300, 20, 200, 300);
        JScrollPane scrollPane1 = new JScrollPane(table1);
        frame.add(scrollPane1);

        // Initializing the JTable for laconics:
        JTable table2 = new JTable(tableModel3);
        table2.setBounds(300, 20, 200, 300);
        JScrollPane scrollPane3 = new JScrollPane(table2);
        frame.add(scrollPane3);

        //Create a JSplitPane for notes/Student
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, scrollPane1);
        splitPane.setDividerLocation(150);

        //Create a JSplitPane for notes/reminders and laconics
        JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane, scrollPane3);
        splitPane2.setDividerLocation(400);// Adjust divider location as needed

        // Frame initialization
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Adding splitPane to frame
        frame.add(splitPane2);

        // Setting frame size
        frame.setSize(1000, 500);
//        frame.setSize(500, 300);

        // Frame Visible = true
        frame.setVisible(true);
    }

}