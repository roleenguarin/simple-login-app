package test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private String role;
    
    public User (String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    public static List<User> getAll() throws SQLException {
        String sql = "SELECT * FROM Users ORDER BY EMAIL ASC";
        List<User> users = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dbname", "username", "password");
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ResultSet results = ps.executeQuery();
            while (results.next()){
                String email = results.getString("EMAIL");
                String password = results.getString("PASSWORD");
                String role = results.getString("USERROLE");
                User user = new User(email, password, role);
                users.add(user);
            }
        }
        
        return users;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPW() {
        return this.password;
    }
    
    public String getRole() {
        return this.role;
    }
    
    public static void deleteRecord(String email) throws SQLException{
        String deleteString = "DELETE FROM USERS WHERE EMAIL = ?";
        
        try (Connection conn = 
            DriverManager.getConnection("jdbc:derby://localhost:1527/dbname", "username", "password");
            PreparedStatement ps = conn.prepareStatement(deleteString);) {
        ps.setString(1, email);
        ps.executeUpdate();
        }
        
    }
    
    public static void addRecord(User user) throws SQLException{
        String deleteString = "INSERT INTO USERS (EMAIL, PASSWORD, USERROLE) VALUES (?,?,?)";
        
        try (Connection conn = 
            DriverManager.getConnection("jdbc:derby://localhost:1527/dbname", "username", "password");
            PreparedStatement ps = conn.prepareStatement(deleteString);) {
        ps.setString(1, user.email);
        ps.setString(2, user.password);
        ps.setString(3, user.role);
        ps.executeUpdate();
        }
    }
    
    public static void updateRecords(String email, String pw, String role) throws SQLException {
        String updateString = "UPDATE USERS SET PASSWORD = ?, USERROLE = ? WHERE EMAIL = ?";
        
        try (Connection conn = 
            DriverManager.getConnection("jdbc:derby://localhost:1527/dbname", "username", "password");
            PreparedStatement ps = conn.prepareStatement(updateString);) {
        ps.setString(1, pw);
        ps.setString(2, role);
        ps.setString(3, email);
        ps.executeUpdate();
        }
    }
    
    public static int checkLogin (String email, String password) throws SQLException {   
        int result = 0;
        
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).email.equals(email)&& getAll().get(i).password.equals(password)) {
                if (getAll().get(i).role.equals("Guest")){
                    result = 1;
                }
                else if (getAll().get(i).role.equals("Admin")){
                    result =  2;
                }
                
                break;
            }
            else {
                result =  3;
            }
        } return result;
    }
}