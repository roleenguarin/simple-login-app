package test;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class GuestPage implements ActionListener{
    
    private JFrame f;
    private JPanel pn, ps, pe, pw, pc, pc1, pc2, pc3, pc11, pc12, pc21, pc22, pc31, pc32;
    //
    private JLabel emailL, pwL, roleL;
    private JButton logout;
    //
    
    public GuestPage() throws SQLException{
        f = new JFrame("Guest");
        
        pn = new JPanel();
        ps = new JPanel();
        pe = new JPanel();
        pw = new JPanel();
        pc = new JPanel();
        pc1 = new JPanel();
        pc2 = new JPanel();
        pc3 = new JPanel();
        pc11 = new JPanel();
        pc12 = new JPanel();
        pc21 = new JPanel();
        pc22 = new JPanel();
        pc31 = new JPanel();
        pc32 = new JPanel();
                
        emailL = new JLabel("Email");
        pwL = new JLabel("Password");
        roleL = new JLabel("Role");
        
        logout = new JButton("Logout");
    }
    
    public void startApp() throws SQLException{
        f.setLayout(new BorderLayout());
        f.setMaximumSize(new Dimension(600,600));
        
        f.add(pn, BorderLayout.NORTH);
        f.add(logout, BorderLayout.SOUTH);
        f.add(pe, BorderLayout.EAST);
        f.add(pw, BorderLayout.WEST);
        f.add(pc, BorderLayout.CENTER);
        pn.setPreferredSize(new Dimension(600,20));
        pe.setPreferredSize(new Dimension(20,520));
        pw.setPreferredSize(new Dimension(20,520));
        pc.setPreferredSize(new Dimension(560,540));
        pn.setBackground(Color.white);
        pe.setBackground(Color.white);
        pw.setBackground(Color.white);
        pc.setBackground(Color.white);
        
        pc1.setBackground(Color.white);
        pc2.setBackground(Color.white);
        pc3.setBackground(Color.white);
        pc11.setBackground(Color.white);
        pc12.setBackground(Color.white);
        pc21.setBackground(Color.white);
        pc22.setBackground(Color.white);
        pc31.setBackground(Color.white);
        pc32.setBackground(Color.white);
        
        
        logout.setFocusPainted(false);
        logout.setPreferredSize(new Dimension(600,40));
        logout.setBackground(Color.white);
        logout.addActionListener(this);
        
        pc.setLayout(new BoxLayout(pc, BoxLayout.X_AXIS));
        pc.add(pc1);
            pc1.setLayout(new BorderLayout());
            pc1.setPreferredSize(new Dimension(pc.getWidth()/3, 540));
            pc1.add(pc11, BorderLayout.NORTH); 
                pc11.setMaximumSize(new Dimension(180,25));
                pc11.setLayout(new FlowLayout(FlowLayout.CENTER));
                pc11.add(emailL);
            pc1.add(pc12, BorderLayout.CENTER);
                pc12.setLayout(new BoxLayout(pc12, BoxLayout.Y_AXIS));
        pc.add(pc2);
            pc2.setLayout(new BorderLayout());
            pc2.setPreferredSize(new Dimension(pc.getWidth()/3, 540));
            pc2.add(pc21, BorderLayout.NORTH);
                pc21.setMaximumSize(new Dimension(180,25));
                pc21.setLayout(new FlowLayout(FlowLayout.CENTER));
                pc21.add(pwL);
            pc2.add(pc22, BorderLayout.CENTER);
                pc22.setLayout(new BoxLayout(pc22, BoxLayout.Y_AXIS));
        pc.add(pc3);
            pc3.setLayout(new BorderLayout());
            pc3.setPreferredSize(new Dimension(pc.getWidth()/3, 540));
            pc3.add(pc31, BorderLayout.NORTH);
                pc31.setMaximumSize(new Dimension(180,25));
                pc31.setLayout(new FlowLayout(FlowLayout.CENTER));
                pc31.add(roleL);
            pc3.add(pc32, BorderLayout.CENTER);
                pc32.setLayout(new BoxLayout(pc32, BoxLayout.Y_AXIS));
                
                for (int i=0; i<User.getAll().size(); i++){
                    JTextArea emailTA = new JTextArea(User.getAll().get(i).getEmail());
                    emailTA.setMaximumSize(new Dimension(180, 25));
                    pc12.add(emailTA);
                    JTextArea pwTA = new JTextArea(User.getAll().get(i).getPW());
                    pwTA.setMaximumSize(new Dimension(180, 25));
                    pc22.add(pwTA);
                    JTextArea roleTA = new JTextArea(User.getAll().get(i).getRole());
                    roleTA.setMaximumSize(new Dimension(180, 25));
                    pc32.add(roleTA);
                }
        
        f.setSize(600,600);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((d.width/2 - 300),(d.height/2 - 300));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
        f.dispose();
        Login login = new Login();
        login.startApp();
    }
}