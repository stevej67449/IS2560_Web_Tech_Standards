
package is2560;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "ListServlet", urlPatterns = {"/ListServlet"})
public class ListServlet extends HttpServlet {
    
    private Connection con;
    private Statement st;
    private ResultSet rs=null;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            // Database connection
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url="jdbc:derby://localhost:1527/sdj25";
            con = DriverManager.getConnection(url, "IS2560", "IS2560");
            
            // SQL Management
            st = con.createStatement();
            String q1 = new String("SELECT * FROM CONFERENCE");
            rs = st.executeQuery(q1);
            
        } catch (Exception e){
            out.println("Uh oh, something has gone wrong.");
        }
            // HTML display output
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Attendance Manager</title>");
            out.println("<link href='https://fonts.googleapis.com/css?family=Roboto+Condensed' rel='stylesheet'>");
            out.println("<link rel='stylesheet' href='style.css' type='text/css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>List of Attendees</h1>");
            out.println("<div class='center'>");
            out.println("<form action=\"newAttendee.jsp\" method=\"POST\">");
            out.println("<input class='button' type=\"submit\" value=\"Add New\" />");
            out.println("</form>");
            out.println("</div>");
            out.println("<br>");
            
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>");
            out.println("ID#");
            out.println("</th>");
            out.println("<th>");
            out.println("First");
            out.println("</th>");
            out.println("<th>");
            out.println("Last");
            out.println("</th>");
            out.println("<th>");
            out.println("Email");
            out.println("</th>");
            out.println("<th>");
            out.println("");
            out.println("</th>");

            // Will cycle through entire database and generate table for display
            try {
                while (rs.next()) {
                 out.println("<tr><td>" + rs.getString("ID")+"</td>"
                   + "<td>" + rs.getString("FIRSTNAME") + "</td>"
                   + "<td>" + rs.getString("LASTNAME") + "</td>"
                   + "<td>" + rs.getString("EMAIL") + "</td>"
                   + "<td><a href=\"EditServlet?file=" + rs.getString("ID")
                   + "\">Edit</a></td></tr>");

                }
            } catch (Exception e) {
                out.println("Uh oh, something has gone wrong.");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

       
    
}
