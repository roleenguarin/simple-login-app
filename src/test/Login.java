package test;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Login implements ActionListener{
    static private int attempts = 0;
    
    private JFrame f;
    private JPanel main, pnorth, psouth, peast, pwest, pcenter, pc1, pc2, pc11, pc111, pc113, pc12, pc121, pc123, pc21, pc22, pc23, pc24, pc231, pc232;
    //
    private JLabel unL, pwL;
    private JButton login;
    private JTextField unTF;
    private JPasswordField pwTF;
    //
    
    public Login() {
        f = new JFrame("Login Screen");
        
        main = new JPanel();
        pnorth = new JPanel();
        psouth = new JPanel();
        peast = new JPanel();
        pwest = new JPanel();
        pcenter = new JPanel();
        pc1 = new JPanel();
        pc2 = new JPanel();
        pc11 = new JPanel();
        pc111 = new JPanel();
        pc113 = new JPanel();
        pc12 = new JPanel();
        pc121 = new JPanel();
        pc123 = new JPanel();
        pc21 = new JPanel();
        pc22 = new JPanel();
        pc24 = new JPanel();
        pc23 = new JPanel();
        pc231 = new JPanel();
        pc232 = new JPanel();
        
        unL = new JLabel("Username: ");
        pwL = new JLabel("Password: ");
        unTF = new JTextField(15);
        pwTF = new JPasswordField(15);
        
        login = new JButton("Login");
    }
    
    public void startApp(){
        main.setLayout(new BorderLayout());
        
        f.add(main);
        main.add(pnorth, BorderLayout.NORTH);
        main.add(psouth, BorderLayout.SOUTH);
        main.add(peast, BorderLayout.EAST);
        main.add(pwest, BorderLayout.WEST);
        main.add(pcenter, BorderLayout.CENTER);
        pnorth.setPreferredSize(new Dimension(450, 25));
        peast.setPreferredSize(new Dimension(75, 175));
        pwest.setPreferredSize(new Dimension(75, 175));
        
        pcenter.setLayout(new GridLayout(2,1));
        pcenter.setPreferredSize(new Dimension(300, 175));
        pcenter.add(pc1);
        pcenter.add(pc2);
        pc1.setLayout(new GridLayout(1,2));
        pc1.add(pc11);
            pc11.setLayout(new GridLayout(3,1));
            pc11.add(unL);
            pc11.add(pwL);
            pc11.add(pc113);
        pc1.add(pc12);
            pc12.setLayout(new GridLayout(3,1));
            pc12.add(unTF);
            pc12.add(pwTF);
            pwTF.setEchoChar('*');
            pc12.add(pc123);
        pc2.setLayout(new GridLayout(3,1));
            pc2.add(pc23);
            pc23.setLayout(new GridLayout(1,2));
            pc23.add(pc231);
            login.setFocusPainted(false);
            login.setBackground(Color.white);
            login.addActionListener(this);
            pc23.add(login);
            pc23.add(pc232);
        
        
        f.setSize(450,200);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((d.width/2 - 225),(d.height/2 - 100));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
        try {
            String email = unTF.getText();
            String pw = new String(pwTF.getPassword());
            
            int loginResult = User.checkLogin(email, pw);
        
            f.dispose();

            String[] options = {"OK"};
            if (loginResult == 1) {
                try {
                    GuestPage guestPage = new GuestPage();
                    guestPage.startApp();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (loginResult == 2) {
                try {
                    AdminPage adminPage = new AdminPage();
                    adminPage.startApp();
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (loginResult == 3){
                attempts++;

                if (attempts < 3){
                    int result = JOptionPane.showOptionDialog(null, "Incorrect username/password.", "Error Screen", 0, 0, null, options, options[0]);

                    Login login = new Login();
                    login.startApp();
                }
                else  {
                    attempts = 0;
                    int result = JOptionPane.showOptionDialog(null, "Sorry, you have reached the limit of 3 tries. good bye!", "Error Screen", 0, 0, null, options, options[0]);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}