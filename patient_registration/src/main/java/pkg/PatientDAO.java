package pkg;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class PatientDAO {
   public Connection connect() throws Exception{
	   String uname="root";
	   String pwd ="";
	   String url ="jdbc:mysql://localhost:3306/hospital";
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection cn = DriverManager.getConnection(url,uname,pwd);
	   return cn;
   }
   public boolean insert(Patient patient) throws Exception{
		   Connection cn = connect();
		   PreparedStatement st = cn.prepareStatement("Insert into patient values(?,?,?,?)");
		   st.setInt(1, patient.getPatientId());
		   st.setString(2, patient.getName());
		   st.setString(3, patient.getAddress());
		   st.setString(4, patient.getPhone());
		   
		   int i = st.executeUpdate();
		   if(i>0) {
			   return true;
		   }
		   else {
			   return false;
		   }
   }
   
   public List<Patient> selectAll() throws Exception{
		List<Patient> patients = new ArrayList<Patient>();
		
		Connection cn = connect();
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("Select * from patient");
		
		while(rs.next()) {
			Patient p = new Patient();
			p.setPatientId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setAddress(rs.getString(3));
			p.setPhone(rs.getString(4));
			patients.add(p);
		}
		
		return patients;
	}
   
   public Patient selectById(int patientId) throws Exception {
	    Patient patient = new Patient();
	    
	    Connection cn = connect();
	    PreparedStatement st = cn.prepareStatement("SELECT * FROM patient WHERE patient_id = ?");
	    st.setInt(1, patientId);
	    
	    ResultSet rs = st.executeQuery();
	    
	    if (rs.next()) {
	        patient.setPatientId(rs.getInt(1));
	        patient.setName(rs.getString(2));
	        patient.setAddress(rs.getString(3));
	        patient.setPhone(rs.getString(4));
	    }
	    
	    return patient;
	}
   
   public int update(Patient patient) throws Exception {
	    Connection cn = connect();
	    PreparedStatement st = cn.prepareStatement("UPDATE patient SET name=?, address=?, phone=? WHERE patient_id=?");

	    st.setString(1, patient.getName());
	    st.setString(2, patient.getAddress());
	    st.setString(3, patient.getPhone());
	    st.setInt(4, patient.getPatientId());

	    int rowsAffected = st.executeUpdate();
	    return rowsAffected;
	}

   public int delete(int patientId) throws Exception {
	    Connection cn = connect();
	    PreparedStatement st = cn.prepareStatement("DELETE FROM patient WHERE patient_id=?");

	    st.setInt(1, patientId);

	    int rowsAffected = st.executeUpdate();
	    return rowsAffected;
	}


   public boolean isPatientExists(String name, String address) throws Exception {
	    Connection cn = null;
	    PreparedStatement st = null;
	    ResultSet rs = null;

	    try {
	        cn = connect();
	        String query = "SELECT COUNT(*) FROM patient WHERE name = ? AND address = ?";
	        st = cn.prepareStatement(query);
	        st.setString(1, name);
	        st.setString(2, address);

	        rs = st.executeQuery();
	        if (rs.next()) {
	            int count = rs.getInt(1);
	            return count > 0; 
	        }
	    } finally {
	        if (rs != null) rs.close();
	        if (st != null) st.close();
	        if (cn != null) cn.close();
	    }

	    return false; 
	}

   
}

