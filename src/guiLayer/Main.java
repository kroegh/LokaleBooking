package guiLayer;

import java.sql.SQLException;

import controlLayer.BookingCtrl;
import controlLayer.TimeKeeper;
import databaseLayer.BookingDB;
import databaseLayer.IFBookingDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelLayer.Booking;
import modelLayer.BookingLine;
import modelLayer.EnumRoomStatus;
import modelLayer.EnumRoomType;
import modelLayer.EnumWeekDay;
import modelLayer.Room;
import modelLayer.Student;

//public class Main{
//	
//	public static void main(String[] args) {
//		
//		InstituteCtrl iCtrl = new InstituteCtrl();
//		UserCtrl uCtrl = new UserCtrl();
//		BookingCtrl bCtrl = new BookingCtrl();
//		LoginCtrl lCtrl = new LoginCtrl();
//		
//		TimeKeeper ts = new TimeKeeper();
//	}
//		
//}	

public class Main extends Application {

	@Override
	public void start(Stage stage)throws Exception {
		

		Parent root = FXMLLoader.load(getClass().getResource("CalendarUI.fxml"));

		Scene myScene = new Scene(root);
		stage.setTitle("BookingBuddy");
		stage.setScene(myScene);
		stage.show();
	}

	public static void main(String[] args) {
		
//		
//		
		
//		PowerUser pu = new PowerUser("a", "a", "a@a.a", "a", "a");
//		
//		try {
//			userDB.addPowerUser(pu);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		InstituteCtrl iCtrl = new InstituteCtrl();
//		UserCtrl uCtrl = new UserCtrl();
//		BookingCtrl bCtrl = new BookingCtrl();
//		LoginCtrl lCtrl = new LoginCtrl();
//		
		TimeKeeper ts = new TimeKeeper();
		BookingCtrl bCtrl = new BookingCtrl();
		ts.addObserver(bCtrl);

		launch(args);
	}
}

