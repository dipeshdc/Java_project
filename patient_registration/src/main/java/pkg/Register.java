package pkg;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class Register extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		PrintWriter out = res.getWriter();
		
		int pid = Integer.parseInt(req.getParameter("pid"));
		String name = req.getParameter("name");
		String address = req.getParameter("add");
		String phone = req.getParameter("phone");
		
		Patient patient = new Patient();
		patient.setPatientId(pid);
		patient.setName(name);
		patient.setAddress(address);
		patient.setPhone(phone);
		
		PatientDAO dbase = new PatientDAO();
		try {
		boolean exist = dbase.isPatientExists(name,address);	
		out.println("<html><body>");
		
		if(exist) {
			out.println("You are already in the list.");
		}
		else {
		boolean s = dbase.insert(patient);
		
		
			if(s) {
				out.println("Record inserted succesfully.");
			    out.println("<br>");
			}
			else {
				out.println("Record not inserted");
				out.println("<br>");
			}
			
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