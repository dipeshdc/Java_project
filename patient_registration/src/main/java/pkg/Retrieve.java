package pkg;

import java.io.*;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.*;


public class Retrieve extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		try {
			List<Patient> patients = new PatientDAO().selectAll();
			PrintWriter out = res.getWriter();
			out.println("<html> <body>");
			out.println("<table border='2px solid'>");
			out.println("<tr><th>Patient ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>Address</th>");
			out.println("<th>Phone</th>");
			out.println("<th>Edit</th>");
			out.println("<th>Delete</th></tr>");
			
			for(Patient i:patients) {
				out.println("<tr><td>"+i.getPatientId()+"</td>");
				out.println("<td>"+i.getName()+"</td>");
				out.println("<td>"+i.getAddress()+"</td>");
				out.println("<td>"+i.getPhone()+"</td>");
				out.println("<td><a href='Edit?pid="+i.getPatientId()+"'>Edit</a></td>");
				out.println("<td><a href='javascript:void(0);' onclick='confirmDelete(" + i.getPatientId() + ")'>Delete</a></td></tr>");
            }
			
		 
		    out.println("<br>");		
			out.println("<a href='form.html'>Return home</a>");

			
			out.println("<script>");
			out.println("    function confirmDelete(patientId) {");
			out.println("        var confirmResult = confirm('Are you sure you want to delete this patient?');");
			out.println("        if (confirmResult) {");
			out.println("            window.location.href = 'Delete?pid=' + patientId;");
			out.println("        }");
			out.println("    }");
			out.println("</script>");



			out.println("</body></html>");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}



