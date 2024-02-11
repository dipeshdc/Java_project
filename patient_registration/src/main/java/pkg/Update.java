package pkg;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;


public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       try {
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
		int count = dbase.update(patient);
		
		out.println("<html><body>");
		if(count>0) {
			out.println("Record updated succesfully.");
			out.println("<br>");
		}
		else {
			out.println("Record werenot updated");
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
