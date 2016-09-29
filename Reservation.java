package pms_package;

import java.util.Date;

public class Reservation {
	private Room roomInfo;
	private Guest guestInfo;
	private Date checkIn;
	private Date checkOut;
	private enum status {
		CANCELLED,
		NO_SHOW,
		CHECKED_IN,
		CHECKED_OUT,
		ACTIVE
	}
	private double ratePlan;
	private Payment paymentInfo;
}
