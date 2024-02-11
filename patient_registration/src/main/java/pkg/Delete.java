package pkg;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	       try {
	    	   PrintWriter out = res.getWriter();

	           int pid = Integer.parseInt(req.getParameter("pid"));
	           PatientDAO dbase = new PatientDAO();
	           int count = dbase.delete(pid);
	           out.println("<html><body>");
	           if(count>0) {
	        	   out.println("Record deleted succesfully");
	        	   out.println("<br>");
	           }
	           else {
	        	   out.println("Record werenot deleted");
	        	   out.println("<br>");
	           }
	        out.println("<a href='form.html'>Return home</a>");
	   		out.println("<a href='Retrieve'>Retrive</a>");
	   		out.println("</body></html>");
	       }
	       catch(Exception e) {
	    	   System.out.println(e.getMessage());
	       }

	}
}
