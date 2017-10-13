package test;
import java.util.ArrayList;

import org.junit.Test;

import controlLayer.BookingCtrl;
import controlLayer.InstituteCtrl;
import controlLayer.UserCtrl;
import databaseLayer.BookingDB;
import databaseLayer.IFBookingDB;
import databaseLayer.IFInstituteDB;
import databaseLayer.IFUserDB;
import databaseLayer.InstituteDB;
import databaseLayer.UserDB;
import junit.framework.TestCase;
import modelLayer.Booking;
import modelLayer.BookingLine;
import modelLayer.Department;
import modelLayer.EnumRoomStatus;
import modelLayer.EnumRoomType;
import modelLayer.EnumWeekDay;
import modelLayer.Room;
import modelLayer.Student;

public class BookingTest extends TestCase {
	
	// Ctrl klasse objekter
	UserCtrl uCtrl = new UserCtrl();
	BookingCtrl bCtrl = new BookingCtrl();
	InstituteCtrl iCtrl = new InstituteCtrl();
	
	// DB klasse objekter
	IFUserDB userDB = new UserDB();
	IFBookingDB bookingDB = new BookingDB();
	IFInstituteDB instDB = new InstituteDB();
	
	// Model objekter
	Room r = new Room("3.33",5,true,true,EnumRoomType.Auditorium);
	Student s = new Student("Jens","Jensen","jensen@jensen.dk",9999999);
	Booking b = new Booking(s);
	
	// Oprette objekter
	public void testCreateRoom(){
		assertNotNull(r);
	}
	public void testCreateStudent(){
		assertNotNull(s);
	}
	public void testCreateBooking(){
		assertNotNull(b);
		assertNotNull(b.getS());
	}
	
	// Hente objekter fra DB

	@Test
	public void testGetBookingsByStudentNo(){
		ArrayList<Booking> bookings = new ArrayList<>();
		
		Student student = new Student("ole","olesen","ole@ucn.dk","1");
		int i = 1;
		while(i<5){
			String s = Integer.toString(i);
			String s2 = Integer.toString(i++);
			Booking b = new Booking(student);
			b.addBookingLine(new BookingLine(EnumWeekDay.Mandag,new Room(s,i,true,true,EnumRoomType.auditorium)));
			b.addBookingLine(new BookingLine(EnumWeekDay.Mandag,new Room(s2,i++,true,true,EnumRoomType.auditorium)));
			bookings.add(b);
			i++;
		}
		assertArrayEquals(bookings,bookingDB.getBookingsByStudentNo(student.getStudentNo()));
	}
	
	@Test
	public void testGetRoom(){
		Department d = new Department("UCN","Sofiendalsvej 38","9200","Aalborg","88888888");
		Room r = new Room("3.0.33",4,true,false,EnumRoomType.studyRoom);
		d.addCompositeLine(r,1);
		instDB.addDepartment(d);
		assertEquals(r.toString(),instDB.getRoom(1));
	}
	
	
	@Test
	public void testGetAllRoomsInDepartment(){
		// DB test - Få fat i alle lokaler til oversigten     
		Department d = new Department("UCN","Sofiendalsvej 38","9200","Aalborg","99999999");
		Room r = new Room("3.0.30",4,true,false,EnumRoomType.studyRoom);
		d.addCompositeLine(r,1);
		
		instDB.addDepartment(d);
		
		assertEquals(r.toString(),instDB.getAllRooms(d.getPhone()).toString());
	}
	
	@Test
	public void testGetAllComposites(){
		Department d = new Department("UCN","Sofiendalsvej 38","9200","Aalborg","66666666");
		Department d2 = new Department("UCN","Sofiendalsvej 38","9200","Aalborg","77777777");
		d.addCompositeLine(d2, 1);
		
		Department d3 = new Department("UCN","Sofiendalsvej 38","9200","Aalborg","55555555");
		Department d4 = new Department("UCN","Sofiendalsvej 38","9200","Aalborg","44444444");
		d3.addCompositeLine(d4, 1);
		
		instDB.addDepartment(d);
		instDB.addDepartment(d3);
		
		assertEquals(2,instDB.getComposites().size());
	}
	
	// Tilføje objekter til DB
	
	@Test
	public void testAddDepartment(){
		Department d = new Department("UCN2", "hobrovej 50", "9500", "hobro", "88888888");
		instDB.addDepartment(d);
		assertEquals(d.toString(), instDB.getDepartment(d.getPhone().toString()));
	}
	
	@Test
	public void testAddBooking(){
		Student s = new Student("Henrik","henrik@ucn.dk","7");
		Room r = new Room("first", 1, true, true, EnumRoomType.auditorium);
		Booking b = new Booking(s,r);
		bookingDB.addBooking(b);
		
		assertEquals(b.toString(), bookingDB.getBookingByStudentNo(s.getStudentNo()).toString());		
	}
	
	// Ændre objekter i DB
	
	@Test
	public void deleteBooking(){
		Student s = new Student("Henrik","henrik@ucn.dk","79");
		Room r = new Room("first111", 1, true, true, EnumRoomType.auditorium);
		Booking b = new Booking(s,r);
		bookingDB.addBooking(b);

		assertTrue(bookingDB.deleteBooking(bookingId));
	}
//	@Test
//	public void testGetAvailableTimes(){
//		// DB test - få fat i ledige tider for et bestemt tidspunkt
//		Department d = new Department("UCN","Sofiendalsvej 38","9200","Aalborg","99999999");
//		Room r = new Room("3.0.30",4,true,false,EnumRoomType.studyRoom);
//		d.addCompositeLine(r,1);
//		instDB.addDepartment(d);
//		
//		assertEquals(r.toString(),instDB.getAvalability(r.));
//	}
}
