
package is2560;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddServlet {

    private String firstname;
    private String lastname;
    private String email;
    
    
    // Method to insert new record into database
    
    public int store() throws ClassNotFoundException, SQLException {
        
        try {
        // Establish connection to database
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url="jdbc:derby://localhost:1527/sdj25";
        Connection con = DriverManager.getConnection(url, "IS2560", "IS2560");
        
        // Construct SQL statement
        PreparedStatement ps = con.prepareStatement("INSERT INTO CONFERENCE(FIRSTNAME,LASTNAME,EMAIL) values(?,?,?)");
        ps.setString(1,firstname);
        ps.setString(2,lastname);
        ps.setString(3,email);
        
        // Execute SQL on database, return int for message handling in add.jap
        int a = ps.executeUpdate();
        
        if (a==1){
            return a;
        } else {
            return a;
        } 
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error establishing database connection.");
            return -1;
        } catch (SQLException se) {
            System.out.println("Error with SQL interaction.");
            return -1;
        } 
          
    }
    
        // Getters
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }
    
    // Setters
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
