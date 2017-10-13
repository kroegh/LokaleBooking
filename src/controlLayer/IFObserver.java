package controlLayer;

import modelLayer.EnumRoomStatus;

public interface IFObserver {
	public void update(EnumRoomStatus rStatus);	
}
