
package is2560;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditServlet", urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {
    
    private int updateID;
    private String firstname;
    private String lastname;
    private String email; 
    private Connection conn;
    private Statement st;
    
    // Method to change existing records
    public void update(String fname, String lname, String email, String id) throws SQLException, ClassNotFoundException {
        
        int parseID = parseInt(id);
        
        try {
            // Establish database connection
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url="jdbc:derby://localhost:1527/sdj25";
            Connection con = DriverManager.getConnection(url, "IS2560", "IS2560");

            // Create SQL statement
            PreparedStatement ps = con.prepareStatement("UPDATE CONFERENCE" 
                    + " SET FIRSTNAME= ? , LASTNAME= ?, EMAIL=?" 
                    + "WHERE ID=  ?");
            ps.setString(1,fname);
            ps.setString(2,lname);
            ps.setString(3,email);
            ps.setInt(4,parseID);

            // Run SQL to update record
            ps.executeUpdate();
            
        } catch (SQLException se) {
            System.out.println("Malformed SQL command");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Problem connecting to database.");
        }
       
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        updateID = parseInt(request.getParameter("file"));
            
            ResultSet rs=null;
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
        try {
            // Manage database connection
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/sdj25";
            conn = DriverManager.getConnection(connectionURL, "IS2560", "IS2560");
            
            // Generate sql statement
            st = conn.createStatement();
            String q1 = new String("SELECT * FROM CONFERENCE WHERE ID = "+updateID);
            rs =  st.executeQuery(q1);
            
        } catch (Exception e) {
                 
        }
        
        // HTML code to display editing screen, autopopulates entries according to selected row
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edit Information</title>"); 
            out.println("<link href='https://fonts.googleapis.com/css?family=Roboto+Condensed' rel='stylesheet'>");
            out.println("<link rel='stylesheet' href='style.css' type='text/css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edit Information</h1>");
            out.println("<div class='center'>");
            out.println("<form method =\"post\" action = \"update.jsp\">");
            out.println("<input type=\"hidden\" name=\"file\" value=\""+request.getParameter("file")+"\" />");
            
            try {
                if (rs.next()){
                   out.println("<h3>First Name:</h3>");
                   out.println("<input type='hidden' name='updateID'  value='" + updateID + "' />"); 
                   out.println("<input type='text' name='firstname'  value='" + rs.getString("FIRSTNAME") + "' required/>"); 
                   out.println("<br>");
                   out.println("<br>");
                   out.println("<h3>Last Name:</h3>");
                   out.println("<input type='text' name='lastname'  value='" + rs.getString("LASTNAME") + "' required/>"); 
                   out.println("<br>");
                   out.println("<br>");
                   out.println("<h3>Email:</h3>");
                   out.println("<input type='text' name='email'  value='" + rs.getString("EMAIL") + "' required/>");
                   out.println("<br>");
                   out.println("<br>");
                   out.println("<input class='button' type='submit' value='Update' />");
                   out.println("</form>");
                   out.println("<br>");
                   out.println("<br>");
                   out.println("<a href=\"ListServlet\">Return to Attendee List Without Updating</a>");
                   
                   
                } else {
                   out.println("<h3>No record found.</h3>"); 
                }
                
            } catch (Exception e) {
                System.out.println("There was a problem executing your action.");
            }
            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
            out.close();
         
    }
    
        public int getUpdateID() {
        return updateID;
    }

    public void setUpdateID(int updateID) {
        this.updateID = updateID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
