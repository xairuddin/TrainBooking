package com.ra.trainBooking.helper;

import com.ra.trainBooking.DTO.BookingsDTO;
import com.ra.trainBooking.model.Bookings;
import com.ra.trainBooking.model.TrainData;

public class ObjectCreationHelper {
	public static  BookingsDTO createBookingsDTO(TrainData traindata) {
		BookingsDTO bks = new BookingsDTO();

		bks.setTrainName(traindata.getTrainName());
		bks.setFilterDate(traindata.getFilterDate());
		bks.setFromDestination(traindata.getFromDestination());
		bks.setToDestination(traindata.getToDestination());
		bks.setPrice(traindata.getPrice());
		bks.setNoOfPersons(0);
		bks.setTime(traindata.getTime());
		bks.setTotalCalculated(0.0);

		return bks;
	}
	public static BookingsDTO createBookingsDTO(Bookings traindata) {
		BookingsDTO bks = new BookingsDTO();
		bks.setId(traindata.getId());

		bks.setTrainName(traindata.getTrainName());
		bks.setFilterDate(traindata.getFilterDate());
		bks.setFromDestination(traindata.getFromDestination());
		bks.setToDestination(traindata.getToDestination());
		bks.setNoOfPersons(traindata.getNoOfPersons());
		bks.setTime(traindata.getTime());
		bks.setTotalCalculated(traindata.getTotalCalculated());
		if(traindata.isTripStatus()) {
			bks.setTripStatus("Active");
		}else {
			bks.setTripStatus("Canceled");
		}
		return bks;
	}
}
