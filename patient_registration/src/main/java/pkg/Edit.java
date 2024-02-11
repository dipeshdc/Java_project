package pkg;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Edit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    	  try {
    	PrintWriter out = res.getWriter();

        int pid = Integer.parseInt(req.getParameter("pid"));

        Patient patient = new Patient(); 
        PatientDAO dbase = new PatientDAO();
      
            patient = dbase.selectById(pid);
        

        out.println("<html><body>");
        out.println("<form action='Update' method='POST'>");
        out.println("<pre>");
        out.println("PatientId:<input type='number' name='pid' readonly value='" + patient.getPatientId() + "'><br>");
        out.println("Name:     <input type='text' name='name' value= '" + patient.getName() + "'><br>");
        out.println("Address:  <input type='text' name='add' value='" + patient.getAddress() + "'><br>");
        out.println("Phone:    <input type='tel' name='phone' value ='" + patient.getPhone() + "'><br>");
        out.println("<input type='Submit' value='Update'><br>");
        out.println("</pre>");
        out.println("</form>");
        out.println("</body></html>");
    }
        catch (Exception e) {
            System.out.println("Exception in Edit servlet: " + e.getMessage());
          
        }
    	  

    }
}
