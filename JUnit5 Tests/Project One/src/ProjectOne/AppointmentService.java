package ProjectOne;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
	
	private List<Appointment> appointmentList = new ArrayList<>();
	private String newId() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	public void newAppointment() {
		Appointment appt = new Appointment(newId());
		appointmentList.add(appt);
	}
	
	public void newAppointment(Date date) {
		Appointment appt = new Appointment(newId(), date);
		appointmentList.add(appt);
	}
	
	public void newAppointment(Date date, String description) {
		Appointment appt = new Appointment(newId(), date, description);
		appointmentList.add(appt);
	}
	
	protected List<Appointment> getAppointmentList(){
		return appointmentList;
	}
	
	public void deleteAppointment(String id) throws Exception {
		appointmentList.remove(searchAppointment(id));
	}
	
	
	private Appointment searchAppointment(String id) throws Exception {
		int i = 0;
		while (i < appointmentList.size()) {
			if (id.equals(appointmentList.get(i).getAppointmentId())) {
				return appointmentList.get(i);
			}
			i++;
		}
		throw new Exception("Appointment does not exist");
	}	
}
