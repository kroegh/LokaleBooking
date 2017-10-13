package controlLayer;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimerTask;
import modelLayer.EnumRoomStatus;
import modelLayer.EnumWeekDay;

/**
 * TimeKeeper keeps order on which slices that have been startet (deadlines) 
 * and the current weekday using TimerSchedule.
 * TimeKeeper is also a Subject in observer pattern, where every deadline is reportet to observe.
 * 
 * SOURCE: http://stackoverflow.com/questions/11361332/how-to-call-a-method-on-specific-time-in-java
 * 
 * @author Bjarne, Frederik, Kristoffer, Ramanan (Gruppe 2)
 * @version 0.1
 * @since 19-12-2016
 */

public class TimeKeeper extends TimerTask implements IFSubject {

	private static EnumRoomStatus currentSlice;
	private static EnumWeekDay currentWDay;
	private EnumRoomStatus slice;
	private ArrayList<IFObserver> observers;

	// Constructor that starts the timers and set current weekday.
	public TimeKeeper() {
		TimerSchedule ts = new TimerSchedule();
		ts.timer();
		getCurrentWeekDay();
		observers = new ArrayList<>();
		TimeKeeper.currentSlice = EnumRoomStatus.Available;
	}
	
	// Constructor for instances from TimerSchedule that sets the timeSlice
	public TimeKeeper(EnumRoomStatus slice) {
		this.slice = slice;
		
	}

	@Override
	public void run() {
		TimeKeeper.currentSlice = slice;
		getCurrentWeekDay();
		if(observers == null){
			System.out.println("Ingen observers tilf�jet til timeKeeper");
		} 
		else{
			notifyAllObservers();}
	}
	
	
	// gets int value for current weekday 
	// Switch case in order to transform the int value into a value in EnumWeekday
	private void getCurrentWeekDay(){
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        switch (dayOfWeek) {
            case 2:  TimeKeeper.currentWDay = EnumWeekDay.Mandag;
                     break;
            case 3:  TimeKeeper.currentWDay = EnumWeekDay.Tirsdag;
                     break;
            case 4:  TimeKeeper.currentWDay = EnumWeekDay.Onsdag;
                     break;
            case 5:  TimeKeeper.currentWDay = EnumWeekDay.Torsdag;
                     break;
            case 6:  TimeKeeper.currentWDay = EnumWeekDay.Fredag;
                     break;
            default: System.err.println("G� nu hjem......Weekend  " + "\u00A9" );;
                     break;
        }
	}
	
	// Add observers
	@Override
	public void addObserver(IFObserver o) {
		observers.add(o);
	}

	// Remove observers
	@Override
	public void removeObserver(IFObserver o) {
		observers.remove(o);
	}
	
	// All observers in the list are getting their update method called
	@Override
	public void notifyAllObservers() {
		for (IFObserver obs : observers) {
			obs.update(TimeKeeper.currentSlice);
		}
	}

	public ArrayList<IFObserver> getObservers() {
		return observers;
	}

	public static EnumRoomStatus getCurrentSlice() {
		return currentSlice;
	}

	public static EnumWeekDay getCurrentWDay() {
		return currentWDay;
	}
}
