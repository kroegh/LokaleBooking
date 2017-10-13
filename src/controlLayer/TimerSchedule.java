package controlLayer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import modelLayer.EnumRoomStatus;

/**
 * Timer klasse der planlægger notifikationer til TimeKeeper omkring dato og tid.
 * Bruges til at sætte deadlines for checkin, "rengøring" i gamle bookinger og 
 * opdatering af GUI til at vise korrekt ugedag.  
 * 
 * SOURCE: http://stackoverflow.com/questions/11361332/how-to-call-a-method-on-specific-time-in-java
 * 
 * @author Bjarne, Frederik, Kristoffer, Ramanan (Gruppe 2)
 * @version 0.1
 * @since 19-12-2016
 *  
 */

public class TimerSchedule {

	private DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		// Format af dato
	
	private Timer timer1 = new Timer();		// Timer for starten af firstSlice (morgen)
	private Timer timer2 = new Timer();		// Timer for starten af secondSlice (middag)
	private Timer timer3 = new Timer();		// Timer når dagen er slut (eftermiddag)  
	
	DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");	// Dato format
	LocalDate localDate = LocalDate.now();										// Henter nuværende dato 
	String s = currentDate.format(localDate);									// Formaterer nuværende dato til format 
	
	public void timer() {

		try {
	        // Kalder run(), sætter tidspunkt og ugedag i TimeKeeper ved hver deadline.    
			Date firstDeadline = dateFormatter.parse(s + " 12:29:00");
			timer1.schedule(new TimeKeeper(EnumRoomStatus.FirstSlice), firstDeadline);

			Date secondDeadline = dateFormatter.parse(s + " 12:29:10");
			timer2.schedule(new TimeKeeper(EnumRoomStatus.SecondSlice), secondDeadline);

			Date lastDeadline = dateFormatter.parse(s + " 12:29:20");
			timer3.schedule(new TimeKeeper(EnumRoomStatus.FullyBooked), lastDeadline);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
