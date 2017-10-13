package guiLayer;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import modelLayer.BookingLine;
import modelLayer.EnumRoomStatus;
import modelLayer.EnumRoomType;
import modelLayer.EnumWeekDay;

public class RoomRow {
	private String name;
	private EnumWeekDay weekDays;
	private int roomId;
	private int capacity;
	private boolean tv;
	private boolean projector;
	private EnumRoomType rType;
	private EnumRoomStatus rStatus;

	private SimpleStringProperty room;

	private SimpleStringProperty monday1;
	private SimpleStringProperty monday2;

	private SimpleStringProperty tuesday1;
	private SimpleStringProperty tuesday2;

	private SimpleStringProperty wednesday1;
	private SimpleStringProperty wednesday2;

	private SimpleStringProperty thursday1;
	private SimpleStringProperty thursday2;

	private SimpleStringProperty friday1;
	private SimpleStringProperty friday2;
	
	public RoomRow(String name, int roomId, int capacity, boolean tv, boolean projector, 
			EnumRoomType type, ArrayList<EnumWeekDay> wDay, ArrayList<EnumRoomStatus> time){
		this.name = name;
		this.roomId = roomId;
		this.capacity = capacity;
		this.tv = tv;
		this.projector = projector;
		this.rType = type;
		
		for(EnumWeekDay d : wDay){
			for(EnumRoomStatus s : time){
				dayAndTimeCheck(d, s);
			}
		}
	}

	public RoomRow(String name, int roomId){
		this.room = new SimpleStringProperty(name);
		this.roomId = roomId;
		this.monday1 = new SimpleStringProperty(null);
		this.monday2 = new SimpleStringProperty(null);
		this.tuesday1 = new SimpleStringProperty(null);
		this.tuesday2 = new SimpleStringProperty(null);
		this.wednesday1 = new SimpleStringProperty(null);
		this.wednesday2 = new SimpleStringProperty(null);
		this.thursday1 = new SimpleStringProperty(null);
		this.thursday2 = new SimpleStringProperty(null);
		this.friday1 = new SimpleStringProperty(null);
		this.friday2 = new SimpleStringProperty(null);
	}
	
	public RoomRow(BookingLine bl) {
		super();
		this.name = bl.getLineRoom().getName();
		this.weekDays = bl.getWeekDay();
		this.roomId = bl.getLineRoom().getRoomID();
		this.capacity = bl.getLineRoom().getCapacity();
		this.tv = bl.getLineRoom().isTv();
		this.projector = bl.getLineRoom().isProjector();
		this.rType = bl.getLineRoom().getrType();
		this.rStatus = bl.getrStatus();

		this.monday1 = new SimpleStringProperty(null);
		this.monday2 = new SimpleStringProperty(null);
		this.tuesday1 = new SimpleStringProperty(null);
		this.tuesday2 = new SimpleStringProperty(null);
		this.wednesday1 = new SimpleStringProperty(null);
		this.wednesday2 = new SimpleStringProperty(null);
		this.thursday1 = new SimpleStringProperty(null);
		this.thursday2 = new SimpleStringProperty(null);
		this.friday1 = new SimpleStringProperty(null);
		this.friday2 = new SimpleStringProperty(null);
	}
	
	private void dayAndTimeCheck(EnumWeekDay wDay, EnumRoomStatus status){
		
		if (wDay.equals(EnumWeekDay.Mandag)) {
			if (status.equals(EnumRoomStatus.Available)) {
			} else if (status.equals(EnumRoomStatus.FirstSlice)) {
				this.monday1 = new SimpleStringProperty(" ");
			} else if (status.equals(EnumRoomStatus.SecondSlice)) {
				this.monday2 = new SimpleStringProperty(" ");
			} else if (status.equals(EnumRoomStatus.FullyBooked)) {
				this.monday1 = new SimpleStringProperty(" ");
				this.monday2 = new SimpleStringProperty(" ");
			}
		} else if (wDay.equals(EnumWeekDay.Tirsdag)) {
			if (status.equals(EnumRoomStatus.Available)) {
			} else if (status.equals(EnumRoomStatus.FirstSlice)) {
				this.tuesday1 = new SimpleStringProperty(" ");
			} else if (status.equals(EnumRoomStatus.SecondSlice)) {
				this.tuesday2 = new SimpleStringProperty(" ");
			} else if (status.equals(EnumRoomStatus.FullyBooked)) {
				this.tuesday1 = new SimpleStringProperty(" ");
				this.tuesday2 = new SimpleStringProperty(" ");
			}
		} else if (wDay.equals(EnumWeekDay.Onsdag)) {
			if (status.equals(EnumRoomStatus.Available)) {
			} else if (status.equals(EnumRoomStatus.FirstSlice)) {
				this.wednesday1 = new SimpleStringProperty(" ");
			} else if (status.equals(EnumRoomStatus.SecondSlice)) {
				this.wednesday2 = new SimpleStringProperty(" ");
			} else if (status.equals(EnumRoomStatus.FullyBooked)) {
				this.wednesday1 = new SimpleStringProperty(" ");
				this.wednesday2 = new SimpleStringProperty(" ");
			}
		} else if (wDay.equals(EnumWeekDay.Torsdag)) {
			if (status.equals(EnumRoomStatus.Available)) {
			} else if (status.equals(EnumRoomStatus.FirstSlice)) {
				this.thursday1 = new SimpleStringProperty(" ");
			} else if (status.equals(EnumRoomStatus.SecondSlice)) {
				this.thursday2 = new SimpleStringProperty(" ");
			} else if (status.equals(EnumRoomStatus.FullyBooked)) {
				this.thursday1 = new SimpleStringProperty(" ");
				this.thursday2 = new SimpleStringProperty(" ");
			}
		} else if (wDay.equals(EnumWeekDay.Fredag)) {
			if (status.equals(EnumRoomStatus.Available)) {
			} else if (status.equals(EnumRoomStatus.FirstSlice)) {
				this.friday1 = new SimpleStringProperty(" ");
			} else if (status.equals(EnumRoomStatus.SecondSlice)) {
				this.friday2 = new SimpleStringProperty(" ");
			} else if (status.equals(EnumRoomStatus.FullyBooked)) {
				this.friday1 = new SimpleStringProperty(" ");
				this.friday1 = new SimpleStringProperty(" ");
			}
		} else {
			System.err.println("RoomRow virker ikke");
		}	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumWeekDay getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(EnumWeekDay weekDays) {
		this.weekDays = weekDays;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isProjector() {
		return projector;
	}

	public void setProjector(boolean projector) {
		this.projector = projector;
	}

	public EnumRoomType getrType() {
		return rType;
	}

	public void setrType(EnumRoomType rType) {
		this.rType = rType;
	}

	public EnumRoomStatus getrStatus() {
		return rStatus;
	}

	public void setrStatus(EnumRoomStatus rStatus) {
		this.rStatus = rStatus;
	}
	
	///////// Table values ///////////

	public SimpleStringProperty roomProperty() {
		return room;
	}

	public void setRoom(String room) {
		this.room = new SimpleStringProperty(room);
	}

	public SimpleStringProperty monday1Property() {
		return monday1;
	}

	public void setMonday1(String monday1) {
		this.monday1 = new SimpleStringProperty(monday1);
	}

	public SimpleStringProperty monday2Property() {
		return monday2;
	}

	public void setMonday2(String monday2) {
		this.monday2 = new SimpleStringProperty(monday2);
	}

	public SimpleStringProperty tuesday1Property() {
		return tuesday1;
	}

	public void setTuesday1(String tuesday1) {
		this.tuesday1 = new SimpleStringProperty(tuesday1);
	}

	public SimpleStringProperty tuesday2Property() {
		return tuesday2;
	}

	public void setTuesday2(String tuesday2) {
		this.tuesday2 = new SimpleStringProperty(tuesday2);
	}

	public SimpleStringProperty wednesday1Property() {
		return wednesday1;
	}

	public void setWednesday1(String wednesday1) {
		this.wednesday1 = new SimpleStringProperty(wednesday1);
	}

	public SimpleStringProperty wednesday2Property() {
		return wednesday2;
	}

	public void setWednesday2(String wednesday2) {
		this.wednesday2 = new SimpleStringProperty(wednesday2);
	}

	public SimpleStringProperty thursday1Property() {
		return thursday1;
	}

	public void setThursday1(String thursday1) {
		this.thursday1 = new SimpleStringProperty(thursday1);
	}

	public SimpleStringProperty thursday2Property() {
		return thursday2;
	}

	public void setThursday2(String thursday2) {
		this.thursday2 = new SimpleStringProperty(thursday2);
	}

	public SimpleStringProperty friday1Property() {
		return friday1;
	}

	public void setFriday1(String friday1) {
		this.friday1 = new SimpleStringProperty(friday1);
	}

	public SimpleStringProperty friday2Property() {
		return friday2;
	}

	public void setFriday2(String friday2) {
		this.friday2 = new SimpleStringProperty(friday2);
	}
}
