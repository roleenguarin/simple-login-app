package test;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AdminPage implements ActionListener{
    
    private JFrame f;
    private JPanel pn, ps, pe, pw, pc, pc1, pc2, pc3, pc4, pc11, pc12, pc21, pc22, pc31, pc32, pc41, pc42;
    //
    private JLabel emailL, pwL, roleL;
    private JButton logout, update, addUser;
    private JTextArea addEmail, addPW, addRole;
    //
    private ArrayList<String> emails, pws, roles;
    private ArrayList<JButton> deletes;
    private ArrayList<JTextArea> emailTAs, pwTAs, roleTAs;
    
    public AdminPage() throws SQLException{
        f = new JFrame("Admin");
        
        pn = new JPanel();
        ps = new JPanel();
        pe = new JPanel();
        pw = new JPanel();
        pc = new JPanel();
        pc1 = new JPanel();
        pc2 = new JPanel();
        pc3 = new JPanel();
        pc4 = new JPanel();
        pc11 = new JPanel();
        pc12 = new JPanel();
        pc21 = new JPanel();
        pc22 = new JPanel();
        pc31 = new JPanel();
        pc32 = new JPanel();
        pc41 = new JPanel();
        pc42 = new JPanel();
                
        emailL = new JLabel("Email");
        pwL = new JLabel("Password");
        roleL = new JLabel("Role");
        emails = new ArrayList<>();
        pws = new ArrayList<>();
        roles = new ArrayList<>();
        deletes = new ArrayList<>();
        emailTAs = new ArrayList<>();
        pwTAs = new ArrayList<>();
        roleTAs = new ArrayList<>();
        
        logout = new JButton("Logout");
        update = new JButton("Update");
        addUser = new JButton("Add User");
        
        addEmail = new JTextArea();
        addPW = new JTextArea();
        addRole = new JTextArea();
    }
    
    public void startApp() throws SQLException{
        f.setLayout(new BorderLayout());
        f.setMaximumSize(new Dimension(600,600));
        
        f.add(pn, BorderLayout.NORTH);
        f.add(ps, BorderLayout.SOUTH);
        f.add(pe, BorderLayout.EAST);
        f.add(pw, BorderLayout.WEST);
        f.add(pc, BorderLayout.CENTER);
        pn.setPreferredSize(new Dimension(600,20));
        ps.setPreferredSize(new Dimension(600,60));
        pe.setPreferredSize(new Dimension(20,520));
        pw.setPreferredSize(new Dimension(20,520));
        pc.setPreferredSize(new Dimension(560,520));
        pn.setBackground(Color.white);
        ps.setBackground(Color.white);
        pe.setBackground(Color.white);
        pw.setBackground(Color.white);
        pc.setBackground(Color.white);
        
        pc1.setBackground(Color.white);
        pc2.setBackground(Color.white);
        pc3.setBackground(Color.white);
        pc4.setBackground(Color.white);
        pc11.setBackground(Color.white);
        pc12.setBackground(Color.white);
        pc21.setBackground(Color.white);
        pc22.setBackground(Color.white);
        pc31.setBackground(Color.white);
        pc32.setBackground(Color.white);
        pc41.setBackground(Color.white);
        pc42.setBackground(Color.white);
        
        
        logout.setFocusPainted(false);
        logout.setPreferredSize(new Dimension(600,30));
        logout.setBackground(Color.white);
        logout.addActionListener(this);
        update.setFocusPainted(false);
        update.setPreferredSize(new Dimension(600,30));
        update.setBackground(Color.white);
        update.addActionListener(this);
        addUser.setFocusPainted(false);
        addUser.setPreferredSize(new Dimension(600,30));
        addUser.setBackground(Color.white);
        addUser.addActionListener(this);
        
        pc.setLayout(new BoxLayout(pc, BoxLayout.X_AXIS));
        pc.add(pc1);
            pc1.setLayout(new BorderLayout());
            pc1.setPreferredSize(new Dimension(pc.getWidth()/4, 520));
            pc1.add(pc11, BorderLayout.NORTH); 
                pc11.setMaximumSize(new Dimension(pc.getWidth()/4,25));
                pc11.setLayout(new FlowLayout(FlowLayout.CENTER));
                pc11.add(emailL);
            pc1.add(pc12, BorderLayout.CENTER);
                pc12.setLayout(new BoxLayout(pc12, BoxLayout.Y_AXIS));
        pc.add(pc2);
            pc2.setLayout(new BorderLayout());
            pc2.setPreferredSize(new Dimension(pc.getWidth()/4, 520));
            pc2.add(pc21, BorderLayout.NORTH);
                pc21.setMaximumSize(new Dimension(pc.getWidth()/4,25));
                pc21.setLayout(new FlowLayout(FlowLayout.CENTER));
                pc21.add(pwL);
            pc2.add(pc22, BorderLayout.CENTER);
                pc22.setLayout(new BoxLayout(pc22, BoxLayout.Y_AXIS));
        pc.add(pc3);
            pc3.setLayout(new BorderLayout());
            pc3.setPreferredSize(new Dimension(pc.getWidth()/4, 520));
            pc3.add(pc31, BorderLayout.NORTH);
                pc31.setMaximumSize(new Dimension(pc.getWidth()/4,25));
                pc31.setLayout(new FlowLayout(FlowLayout.CENTER));
                pc31.add(roleL);
            pc3.add(pc32, BorderLayout.CENTER);
                pc32.setLayout(new BoxLayout(pc32, BoxLayout.Y_AXIS));
        pc.add(pc4);
            pc4.setLayout(new BorderLayout());
            pc4.setPreferredSize(new Dimension(pc.getWidth()/4, 520));
            pc4.add(pc41, BorderLayout.NORTH);
                pc41.setPreferredSize(new Dimension(pc.getWidth()/4,25));
            pc4.add(pc42, BorderLayout.CENTER);
                pc42.setLayout(new BoxLayout(pc42, BoxLayout.Y_AXIS));
                
                for (int i=0; i<User.getAll().size(); i++){
                    String email = User.getAll().get(i).getEmail();
                    emails.add(email);
                    JTextArea emailTA = new JTextArea(email);
                    emailTA.setMaximumSize(new Dimension(140, 25));
                    emailTAs.add(emailTA);
                    pc12.add(emailTA);
                    String password = User.getAll().get(i).getPW();
                    pws.add(password);
                    JTextArea pwTA = new JTextArea(password);
                    pwTA.setMaximumSize(new Dimension(140, 25));
                    pwTAs.add(pwTA);
                    pc22.add(pwTA);
                    String role = User.getAll().get(i).getRole();
                    roles.add(role);
                    JTextArea roleTA = new JTextArea(role);
                    roleTA.setMaximumSize(new Dimension(140, 25));
                    roleTAs.add(roleTA);
                    pc32.add(roleTA);
                    JButton delete = new JButton("Delete");
                    delete.setMaximumSize(new Dimension(140, 25));
                    delete.setFocusPainted(false);
                    delete.setBackground(Color.white);
                    delete.addActionListener(this);
                    deletes.add(delete);
                    pc42.add(delete);
                }
                addEmail.setBorder(BorderFactory.createLineBorder(Color.white));
                addEmail.setBackground(Color.LIGHT_GRAY);
                addEmail.setMaximumSize(new Dimension(140, 25));
                addPW.setBorder(BorderFactory.createLineBorder(Color.white));
                addPW.setBackground(Color.LIGHT_GRAY);
                addPW.setMaximumSize(new Dimension(140, 25));
                addRole.setBorder(BorderFactory.createLineBorder(Color.white));
                addRole.setBackground(Color.LIGHT_GRAY);
                addRole.setMaximumSize(new Dimension(140, 25));
                addUser.setMaximumSize(new Dimension(140, 25));
                pc12.add(addEmail);
                pc22.add(addPW);
                pc32.add(addRole);
                pc42.add(addUser);
                
        ps.setLayout(new BorderLayout());
        ps.add(update, BorderLayout.NORTH);
        ps.add(logout, BorderLayout.SOUTH);
        
        f.setSize(600,600);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((d.width/2 - 300),(d.height/2 - 300));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void refreshLists() {
        try {
            Component[] emailList = pc12.getComponents();
            Component[] pwList = pc22.getComponents();
            Component[] roleList = pc32.getComponents();
            Component[] deleteList = pc42.getComponents();
            
            for (int c=0; c<emailList.length; c++){
                pc12.remove(emailList[c]);
                pc22.remove(pwList[c]);
                pc32.remove(roleList[c]);
                pc42.remove(deleteList[c]);
            }
            
            emails.clear();
            pws.clear();
            roles.clear();
            deletes.clear();
            emailTAs.clear();
            pwTAs.clear();
            roleTAs.clear();

            for (int i=0; i<User.getAll().size(); i++){
                String email = User.getAll().get(i).getEmail();
                emails.add(email);
                JTextArea emailTA = new JTextArea(email);
                emailTA.setMaximumSize(new Dimension(140, 25));
                emailTAs.add(emailTA);
                pc12.add(emailTA);
                
                String password = User.getAll().get(i).getPW();
                pws.add(password);
                JTextArea pwTA = new JTextArea(password);
                pwTA.setMaximumSize(new Dimension(140, 25));
                pwTAs.add(pwTA);
                pc22.add(pwTA);
                
                String role = User.getAll().get(i).getRole();
                roles.add(role);
                JTextArea roleTA = new JTextArea(role);
                roleTA.setMaximumSize(new Dimension(140, 25));
                roleTAs.add(roleTA);
                pc32.add(roleTA);
                
                JButton delete = new JButton("Delete");
                delete.setMaximumSize(new Dimension(140, 25));
                delete.setFocusPainted(false);
                delete.setBackground(Color.white);
                delete.addActionListener(this);
                deletes.add(delete);
                pc42.add(delete);
            }
            
            addEmail.setText("");
            addPW.setText("");
            addRole.setText("");
            pc12.add(addEmail);
            pc22.add(addPW);
            pc32.add(addRole);
            pc42.add(addUser);
        } catch (SQLException ex) {
            Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source == logout) {
            f.dispose();
            
            Login login = new Login();
            login.startApp();
        }
        else if(source == update){
            String windowTitle = new String();
            for (int a=0; a<emails.size(); a++) {
                try {
                    String inEmail = emailTAs.get(a).getText();
                    String inPW = pwTAs.get(a).getText();
                    String inRole = roleTAs.get(a).getText();
                        
                    if (!(User.getAll().get(a).getPW().equals(inPW)) || 
                        !(User.getAll().get(a).getRole().equals(inRole))){
                        User.updateRecords(inEmail, inPW, inRole);
                        windowTitle = "Admin - Updated!";
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (windowTitle.equals("")){
                    windowTitle = "Admin";
                }
            }
            
            refreshLists();
            
            f.setTitle(windowTitle);
            f.invalidate();
            f.validate();
            f.repaint();
        }
        else if(source == addUser) {
            try {
                User newUser = new User (addEmail.getText(), addPW.getText(), addRole.getText());
                User.addRecord(newUser);
            
                refreshLists();
                
                f.invalidate();
                f.validate();
                f.repaint();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else  {
            for (int b=0; b<deletes.size(); b++){
                if (source == deletes.get(b)) {
                    try {
                        User.deleteRecord(User.getAll().get(b).getEmail());
                    
                        refreshLists();
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                }
            }
                    
            f.invalidate();
            f.validate();
            f.repaint();
        }        
    }
}