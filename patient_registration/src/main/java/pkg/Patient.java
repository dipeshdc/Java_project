package pkg;

public class Patient {
	   int patient_id;
	   String name,address,phone;
	   
	   public int getPatientId() {
	        return patient_id;
	    }

	    public void setPatientId(int patientId) {
	        this.patient_id = patientId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }
	}
