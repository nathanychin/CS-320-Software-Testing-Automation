package ProjectOne;

import java.util.Date;

public class Appointment {

	private String Initializer;
	private String appointmentId;
    private Date appointmentDate;
    private String description;
	
    {Initializer = "Inital";}
	
	Appointment() {
	  Date today = new Date();
	  appointmentId = Initializer;
	  appointmentDate = today;
	  description = Initializer;
	}
	
	Appointment(String id) {
	  Date today = new Date();
	  updateAppointmentId(id);
	  appointmentDate = today;
	  description = Initializer;
	}
	
	Appointment(String id, Date date) {
	  updateAppointmentId(id);
	  updateDate(date);
	  description = Initializer;
	}
	
	Appointment(String id, Date date, String description) {
	  updateAppointmentId(id);
	  updateDate(date);
	  updateDescription(description);
	}
	
	public void updateAppointmentId(String id) {
	  if (id == null) {
	    throw new IllegalArgumentException("Appointment ID invalid.");
	  } else if (id.length() > 10) {
	    throw new IllegalArgumentException("Appointment ID cannot exceed 10 characters.");
	  } else {
		  this.appointmentId = id;
	  }
	}
	
	public String getAppointmentId(){
		return appointmentId; 
	}
	
	public void updateDate(Date date) {
	    if (date == null) {
	      throw new IllegalArgumentException("Appointment date invalid.");
	    } else if (date.before(new Date())) {
	      throw new IllegalArgumentException("Appointment date invalid");
	    } else {
	      this.appointmentDate = date;
	    }
	}
	
	public Date getAppointmentDate() { 
		return appointmentDate; 
	}
	
	public void updateDescription(String description) {
	    if (description == null) {
	      throw new IllegalArgumentException("Appointment description is empty.");
	    } else if (description.length() > 50) {
	      throw new IllegalArgumentException("Appointment description cannot exceed 50 characters.");
	    } else {
	      this.description = description;
	    }
	}
	
	  public String getDescription() { return description; }
}