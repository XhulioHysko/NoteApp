import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginFrame extends JFrame implements ActionListener {

    private JPasswordField password;
    private JTextField username;
    private JLabel label_password, label_username, message, title, registerTitle;
    private JButton btn, reset_btn, createAccount;
    private JCheckBox showPassword;
    //    private final JFrame frame;
    private TestApp testApp;


    public static void main(String[] args) {
        new LoginFrame();
    }

    public LoginFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle("LOGIN");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        testApp = new TestApp();
//
//        frame = new JFrame();
//        frame.setBounds(100, 100, 630, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().setLayout(null);

        title = new JLabel("Please enter your username and password to continue!");
        title.setBounds(230, 100, 555, 40);
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setForeground(Color.BLACK);

        registerTitle = new JLabel("Need an account? SIGN UP");
        registerTitle.setBounds(357, 414, 450, 40);
        registerTitle.setFont(new Font("Arial", Font.ITALIC, 15));
        registerTitle.setForeground(Color.BLACK);

        label_username = new JLabel("Username");
        label_username.setBounds(185, 200, 100, 40);
        label_username.setFont(new Font("Arial", Font.BOLD, 20));
        label_username.setForeground(Color.BLUE);

        label_password = new JLabel("Password");
        label_password.setBounds(185, 250, 100, 40);
        label_password.setFont(new Font("Arial", Font.BOLD, 20));
        label_password.setForeground(Color.BLUE);

        message = new JLabel();
        message.setBounds(300, 370, 300, 40);
        message.setFont(new Font("Arial", Font.BOLD, 20));
        message.setForeground(Color.BLUE);

        username = new JTextField();
        username.setBounds(300, 200, 300, 40);
        password = new JPasswordField();
        password.setBounds(300, 250, 300, 40);

        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(300, 288, 200, 40);
        showPassword.setFont(new Font("Arial", Font.BOLD, 14));
        showPassword.setForeground(Color.BLACK);
        showPassword.addActionListener(this);

        btn = new JButton("Sign In");
        btn.setBounds(300, 335, 100, 40);
        btn.setFont(new Font("Arial", Font.BOLD, 17));
        btn.setBackground(Color.BLUE);
        btn.setForeground(Color.BLACK);
//        frame.getContentPane().add(btn);
        btn.addActionListener(this);

        createAccount = new JButton("Create Account");
        createAccount.setBounds(313, 450, 280, 40);
        createAccount.addActionListener(this);
        createAccount.setFont(new Font("Arial", Font.BOLD, 17));
        createAccount.setBackground(Color.BLUE);
        createAccount.setForeground(Color.BLACK);
        createAccount.addActionListener(this);

        reset_btn = new JButton("Refresh");
        reset_btn.setBounds(500, 335, 100, 40);
        reset_btn.addActionListener(this);
        reset_btn.setFont(new Font("Arial", Font.BOLD, 17));
        reset_btn.setBackground(Color.BLUE);
        reset_btn.setForeground(Color.BLACK);
        reset_btn.addActionListener(this);

        this.add(title);
        this.add(registerTitle);
        this.add(label_username);
        this.add(username);
        this.add(label_password);
        this.add(password);
        this.add(btn);
        this.add(reset_btn);
        this.add(createAccount);
        this.add(showPassword);
        this.add(message);
        this.setVisible(true);

        // Add KeyListener to the password field
        password.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Check if the "Enter" key was pressed
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Perform login action
                    login();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // Action performed method
        // You may keep this method as it is or modify it as needed

        if (evt.getSource() == btn) {
            login();
        } else if (evt.getSource() == reset_btn) {
            username.setText("");
            password.setText("");
        } else if (evt.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('*');
            }
        } else if (evt.getSource() == createAccount) {
            // Create a new RegisterFrame instance only if it doesn't already exist
            RegisterFrame registerFrame = null;
            if (registerFrame == null) {
                registerFrame = new RegisterFrame();
                this.dispose(); // Close the login frame

            }
        }
    }

    private void login() {
        // Get the entered username and password
        String userText = username.getText();
        String pwdText = new String(password.getPassword());

        TestApp testApp = new TestApp();

        // Check if the credentials are valid
        if (testApp.validateCredentials(userText, pwdText)) {
            message.setText("You successfully logged in! ");
            message.setForeground(Color.BLUE);
            // Open another frame with tables from the database
            new NotesApp();
            this.dispose(); // Close the login frame
        } else {
            message.setText("Invalid Username & Password");
            message.setForeground(Color.RED);
            JOptionPane.showMessageDialog(this, "Invalid Username & Password! ");
        }
    }
//      String msg = "your Username is: " + username.getText();
//        msg +=  " And your Password is: " +new String(password.getPassword());
//
//        message.setText(msg);
}