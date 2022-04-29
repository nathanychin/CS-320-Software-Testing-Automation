package ProjectOne;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	private Date date, pastDate;
	private String id;
	private String description;
	private String longId;
	private String longDescription;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void testInfo() {
		id = "1234567890";
		description = "Required description";
		date = new Date(2025, Calendar.APRIL, 4);
		longId = "1234567890001";
		longDescription = "Description contains more than 50 characters. This is not allowed.";
		pastDate = new Date(0);
	}
	
	  @Test
	  void testUpdateAppointmentId() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class,
	                 () -> appt.updateAppointmentId(null));
	    assertThrows(IllegalArgumentException.class,
	                 () -> appt.updateAppointmentId(longId));
	    appt.updateAppointmentId(id);
	    assertEquals(id, appt.getAppointmentId());
	  }

	  @Test
	  void testGetAppointmentId() {
	    Appointment appt = new Appointment(id);
	    assertNotNull(appt.getAppointmentId());
	    assertEquals(appt.getAppointmentId().length(), 10);
	    assertEquals(id, appt.getAppointmentId());
	  }

	  @Test
	  void testUpdateDate() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class, () -> appt.updateDate(null));
	    assertThrows(IllegalArgumentException.class,
	                 () -> appt.updateDate(pastDate));
	    appt.updateDate(date);
	    assertEquals(date, appt.getAppointmentDate());
	  }

	  @Test
	  void testGetAppointmentDate() {
	    Appointment appt = new Appointment(id, date);
	    assertNotNull(appt.getAppointmentDate());
	    assertEquals(date, appt.getAppointmentDate());
	  }

	  @Test
	  void testUpdateDescription() {
	    Appointment appt = new Appointment();
	    assertThrows(IllegalArgumentException.class,
	                 () -> appt.updateDescription(null));
	    assertThrows(IllegalArgumentException.class,
	                 () -> appt.updateDescription(longDescription));
	    appt.updateDescription(description);
	    assertEquals(description, appt.getDescription());
	  }

	  @Test
	  void testGetDescription() {
	    Appointment appt = new Appointment(id, date, description);
	    assertNotNull(appt.getDescription());
	    assertTrue(appt.getDescription().length() <= 50);
	    assertEquals(description, appt.getDescription());
	  }

}
