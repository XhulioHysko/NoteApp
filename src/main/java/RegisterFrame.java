import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterFrame extends JFrame implements ActionListener {


    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel fullName;
    private JTextField fullNameText;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton refresh;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private JLabel password;
    private JPasswordField passwordText;
    private JLabel Email;
    private JTextArea emailText;
    private JButton loginButton; // New login button


    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan","feb","Mar","Apr",
            "May", "Jun", "July", "Aug",
            "Sep", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1982", "1983","1984", "1985",
            "1986", "1987","1988", "1989",
            "1990", "1991","1992", "1993",
            "1994","1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020","2021","2022",
            "2023", "2024"};

    // constructor, to initialize the components
    // with default values.

    public RegisterFrame(){
        setTitle("Account Registration");
        setBounds(300, 90, 900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Account Registration");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        fullName = new JLabel("FullName");
        fullName.setFont(new Font("Arial", Font.PLAIN, 20));
        fullName.setSize(100, 20);
        fullName.setLocation(100, 100);
        c.add(fullName);

        fullNameText = new JTextField();
        fullNameText.setFont(new Font("Arial", Font.PLAIN, 15));
        fullNameText.setSize(190, 20);
        fullNameText.setLocation(200, 100);
        c.add(fullNameText);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(100, 150);
        c.add(password);

        passwordText = new JPasswordField();
        passwordText.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordText.setSize(190, 20);
        passwordText.setLocation(200, 150);
        c.add(passwordText);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 200);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("Birthday");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 250);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 11));
        date.setSize(60, 20);
        date.setLocation(200, 250);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 11));
        month.setSize(75, 20);
        month.setLocation(250, 250);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 11));
        year.setSize(77, 20);
        year.setLocation(320, 250);
        c.add(year);

        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 300);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(190, 30);
        tadd.setLocation(200, 300);
        tadd.setLineWrap(true);
        c.add(tadd);

        Email = new JLabel("Email");
        Email.setFont(new Font("Arial", Font.PLAIN, 20));
        Email.setSize(100, 20);
        Email.setLocation(100, 350);
        c.add(Email);

        emailText = new JTextArea();
        emailText.setFont(new Font("Arial", Font.PLAIN, 15));
        emailText.setSize(190, 20);
        emailText.setLocation(200, 350);
        emailText.setLineWrap(true);
        c.add(emailText);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        sub = new JButton("SIGNUP");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        refresh = new JButton("Refresh");
        refresh.setFont(new Font("Arial", Font.PLAIN, 15));
        refresh.setSize(100, 20);
        refresh.setLocation(270, 450);
        refresh.addActionListener(this);
        c.add(refresh);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);


        loginButton = new JButton("Return to Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
        loginButton.setSize(150, 30);
        loginButton.setLocation(150, 540);
        loginButton.addActionListener(this); // Add action listener
        c.add(loginButton);


        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly


    @Override
    public void actionPerformed(ActionEvent e) {


        TestApp testApp = new TestApp();

        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String fullName = fullNameText.getText();
                String password = passwordText.getText();
                String gender = male.isSelected() ? "Male" : "Female";
                String dateOfBirth = (String) date.getSelectedItem() + "/" + (String) month.getSelectedItem()
                        + "/" + (String) year.getSelectedItem();
                String address = tadd.getText();
                String email = emailText.getText();

                // Check if any of the fields are empty
                if (fullName.isEmpty() || password.isEmpty() || gender.isEmpty() || dateOfBirth.isEmpty()
                        || address.isEmpty() || email.isEmpty()) {
                    // Display error message for invalid sign-up
                    JOptionPane.showMessageDialog(this,
                            "Invalid sign-up. All fields are required.");
                    return; // Exit the method without executing further code
                }

                // Signup was successful
                // Display success message
                JOptionPane.showMessageDialog(this, "Registration Successful!");

                testApp.SignUp(fullName, password, gender, dateOfBirth, address, email);

                String data = "full_name : " + fullName + "\n" + "password : " + password + "\n";
                String data1 = "gender : " + gender + "\n";
                String data2 = "date_of_birth : " + dateOfBirth + "\n";
                String data3 = "address : " + address + "\n";
                String data4 = "email : " + email + "\n";
                tout.setText(data + data1 + data2 + data3+data4);
                tout.setEditable(false);
                res.setText("Registration Successfully..");
                dispose(); // Close the Register Frame

            } else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the terms & conditions..");
            }
        } else if (e.getSource() == refresh) {
            String def = "";
            fullNameText.setText(def);
            passwordText.setText(def);
            emailText.setText(def);
            tadd.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            resadd.setText(def);
        }else if (e.getSource() == loginButton) { // Handle login button click

            this.dispose(); // Close the register frame

            // Show the login frame
            LoginFrame loginFrame = new LoginFrame();
        }
    }
}
